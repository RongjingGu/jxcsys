package com.unimedsci.ydata.jxc.main.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2017/12/2.
 */
@Component
public class ConnListener extends BaseListener implements ConnectListener{

    public void onConnect(SocketIOClient client) {
        /*HandshakeData hdata = client.getHandshakeData();
        String sa = client.getRemoteAddress().toString();
        String clientIp = sa.substring(1,sa.indexOf(":"));//获取设备ip
                *//*System.out.println(clientIp+"-------------------------"+"客户端已连接");*//*
        Map params = client.getHandshakeData().getUrlParams();//连接时带上

        //获取客户端连接的uuid参数
        Object object = params.get("uuid");
        String uuid = "";
        if(object != null){
            uuid = ((List<String>)object).get(0);
            //将uuid和连接客户端对象进行绑定
            //this.getServer().clientsMap.put(uuid,client);
        }
        //给客户端发送消息
        client.sendEvent("connect_msg",clientIp+"客户端你好，我是服务端，能帮助你吗？");*/
    }
}
