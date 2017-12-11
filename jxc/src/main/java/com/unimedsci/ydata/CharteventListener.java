package com.unimedsci.ydata;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * Created by Alan on 2017/10/26.
 */
public class CharteventListener implements DataListener<chatObj> {
    SocketIOServer server;

    public void setServer(SocketIOServer server) {
        this.server = server;
    }

    public void onData(SocketIOClient client, chatObj data,
            AckRequest ackSender) throws Exception {
        //chatevent为 事件的名称，data为发送的内容
        if(data.getRoomId() != null && !"".equals(data.getRoomId())){
            this.server.getRoomOperations(data.getRoomId()).sendEvent("chatevent", data);
        }
        else{
            this.server.getBroadcastOperations().sendEvent("chatevent", data);
        }

        //
    }

}
