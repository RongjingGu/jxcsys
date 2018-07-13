package com.unimedsci.ydata.jxc.main.fiter;

import com.alibaba.fastjson.JSONObject;
import com.sweetw.idata.commons.exception.CustomException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.unimedsci.ydata.jxc.commons.annotations.login;

public class LoginHandler implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String basePath = request.getContextPath();
        String urlPath = request.getRequestURI();
        request.setAttribute("#base_path#", basePath);
        request.setAttribute("#uri#", urlPath);
        request.setAttribute("BASE_PATH", basePath);

        if (handler instanceof HandlerMethod) {
            if (((HandlerMethod) handler).getMethodAnnotation(login.class) != null) {
                try{
                    String acctId = request.getParameter("curUserName");
                    if(acctId == null)
                        throw new CustomException("请登录");
                }
                finally {
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Access-Control-Allow-Headers", "origin,x-prototype-version,x-requested-with,accept");
                    response.setHeader("Access-Control-Allow-Credentials", "true");
                    response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin")); //
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
