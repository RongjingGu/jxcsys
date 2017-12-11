package com.unimedsci.ydata.jxc.authorizer;

import com.sweetw.idata.commons.authorizer.RoleAuthority;
import com.sweetw.idata.commons.interceptor.RoleAuthorityManagement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ImplRoleAuthorityManagement implements RoleAuthorityManagement{
      @Autowired
      public  List<RoleAuthority> queryRoleAuthority(String roleName){
            List<RoleAuthority> ras = new ArrayList<RoleAuthority>();

            return ras;
      };

}