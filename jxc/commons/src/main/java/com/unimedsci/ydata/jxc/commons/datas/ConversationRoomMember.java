package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: conversation_room_member
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class ConversationRoomMember {
    /**
     * Column: conversation_room_member.conversation_room_member_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer conversationRoomMemberId;

    /**
     *   房间id
     * Column: conversation_room_member.conversation_room_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer conversationRoomId;

    /**
     *   医数据账号本系统Id
     * Column: conversation_room_member.ydata_account_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer ydataAccountId;

    /**
     *   成员顺序
聊天房间 1为提问者   2为咨询对象  其它为参与者 
如果没有 1那就是匿名
消息房间 只有1 
     * Column: conversation_room_member.order
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer order;

    /**
     *   生成时间
     * Column: conversation_room_member.create_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date createTime;

    /**
     *   加入时间
     * Column: conversation_room_member.last_join_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date lastJoinTime;

    /**
     *   状态
ONLINE    在线
OFFLINE   离线
QUIT        退出
     * Column: conversation_room_member.status
    @mbggenerated 2017-11-30 15:36:03
     */
    private String status;

    /**
     *   退出时间
     * Column: conversation_room_member.quit_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date quitTime;

    /**
     * Column: conversation_room_member.last_leave_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date lastLeaveTime;

    public Integer getConversationRoomMemberId() {
        return conversationRoomMemberId;
    }

    public void setConversationRoomMemberId(Integer conversationRoomMemberId) {
        this.conversationRoomMemberId = conversationRoomMemberId;
    }

    public Integer getConversationRoomId() {
        return conversationRoomId;
    }

    public void setConversationRoomId(Integer conversationRoomId) {
        this.conversationRoomId = conversationRoomId;
    }

    public Integer getYdataAccountId() {
        return ydataAccountId;
    }

    public void setYdataAccountId(Integer ydataAccountId) {
        this.ydataAccountId = ydataAccountId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastJoinTime() {
        return lastJoinTime;
    }

    public void setLastJoinTime(Date lastJoinTime) {
        this.lastJoinTime = lastJoinTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(Date quitTime) {
        this.quitTime = quitTime;
    }

    public Date getLastLeaveTime() {
        return lastLeaveTime;
    }

    public void setLastLeaveTime(Date lastLeaveTime) {
        this.lastLeaveTime = lastLeaveTime;
    }
}