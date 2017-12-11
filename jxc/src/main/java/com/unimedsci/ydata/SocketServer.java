package com.unimedsci.ydata;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOServer;

/**
 * Created by Alan on 2017/10/26.
 */
public class SocketServer {
    public static void main(String[] args) throws InterruptedException {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);

        //config.setAllowCustomRequests(true);
        //config.setOrigin("http://localhost:4001");
        config.setOrigin(null);


        SocketIOServer server = new SocketIOServer(config);

        CharteventListener listner = new CharteventListener();
        listner.setServer(server);
        //   chatevent为事件名称
        server.addEventListener("chatevent", chatObj.class, listner);

        JoinRoomListener joinListener = new JoinRoomListener();
        joinListener.setServer(server);
        server.addEventListener("join", chatObj.class, joinListener);

        //  server.addEventListener("chat message", chatObj.class, listner);
        //启动服务
        server.start();
        Thread.sleep(Integer.MAX_VALUE);
        server.stop();
    }
}
