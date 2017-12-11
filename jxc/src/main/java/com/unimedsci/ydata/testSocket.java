package com.unimedsci.ydata;

import org.json.JSONObject;

import io.socket.emitter.Emitter;
import io.socket.engineio.client.Socket;

/**
 * Created by Alan on 2017/10/26.
 */
public class testSocket {
    public static void main(String[] args)  {
        System.out.println(111);
        Socket socket ;
        try {

            socket = new Socket("ws://localhost:8888?user_id=xs01&user_name=xs01");
            //socket = new Socket("ws://localhost");
//          socket.on(Socket.EVENT_OPEN, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//              //socket.send("hi");
//              socket.close();
//            }
//          });
            socket.open();

            //socket.connect();

            // Receiving an object
            socket.on("broadcast event", new Emitter.Listener() {
                //@Override
                public void call(Object... args) {
                    JSONObject obj = (JSONObject)args[0];
                    System.out.println(obj.toString());
                }
            });

            JSONObject obj = new JSONObject();
            obj.put("uuid", "123");
            socket.emit("join info", obj);


            // Sending an object
            //Thread.currentThread().sleep(Integer.MAX_VALUE);

            while(true) {
                System.out.println("===");
                obj = new JSONObject();
                obj.put("user_id", "xs01");
                obj.put("user_name", "xs01");
                obj.put("score", "100");

                socket.emit("broadcast event", obj);
                Thread.currentThread().sleep(1000);
                socket.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
