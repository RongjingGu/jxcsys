package com.unimedsci.ydata.hdwx.portal.processor;

import com.sweetw.idata.commons.utils.RemoteService;
import com.sweetw.idata.commons.utils.Utility;
import com.sweetw.idata.wx.data.WxPushMessage;
import com.sweetw.idata.wx.data.WxUser;
import com.sweetw.idata.wx.global.WXGlobal;
import com.sweetw.idata.wx.process.PushMessageProcessor;
import com.unimedsci.ydata.jxz.commons.datas.WxBase;
import com.unimedsci.ydata.jxz.commons.util.StringUtil;
import com.unimedsci.ydata.jxc.main.InitToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alan on 2017/11/21.
 */
@Component
public class MainProcessor extends PushMessageProcessor {
    private static final Logger _logger = Logger.getLogger(MainProcessor.class.getName());
    @Autowired
    InitToken initToken;

    @Override
    @Transactional
    protected WxUser updateWxUser(String fromUserName) throws Exception{
        // TODO Auto-generated method stub

        _logger.info("更新用户信息" + fromUserName);
        return getWxUserByRemote(fromUserName);

    }

    private WxBase getWxUserByRemote(String openId) throws Exception{
        WxBase wxUser = new WxBase();
        wxUser.setOpenid(openId);
        //用户表还未有记录
        //https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
        _logger.info("wxuser insert");
        String arg = "access_token=" + WXGlobal.accessToken + "&";
        arg += "openid=" + openId + "&";
        arg += "lang=zh_CN";
        StringBuffer response = new StringBuffer();
        //获取用户详细信息
        try {
            _logger.info("request" + arg);
            RemoteService.getResponse(WXGlobal.USER_INFO_URL, "", arg, "GET", "application/X-WWW-form-urlencoded", response, 15000);
            _logger.info("response" + response);
            wxUser = Utility.JsonDeserialize(WxBase.class, response);
            String nickName = wxUser.getNickname();
            String escapedNickName = StringUtil.filterNotEAndChinese(nickName);
            wxUser.setNickname(escapedNickName);
            if (wxUser.getSubscribe().equals("1")) {
                wxUser.setStatus(WxBase.WxStatus.SUBSCRIBE);
                wxUser.setSubscribeTime(new Date(Long.parseLong(wxUser.getSubscribe_time()) * 1000L));
            } else{
                wxUser.setStatus(WxBase.WxStatus.UNSUBSCRIBE);
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


    @Override
    protected String getProcessClickType(WxPushMessage pushMessage, WxUser user,
                                         String sceneId, String ticket, HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        String type="";
        String eKey = pushMessage.EventKey;
        if (eKey.equals("btn_001_data")) {// 微数据
            type = HdwxProcessorFactory.TYPE.DATA.toString() ;
        }else{
            throw new Exception("无效事件");
        }
        _logger.info("process key"+eKey+"type"+type);
        return type;
    }


}
