package com.unimedsci.ydata;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * Created by Alan on 2017/10/27.
 */
public class JoinRoomListener implements DataListener<chatObj> {
    SocketIOServer server;
    public void setServer(SocketIOServer server) {
        this.server = server;
    }

    public void onData(SocketIOClient client, chatObj roomMsg,
                       AckRequest ackSender) throws Exception {
        client.joinRoom(roomMsg.getRoomId());
    }
}
