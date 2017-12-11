package com.unimedsci.ydata.jxz.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: doctor_group_member
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class DoctorGroupMember {
    /**
     * Column: doctor_group_member.doctor_group_member_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer doctorGroupMemberId;

    /**
     * Column: doctor_group_member.doctor_group_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer doctorGroupId;

    /**
     * Column: doctor_group_member.ydata_account_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer ydataAccountId;

    /**
     *   ״̬
ACTIVE
INACTIVE
     * Column: doctor_group_member.create_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date createTime;

    /**
     * Column: doctor_group_member.status
    @mbggenerated 2017-11-30 15:36:03
     */
    private String status;

    public Integer getDoctorGroupMemberId() {
        return doctorGroupMemberId;
    }

    public void setDoctorGroupMemberId(Integer doctorGroupMemberId) {
        this.doctorGroupMemberId = doctorGroupMemberId;
    }

    public Integer getDoctorGroupId() {
        return doctorGroupId;
    }

    public void setDoctorGroupId(Integer doctorGroupId) {
        this.doctorGroupId = doctorGroupId;
    }

    public Integer getYdataAccountId() {
        return ydataAccountId;
    }

    public void setYdataAccountId(Integer ydataAccountId) {
        this.ydataAccountId = ydataAccountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}