package com.unimedsci.ydata.hdwx.portal.controller;

import com.sweetw.idata.commons.data.Service;
import com.sweetw.idata.commons.utils.StringUtil;
import com.sweetw.idata.commons.utils.Utility;
import com.sweetw.idata.intrinsic.wx.Authentication;
import com.sweetw.idata.wx.data.WxPushMessage;
import com.sweetw.idata.wx.data.WxPushMessageMediaResponse;
import com.sweetw.idata.wx.data.WxPushMessageResponse;
import com.sweetw.idata.wx.global.WXGlobal;
import com.unimedsci.ydata.jxz.commons.CustomConfig;
import com.unimedsci.ydata.jxz.commons.datas.WxBase;
import com.unimedsci.ydata.hdwx.portal.oauth.OauthMainProcessor;
import com.unimedsci.ydata.hdwx.portal.processor.MainProcessor;
import com.unimedsci.ydata.hdwx.settings.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * Created by Alan on 2017/12/5.
 */
@Controller("wxController")
public class WxController {

    private static final Logger _logger = Logger.getLogger(WxController.class
            .getName());


    @Autowired
    OauthMainProcessor oauthMainProcessor;

    @Autowired
    MainProcessor mainProcessor;

    @Autowired
    SettingsBean settings;

    @Autowired
    Authentication authentication;

    @Autowired
    public CustomConfig config;

    /**
     * 微信服务主入口
     */
    @RequestMapping(value = "/main", method = { RequestMethod.GET,
            RequestMethod.POST }, headers = "Accept=text/plain;charset=utf-8")
    @Transactional
    public @ResponseBody
    String Main(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature") String signature,
            @RequestParam(value = "timestamp") String timestamp,
            @RequestParam(value = "nonce") String nonce,
            @RequestParam(value = "echostr", required = false) String echostr) {
        // _logger.info("settings test"+settings.getValue("test")+"echostr"+echostr);

        _logger.info("echostr" + echostr + "signature" + signature + "nonce"
                + nonce);

        // processor.setSettings(settings);
        String base_path = (String) request.getAttribute(Service.REQUST_BATH_PATH);
        _logger.info("url" + request.getServerName() + "basePath" + base_path);
        WXGlobal.GLOBAL_URL = request.getScheme() + "://"
                + request.getServerName() + base_path;
        _logger.info("url" + WXGlobal.GLOBAL_URL);
        WxPushMessageResponse wxResponse = new WxPushMessageResponse(); // 默认应答

        @SuppressWarnings("unused")
        PrintWriter out = null;
        String result = settings.getValue("default_welcome");
        StringBuffer xmlString = new StringBuffer();
        try {
            // out = response.getWriter();
            wxResponse.Content = settings.getValue("default_welcome");
            try {

                if (echostr == null) {
                    InputStream is = request.getInputStream();
                    String xmlRequest = StringUtil.InputStreamTOString(is);
                    _logger.info("main begin" + xmlRequest);
                    WxPushMessage pushMessage = Utility.XmlDeserialize(
                            new WxPushMessage(), xmlRequest);
                    wxResponse = WxPushMessageResponse
                            .createInstanceFromPushMessage(pushMessage);
                    _logger.info("echostr is null");
                    authentication.setAccessToken(config.getToken());
                    if (authentication.checkAuthentication(signature,
                            timestamp, nonce)) {
                        WxPushMessageMediaResponse wxMediaResponse = mainProcessor
                                .process(request, response, pushMessage);// process(request,response,pushMessage);
                        result = Utility.XmlSerialize(wxMediaResponse,
                                xmlString);
                        _logger.info("return result to wx" + result);
                        return result;
                    } else {
                        wxResponse.Content = settings
                                .getValue("default_welcome");
                    }
                } else {
                    _logger.info("echostr is not null" + "accessToken"
                            + WXGlobal.accessToken);
                    authentication.setAccessToken(config.getToken());
                    if (authentication.checkAuthentication(signature,
                            timestamp, nonce)) {
                        result = echostr;
                        _logger.info("main response checkAuthentication Ok "
                                + result);
                        return result;
                    }
                }
            } catch (Exception ex) {
                wxResponse.setContent(settings.getValue("default_welcome"));
            }
            result = Utility.XmlSerialize(wxResponse, xmlString);
        } catch (Exception ex) {
            _logger.info(settings.getValue("default_welcome"));
        }
        _logger.info("main response" + result);
        return result;
    }

    /**
     * 前端需要绑定用户的页面统一用这个接口
     * @param request
     * @param response
     * @param code
     * @param state
     * @param url
     * @param bindUrl
     * @return
     */
    @RequestMapping(value = "/oauth")
    @ResponseBody
    public String oauth(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "code") String code,
                        @RequestParam(value = "state") String state,
                        @RequestParam(value = "url", required = false, defaultValue = "")   String url,
                        @RequestParam(value = "bindUrl",required = false, defaultValue = "")   String bindUrl){
        WxBase wxBase = oauthMainProcessor.process(request,response,code,state,url);
        //ModelAndView m2v = new ModelAndView("redirectTest");

        HttpSession session = request.getSession();
        try{
            if(WxBase.WxStatus.SUBSCRIBE.equals(wxBase.getStatus())){
                //m2v.addObject("url",    url);

                session.setAttribute("openid",wxBase.getOpenid());
                response.sendRedirect(url);
            }
            else{
                session.removeAttribute("openid");
                // m2v.addObject("url",    bindUrl);
                response.sendRedirect(bindUrl);
            }
        }
        catch (Exception ex){

        }



        return null;
    }
}
