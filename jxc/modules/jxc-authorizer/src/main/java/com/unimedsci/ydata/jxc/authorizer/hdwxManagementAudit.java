package com.unimedsci.ydata.jxc.authorizer;

import com.sweetw.idata.core.management.ManagementAudit;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Created by Alan on 2017/10/30.
 * edit
 */
public class hdwxManagementAudit implements ManagementAudit {
    private static final Logger _logger = Logger.getLogger(hdwxManagementAudit.class.getName());

    @Override
    public void log(String url, String params, String ip, HttpServletRequest httpServletRequest) {

    }
}
