package com.unimedsci.ydata.jxc.portal.oauth;

import com.sweetw.idata.wx.data.WxOauthAccessTokenResponse;
import com.unimedsci.ydata.jxc.commons.datas.WxBase;
import com.unimedsci.ydata.jxc.main.service.WxOauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * Created by Alan on 2017/11/21.
 */
@Component
public class OauthMainProcessor {
    private static final Logger _logger = Logger.getLogger(OauthMainProcessor.class.getName());

    @Autowired
    WxOauthService wxOauthService;

    public WxBase process(HttpServletRequest request, HttpServletResponse response,
                          String code,
                          String state,
                          String url){
        try{
            WxOauthAccessTokenResponse oauthResponse = wxOauthService.getAccessToken(code);

            HttpSession session = request.getSession();
            session.setAttribute("wxCode",code);
            WxBase wxUser = wxOauthService.getWxUserByRemote(oauthResponse);

            wxOauthService.updateWxUser(wxUser);

            return wxUser;
        }
        catch ( Exception ex){
            return null;
        }
    }







}
