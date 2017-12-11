package com.unimedsci.ydata.jxc.commons.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Alan on 2017/12/8.
 */
public class HdwxUserDetails implements UserDetails {

    private Collection<GrantedAuthority> auths;

    private String userId;

    private String userName;

    private String userCompellation;

    public HdwxUserDetails(Collection<GrantedAuthority> auths, String userId, String userName, String userCompellation){
        this.auths = auths;
        this.userId = userId;
        this.userName = userName;
        this.userCompellation = userCompellation;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserCompellation() {
        return userCompellation;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return auths;
    }

    @Override
    public String getPassword() {
        return "O(∩_∩)O哈哈~";
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
