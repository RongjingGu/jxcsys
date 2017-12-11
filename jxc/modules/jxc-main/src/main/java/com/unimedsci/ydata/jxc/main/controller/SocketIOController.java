package com.unimedsci.ydata.jxc.main.controller;

import com.unimedsci.ydata.jxc.main.service.SocketIoServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Alan on 2017/10/27.
 */
@Controller("SocketIOController")
@RequestMapping("socketIO")
public class SocketIOController {

    @Autowired
    SocketIoServiceDemo serviceIo;

    //启动socket 服务
    @RequestMapping(value = "startServer.do")
    public void startServer(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:9092");

        //response.setHeader("Access-Control-Allow-Origin", null);
        try {
            if (serviceIo.getServer() == null) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            serviceIo.startServer();
                        } catch (InterruptedException e) {
                            //logger.error(e);
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            //logger.error(e);
            e.printStackTrace();
        }
    }
}
