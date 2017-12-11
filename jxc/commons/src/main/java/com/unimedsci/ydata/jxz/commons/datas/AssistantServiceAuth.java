package com.unimedsci.ydata.jxz.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: assistant_service_auth
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class AssistantServiceAuth {
    /**
     * Column: assistant_service_auth.assistant_service_auth_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer assistantServiceAuthId;

    /**
     *   医生账号id
     * Column: assistant_service_auth.doctor_account_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer doctorAccountId;

    /**
     *   申请人(医助)账号id
     * Column: assistant_service_auth.applicant_account_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer applicantAccountId;

    /**
     *   申请时间
     * Column: assistant_service_auth.application_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date applicationTime;

    /**
     *   状态
APPLYING   申请中
ACTIVE       已生效
REJECTED  已拒绝
STOP   终止
     * Column: assistant_service_auth.status
    @mbggenerated 2017-11-30 15:36:03
     */
    private String status;

    /**
     *   处理时间
     * Column: assistant_service_auth.settle_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date settleTime;

    /**
     *   备注
可填写拒绝理由等
     * Column: assistant_service_auth.comment
    @mbggenerated 2017-11-30 15:36:03
     */
    private String comment;

    /**
     *   终止时间
     * Column: assistant_service_auth.stop_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date stopTime;

    public Integer getAssistantServiceAuthId() {
        return assistantServiceAuthId;
    }

    public void setAssistantServiceAuthId(Integer assistantServiceAuthId) {
        this.assistantServiceAuthId = assistantServiceAuthId;
    }

    public Integer getDoctorAccountId() {
        return doctorAccountId;
    }

    public void setDoctorAccountId(Integer doctorAccountId) {
        this.doctorAccountId = doctorAccountId;
    }

    public Integer getApplicantAccountId() {
        return applicantAccountId;
    }

    public void setApplicantAccountId(Integer applicantAccountId) {
        this.applicantAccountId = applicantAccountId;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }
}