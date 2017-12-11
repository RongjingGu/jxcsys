package com.unimedsci.ydata.jxc.main.service;

import com.alibaba.fastjson.JSONObject;
import com.sweetw.idata.commons.utils.RemoteService;
import com.sweetw.idata.commons.utils.Utility;
import com.sweetw.idata.wx.data.WxOauthAccessTokenRequest;
import com.sweetw.idata.wx.data.WxOauthAccessTokenResponse;
import com.sweetw.idata.wx.global.WXGlobal;
import com.unimedsci.ydata.jxc.main.InitToken;
import com.unimedsci.ydata.jxc.commons.CustomConfig;
import com.unimedsci.ydata.jxc.commons.datas.WxBase;
import com.unimedsci.ydata.jxc.commons.service.WxService;
import com.unimedsci.ydata.jxc.commons.service.YDataAccountBindService;
import com.unimedsci.ydata.jxc.commons.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alan on 2017/12/6.
 */
@Service
public class WxOauthService {
    private static final Logger _logger = Logger.getLogger(WxOauthService.class.getName());

    @Autowired
    public CustomConfig config;

    @Autowired
    InitToken initToken;

    @Autowired
    WxService wxService;

    @Autowired
    YDataAccountBindService yDataAccountBindService;

    public WxOauthAccessTokenResponse getAccessToken(String code) throws Exception {
        StringBuffer out = new StringBuffer();
        WxOauthAccessTokenRequest request = new WxOauthAccessTokenRequest();


        _logger.info("appid" + config.getAppId() + "secret" + config.getSecret());

        request.setAppid(config.getAppId());
        request.setSecret(config.getSecret());
        request.setCode(code);
        String postData = Utility.object2Form(request);

        try {
            _logger.info("url:" + WXGlobal.OAUTH_ACCESS_TOKEN_URL + "request" + postData);
            RemoteService.getResponse(WXGlobal.OAUTH_ACCESS_TOKEN_URL, "", postData, "GET", "application/X-WWW-form-urlencoded", out);
            _logger.info("getResponse" + out);

            WxOauthAccessTokenResponse response = Utility.JsonDeserialize(WxOauthAccessTokenResponse.class, out);

            _logger.info("accessToken" + response.getAccess_token());

            return response;
        } catch (Exception ex) {
            _logger.log(Level.WARNING, "获取微信服务ACCESSTOKEN失败" + ex.getMessage());
            initToken.getAccessToken();
            throw new Exception("获取微信服务ACCESSTOKEN失败");
        }
    }

    public WxBase getWxUserByRemote(WxOauthAccessTokenResponse oauthResponse) throws Exception{
        WxBase wxUser = new WxBase();
        wxUser.setOpenid(oauthResponse.getOpenid());
        //用户表还未有记录
        //https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
        _logger.info("wxuser insert");
        String arg = "access_token=" + oauthResponse.getAccess_token()+ "&";
        arg += "openid=" + oauthResponse.getOpenid() + "&";
        arg += "lang=zh_CN";
        StringBuffer response = new StringBuffer();
        //获取用户详细信息
        try {
            _logger.info("request" + arg);
            RemoteService.getResponse(WXGlobal.OAUTH_USER_INFO_URL, "", arg, "GET", "application/X-WWW-form-urlencoded", response, 15000);
            _logger.info("response" + response);
            JSONObject json = JSONObject.parseObject(response.toString());
            wxUser = Utility.JsonDeserialize(WxBase.class, response);
            //unionId 和 headimgurl在反序列化的时候应该已经set了呀，等下测试下
            /*if (json.get("unionid") != null){
                wxUser.setUnionId(json.get("unionid").toString());
            }
            wxUser.setHeadimgurl(json.get("headimgurl").toString());*/
            String nickName = wxUser.getNickname();
            String escapedNickName = StringUtil.filterNotEAndChinese(nickName);
            wxUser.setNickname(escapedNickName);
            if( wxUser.getSubscribe() != null && !"1".equals(wxUser.getSubscribe())){
                wxUser.setStatus(WxBase.WxStatus.UNSUBSCRIBE);
            }
            else{
                wxUser.setStatus(WxBase.WxStatus.SUBSCRIBE);
                if(wxUser.getSubscribe() != null){
                    wxUser.setSubscribeTime(new Date(Long.parseLong(wxUser.getSubscribe_time()) * 1000L));
                }
            }


        } catch (Exception ex) {
            _logger.log(Level.WARNING, "获取用户信息失败" + ex.getMessage());
            initToken.getAccessToken();
            throw new Exception("调用服务微信服务失败");
        }

        if (wxUser != null && wxUser.getErrcode() > 0) { //应答错误
            throw new Exception("调用服务微信服务失败["+wxUser.getErrcode()+"]");
        }

        return wxUser;
    }

    @Transactional
    public WxBase updateWxUser(WxBase wxUser) throws Exception {
        // TODO Auto-generated method stub
        _logger.info("更新微信用户信息，openid：" + wxUser.getOpenid());

        WxBase userInDB = wxService.selectByOpenid(wxUser.getOpenid());
        if (userInDB == null) {
            //还没有这个用户，新增
            wxService.insert(wxUser);
            return wxUser;
        } else {
            //已有用户要更新
            wxService.update(wxUser);

            if(WxBase.WxStatus.UNSUBSCRIBE.equals(wxUser.getStatus())){
                //如果是取关用户，要把相关医数据账号解绑
                yDataAccountBindService.unbindByOpenid(wxUser.getOpenid());
            }
            return wxUser;
        }
    }

}
