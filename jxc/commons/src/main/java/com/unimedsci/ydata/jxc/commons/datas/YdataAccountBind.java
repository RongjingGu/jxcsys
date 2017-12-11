package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: ydata_account_bind
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class YdataAccountBind {
    public enum Status{
        ACTIVE,
        INACTIVE,
    }

    /**
     * Column: ydata_account_bind.ydata_account_bind_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer ydataAccountBindId;

    /**
     * Column: ydata_account_bind.ydata_account_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer ydataAccountId;

    /**
     * Column: ydata_account_bind.open_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private String openId;

    /**
     *   绑定时间
     * Column: ydata_account_bind.create_time
    @mbggenerated 2017-11-30 15:36:04
     */
    private Date createTime;

    /**
     *   解绑时间
     * Column: ydata_account_bind.modify_time
    @mbggenerated 2017-11-30 15:36:04
     */
    private Date modifyTime;

    /**
     *   状态
ACTIVE   已绑定
INACTIVE  已解绑
     * Column: ydata_account_bind.status
    @mbggenerated 2017-11-30 15:36:04
     */
    private Status status;

    /**
     *   绑定账号类型
PAT  患者
DOC 医生
     * Column: ydata_account_bind.acct_type
    @mbggenerated 2017-11-30 15:36:04
     */
    private String acctType;

    private Integer ydataUuid;

    private String userCompellation;
    private String userMobile;
    private String hospitalCode;

    public Integer getYdataAccountBindId() {
        return ydataAccountBindId;
    }

    public void setYdataAccountBindId(Integer ydataAccountBindId) {
        this.ydataAccountBindId = ydataAccountBindId;
    }

    public Integer getYdataAccountId() {
        return ydataAccountId;
    }

    public void setYdataAccountId(Integer ydataAccountId) {
        this.ydataAccountId = ydataAccountId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType == null ? null : acctType.trim();
    }

    public Integer getYdataUuid() {
        return ydataUuid;
    }

    public void setYdataUuid(Integer ydataUuid) {
        this.ydataUuid = ydataUuid;
    }

    public String getUserCompellation() {
        return userCompellation;
    }

    public void setUserCompellation(String userCompellation) {
        this.userCompellation = userCompellation;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }
}