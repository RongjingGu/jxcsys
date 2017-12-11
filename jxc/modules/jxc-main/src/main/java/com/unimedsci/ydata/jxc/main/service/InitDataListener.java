package com.unimedsci.ydata.jxc.main.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by casteloyee on 2017/1/16.
 * Huifang Company
 */
public class InitDataListener implements InitializingBean, ServletContextAware {


    @Override
    public void afterPropertiesSet() throws Exception {
        
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
