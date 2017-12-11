package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: ydata_account
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class YdataAccount {
    /**
     * Column: ydata_account.ydata_account_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer ydataAccountId;

    /**
     * Column: ydata_account.ydata_uuid
    @mbggenerated 2017-11-30 15:36:04
     */
    private String ydataUuid;

    /**
     * Column: ydata_account.create_time
    @mbggenerated 2017-11-30 15:36:04
     */
    private Date createTime;

    public Integer getYdataAccountId() {
        return ydataAccountId;
    }

    public void setYdataAccountId(Integer ydataAccountId) {
        this.ydataAccountId = ydataAccountId;
    }

    public String getYdataUuid() {
        return ydataUuid;
    }

    public void setYdataUuid(String ydataUuid) {
        this.ydataUuid = ydataUuid == null ? null : ydataUuid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}