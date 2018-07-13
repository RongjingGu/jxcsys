package com.unimedsci.ydata.jxc.main.manager;


import com.alibaba.fastjson.JSONObject;
import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxc.commons.dao.SettingsMapper;
import com.unimedsci.ydata.jxc.commons.datas.Settings;
import com.unimedsci.ydata.jxc.main.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class UserManager {

    @Autowired
    private MongoDbService mongoDbService;

    @Autowired
    SettingsMapper settingsMapper;


    public synchronized void createUser(String username, String password, String userMobile) throws Exception {
        if (mongoDbService.isExistUserName(username,"NAME"))
            throw new CustomException("该用户名已注册");
        if (mongoDbService.isExistUserName(userMobile,"MOBILE"))
            throw new CustomException("该用手机已注册");
        mongoDbService.createUser(username,password,userMobile);

    }

    public JSONObject queryUsers(Integer offset, Integer limit , String username) throws Exception{
        return mongoDbService.queryUsers(offset,limit,username);
    }

    public void login(String username, String passwrod , JSONObject object) throws Exception{
        mongoDbService.login(username,passwrod , object);
    }

    public Settings querySetting() {
        return settingsMapper.querySetting();
    }

    public void save(){
        mongoDbService.saveFile("file","gu", UUID.randomUUID().toString(),"gu");
    }

    public void download(HttpServletRequest request, HttpServletResponse response) {
        mongoDbService.downloadFile(request,response);
    }
}
