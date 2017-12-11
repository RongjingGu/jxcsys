package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: hot_conversation
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class HotConversation {
    /**
     * Column: hot_conversation.hot_conversation_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer hotConversationId;

    /**
     * Column: hot_conversation.conversation_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer conversationId;

    /**
     *   是否置顶
     * Column: hot_conversation.is_top
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer isTop;

    /**
     *   置顶时间
     * Column: hot_conversation.top_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date topTime;

    /**
     * Column: hot_conversation.create_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date createTime;

    /**
     *   最近一次设置为热门咨询的时间
     * Column: hot_conversation.hot_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date hotTime;

    /**
     *   状态
ACTIVE
INACTIVE
     * Column: hot_conversation.status
    @mbggenerated 2017-11-30 15:36:03
     */
    private String status;

    public Integer getHotConversationId() {
        return hotConversationId;
    }

    public void setHotConversationId(Integer hotConversationId) {
        this.hotConversationId = hotConversationId;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Date getTopTime() {
        return topTime;
    }

    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getHotTime() {
        return hotTime;
    }

    public void setHotTime(Date hotTime) {
        this.hotTime = hotTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}