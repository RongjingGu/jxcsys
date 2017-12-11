package com.unimedsci.ydata.jxc.main.listener;

import com.corundumstudio.socketio.listener.DataListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 2017/12/2.
 */
@Component
@Scope("singleton")
public class ListenerFactory<T> {
    public enum ListenerType{
        JOIN,
        LEAVE,
        CHAT,
        INFO,
    }

    @Autowired
    JoinRoomListener<T> joinRoomListener;

    @Autowired
    LeaveRoomListener<T> leaveRoomListener;

    @Autowired
    ChatListener<T> chatListener;

    public Map<String, DataListener<T>> getListenerMap() {
        return listenerMap;
    }

    public void setListenerMap(Map<String, DataListener<T>> listenerMap) {
        this.listenerMap = listenerMap;
    }

    private Map<String, DataListener<T>> listenerMap;

    public ListenerFactory(){
        init();
    }

    private void init(){
        listenerMap = new HashMap<String, DataListener<T>>();

        listenerMap.put(ListenerType.JOIN.name(),joinRoomListener);
        listenerMap.put(ListenerType.LEAVE.name(),leaveRoomListener);
        listenerMap.put(ListenerType.CHAT.name(),chatListener);
    }

}
