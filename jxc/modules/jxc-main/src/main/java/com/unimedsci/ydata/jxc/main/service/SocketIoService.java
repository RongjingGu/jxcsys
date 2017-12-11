package com.unimedsci.ydata.jxc.main.service;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxc.main.listener.ListenerFactory;
import com.unimedsci.ydata.jxz.commons.util.StringUtil;
import com.unimedsci.ydata.jxc.main.data.ConversationInfo;
import com.unimedsci.ydata.jxc.main.listener.BaseListener;
import com.unimedsci.ydata.jxc.main.listener.ConnListener;
import com.unimedsci.ydata.hdwx.settings.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 2017/12/2.
 */
@Service("socketIoService")
public class SocketIoService {

    final String socketIoHostName = "SOCKET_IO_HOST_NAME";
    final String socketIoPort = "SOCKET_IO_PORT";
    static SocketIOServer server;

    @Autowired
    ConnListener connListener;

    @Autowired
    SettingsBean settings;

    @Autowired
    ListenerFactory<ConversationInfo> listenerFactory;


    static Map<String,SocketIOClient> clientsMap  = new HashMap<String, SocketIOClient>();

    public void startServer() throws InterruptedException{
        if(server != null ) return;
        Configuration config = new Configuration();
        String hostName = settings.getValue(socketIoHostName);

        if(hostName == null || "".equals(hostName)){
            throw new CustomException("未设置即时通讯主机信息");
        }

        config.setHostname(hostName);

        String port = settings.getValue(socketIoPort);

        if(port == null || "".equals(port) || !StringUtil.isNumberic(port)){
            throw new CustomException("即时通讯端口未设置或设置错误");
        }

        config.setPort(Integer.valueOf(port));

        config.setMaxFramePayloadLength(1024 * 1024);
        config.setMaxHttpContentLength(1024 * 1024);
        server = new SocketIOServer(config);

        connListener.setServer(server);
        server.addConnectListener(connListener);

        for(String eventName : listenerFactory.getListenerMap().keySet()){
            DataListener<ConversationInfo> listener = listenerFactory.getListenerMap().get(eventName);
            ((BaseListener)listener).setServer(server);
            server.addEventListener(eventName,ConversationInfo.class,listener);
        }


    }
}
