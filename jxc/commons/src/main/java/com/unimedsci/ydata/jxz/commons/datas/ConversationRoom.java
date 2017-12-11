package com.unimedsci.ydata.jxz.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: conversation_room
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class ConversationRoom {
    /**
     * Column: conversation_room.conversation_room_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer conversationRoomId;

    /**
     *   创建时间
     * Column: conversation_room.create_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date createTime;

    /**
     *   房间类型
CHAT  聊天
INFO   消息
     * Column: conversation_room.room_type
    @mbggenerated 2017-11-30 15:36:03
     */
    private String roomType;

    /**
     *   最后更新时间
     * Column: conversation_room.last_update
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date lastUpdate;

    public Integer getConversationRoomId() {
        return conversationRoomId;
    }

    public void setConversationRoomId(Integer conversationRoomId) {
        this.conversationRoomId = conversationRoomId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}