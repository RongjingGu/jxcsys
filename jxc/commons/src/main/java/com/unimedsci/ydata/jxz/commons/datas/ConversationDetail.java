package com.unimedsci.ydata.jxz.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: conversation_detail
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class ConversationDetail {
    /**
     * Column: conversation_detail.conversation_detail_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Long conversationDetailId;

    /**
     * Column: conversation_detail.conversation_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer conversationId;

    /**
     *   会话来源
USER  用户
ROBOT 机器人
SYSTEM  系统提示
     * Column: conversation_detail.conversation_source
    @mbggenerated 2017-11-30 15:36:03
     */
    private String conversationSource;

    /**
     * Column: conversation_detail.msg
    @mbggenerated 2017-11-30 15:36:03
     */
    private String msg;

    /**
     * Column: conversation_detail.ydata_account_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer ydataAccountId;

    /**
     *   多媒体文件Id
     * Column: conversation_detail.media_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private String mediaId;

    /**
     *   消息时间
     * Column: conversation_detail.create_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date createTime;

    /**
     *   结构消息数据
     * Column: conversation_detail.struct_msg
    @mbggenerated 2017-11-30 15:36:03
     */
    private String structMsg;

    public Long getConversationDetailId() {
        return conversationDetailId;
    }

    public void setConversationDetailId(Long conversationDetailId) {
        this.conversationDetailId = conversationDetailId;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public String getConversationSource() {
        return conversationSource;
    }

    public void setConversationSource(String conversationSource) {
        this.conversationSource = conversationSource == null ? null : conversationSource.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Integer getYdataAccountId() {
        return ydataAccountId;
    }

    public void setYdataAccountId(Integer ydataAccountId) {
        this.ydataAccountId = ydataAccountId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStructMsg() {
        return structMsg;
    }

    public void setStructMsg(String structMsg) {
        this.structMsg = structMsg == null ? null : structMsg.trim();
    }
}