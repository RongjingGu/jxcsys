package com.unimedsci.ydata.jxc.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxc.commons.annotations.login;
import com.unimedsci.ydata.jxc.commons.datas.Settings;
import com.unimedsci.ydata.jxc.main.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping(value = "/createUser", method = {RequestMethod.GET,
            RequestMethod.POST}, headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    public JSONObject createUser(@RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "userMobile") String userMobile) {
        try {
            userManager.createUser(username, password, userMobile);
            JSONObject object = new JSONObject();
            object.put("success", "注册用户成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("注册用户失败");
        }
    }

    @RequestMapping(value = "/queryUsers", method = {RequestMethod.GET,
            RequestMethod.POST}, headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    public JSONObject queryUsers(@RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                                 @RequestParam(value = "username", required = false) String username,
                                 @RequestParam(value = "password", required = false) String password,
                                 @RequestParam(value = "userMobile", required = false) String userMobile) {
        try {
            return userManager.queryUsers(offset, limit, username);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("添加项目失败");
        }
    }


    @RequestMapping(value = "/login", method = {RequestMethod.GET,
            RequestMethod.POST}, headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @login
    public JSONObject login(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String passwrod) {
        try {
            JSONObject object = new JSONObject();
            userManager.login(username, passwrod , object);
            object.put("success", "登录成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("登录失败");
        }
    }

    @RequestMapping(value = "/querySetting", method = {RequestMethod.GET,
            RequestMethod.POST}, headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @login
    public JSONObject querySetting() {
        try {
            JSONObject object = new JSONObject();
            userManager.save();
            object.put("success", "a");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("登录失败");
        }
    }

    @RequestMapping(value = "/download", method = {RequestMethod.GET,
            RequestMethod.POST}, headers = "Accept=application/json;charset=utf-8")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        try {
            userManager.download(request,response);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("登录失败");
        }
    }
}
