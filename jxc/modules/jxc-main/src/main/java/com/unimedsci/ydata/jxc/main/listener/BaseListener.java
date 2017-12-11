package com.unimedsci.ydata.jxc.main.listener;

import com.corundumstudio.socketio.SocketIOServer;

/**
 * Created by Alan on 2017/12/2.
 */
public class BaseListener {
    private SocketIOServer server;

    public SocketIOServer getServer() {
        return server;
    }

    public void setServer(SocketIOServer server) {
        this.server = server;
    }

}
