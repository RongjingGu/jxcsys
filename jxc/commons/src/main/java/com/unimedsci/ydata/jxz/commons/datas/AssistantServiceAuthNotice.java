package com.unimedsci.ydata.jxz.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: assistant_service_auth_notice
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class AssistantServiceAuthNotice {
    /**
     * Column: assistant_service_auth_notice.assistant_service_auth_notice_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer assistantServiceAuthNoticeId;

    /**
     * Column: assistant_service_auth_notice.assistant_service_auth_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer assistantServiceAuthId;

    /**
     *   消息类型
APPLY 申请
PASS   申请通过
REJECTED  拒绝申请
     * Column: assistant_service_auth_notice.msg_type
    @mbggenerated 2017-11-30 15:36:03
     */
    private String msgType;

    /**
     *   通知对象的账号Id
     * Column: assistant_service_auth_notice.notice_target_acct_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer noticeTargetAcctId;

    /**
     *   状态
READ     已读
UNREAD 未读
     * Column: assistant_service_auth_notice.status
    @mbggenerated 2017-11-30 15:36:03
     */
    private String status;

    /**
     *   读取时间
     * Column: assistant_service_auth_notice.read_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date readTime;

    public Integer getAssistantServiceAuthNoticeId() {
        return assistantServiceAuthNoticeId;
    }

    public void setAssistantServiceAuthNoticeId(Integer assistantServiceAuthNoticeId) {
        this.assistantServiceAuthNoticeId = assistantServiceAuthNoticeId;
    }

    public Integer getAssistantServiceAuthId() {
        return assistantServiceAuthId;
    }

    public void setAssistantServiceAuthId(Integer assistantServiceAuthId) {
        this.assistantServiceAuthId = assistantServiceAuthId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public Integer getNoticeTargetAcctId() {
        return noticeTargetAcctId;
    }

    public void setNoticeTargetAcctId(Integer noticeTargetAcctId) {
        this.noticeTargetAcctId = noticeTargetAcctId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }
}