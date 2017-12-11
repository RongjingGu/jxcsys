package com.unimedsci.ydata.jxc.main.service.security;

/**
 * Created by Alan on 2017/12/8.
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unimedsci.ydata.jxc.commons.util.HdwxUserDetails;
import com.unimedsci.ydata.jxc.pdmsInterface.PdmsService;
import com.unimedsci.ydata.jxc.commons.annotations.AppUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Created by shuming.chu on 15/10/2.
 * Huifang Company
 */
public class UserDetailsManager implements UserDetailsService {

    @Autowired
    private PdmsService pdmsService;

    final private static Logger _logger = Logger.getLogger(UserDetailsManager.class.getName());
    /**
     * 此处的参数[loginId]为CAS登录画面输入的用户名
     */
    @Override
    public UserDetails loadUserByUsername(final String loginId) throws UsernameNotFoundException {

        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        String userCompellation = null;
        String userId = null;
        Integer enterpriseId = null;
        try {
            JSONObject jsonObject = pdmsService.queryAppUserByAppIdAndUserName(loginId);
            if (jsonObject != null && StringUtils.isEmpty(jsonObject.getString("error"))) {
                JSONArray appUserArray = jsonObject.getJSONArray("datas");
                boolean userActive = false;
                for(int i = 0; i < appUserArray.size(); i++) {
                    JSONObject application = appUserArray.getJSONObject(i);
                    String applicationUserType = application.getString("applicationUserType");
                    if (AppUserType.ROLE_USER.name().equals(applicationUserType)) {
                        userActive = "ACTIVE".equals(application.getString("status"));
                    }
                    if (i == 0){
                        JSONObject user = application.getJSONObject("user");
                        if (user != null) {
                            userId = user.getInteger("userId").toString();
                            userCompellation = user.getString("userCompellation");
                        }
                    }
                }
                if (userActive) {
                    for (int i = 0; i < appUserArray.size(); i++) {
                        JSONObject appUser = appUserArray.getJSONObject(i);
                        if ("ACTIVE".equals(appUser.getString("status"))) {
                            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUser.getString("applicationUserType"));
                            auths.add(authority);
                            _logger.log(Level.FINE, loginId + "|" + authority);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("UNKNOWN");
            auths.add(authority);
        }

        HdwxUserDetails hdwxUserDetails = new HdwxUserDetails(auths, userId, loginId, userCompellation);

        return hdwxUserDetails;
    }
}

