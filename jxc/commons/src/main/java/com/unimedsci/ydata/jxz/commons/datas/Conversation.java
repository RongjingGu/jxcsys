package com.unimedsci.ydata.jxz.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: conversation
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class Conversation {
    /**
     * Column: conversation.conversation_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer conversationId;

    /**
     *   会话房间Id
     * Column: conversation.conversation_room_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer conversationRoomId;

    /**
     *   会话uuid
     * Column: conversation.conversation_room_uuid
    @mbggenerated 2017-11-30 15:36:03
     */
    private String conversationRoomUuid;

    /**
     *   是否允许上传图片
1： 允许
0：不允许
     * Column: conversation.allow_upload_img
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer allowUploadImg;

    /**
     *   会话类型
ROBOT   机器人
MANUAL   医生
USER_DEFINED 自定义
     * Column: conversation.conversation_type
    @mbggenerated 2017-11-30 15:36:03
     */
    private String conversationType;

    /**
     *   创建时间
     * Column: conversation.create_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date createTime;

    /**
     *   结束时间
     * Column: conversation.end_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date endTime;

    /**
     *   状态
OPEN  正常
CLOSE 关闭
     * Column: conversation.status
    @mbggenerated 2017-11-30 15:36:03
     */
    private String status;

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getConversationRoomId() {
        return conversationRoomId;
    }

    public void setConversationRoomId(Integer conversationRoomId) {
        this.conversationRoomId = conversationRoomId;
    }

    public String getConversationRoomUuid() {
        return conversationRoomUuid;
    }

    public void setConversationRoomUuid(String conversationRoomUuid) {
        this.conversationRoomUuid = conversationRoomUuid == null ? null : conversationRoomUuid.trim();
    }

    public Integer getAllowUploadImg() {
        return allowUploadImg;
    }

    public void setAllowUploadImg(Integer allowUploadImg) {
        this.allowUploadImg = allowUploadImg;
    }

    public String getConversationType() {
        return conversationType;
    }

    public void setConversationType(String conversationType) {
        this.conversationType = conversationType == null ? null : conversationType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}