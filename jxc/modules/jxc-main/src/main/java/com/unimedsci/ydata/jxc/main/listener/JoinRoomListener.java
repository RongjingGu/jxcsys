package com.unimedsci.ydata.jxc.main.listener;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2017/11/30.
 */

@Component
public class JoinRoomListener<ConversationInfo> extends BaseListener implements DataListener<ConversationInfo> {

    @Override
    public void onData(SocketIOClient client, ConversationInfo roomMsg,
                       AckRequest ackSender) throws Exception {
        //client.joinRoom(roomMsg.getRoomId());
    }
}
