package com.unimedsci.ydata.jxc.main.data;

/**
 * Created by Alan on 2017/10/26.
 */

/**
 * demo使用
 */
public class chatObj {
    private String userName;
         private String message;

        public chatObj() {}

        public chatObj(String userName, String message) {
        super();
        this.userName = userName;
        this.message = message;
    }

        public String getUserName() {
        return userName;
    }

        public void setUserName(String userName) {
        this.userName = userName;
    }

        public String getMessage() {
        return message;
    }

        public void setMessage(String message) {
        this.message = message;
    }

        private String typeMsg;

    public String getTypeMsg() {
        return typeMsg;
    }

    public void setTypeMsg(String typeMsg) {
        this.typeMsg = typeMsg;
    }

    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
