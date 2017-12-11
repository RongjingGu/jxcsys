package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: conversation_read_record
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class ConversationReadRecord extends ConversationReadRecordKey {
    /**
     * Column: conversation_read_record.ydata_account_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer ydataAccountId;

    /**
     * Column: conversation_read_record.create_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date createTime;

    /**
     * Column: conversation_read_record.last_update_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date lastUpdateTime;

    /**
     * Column: conversation_read_record.last_read_time
    @mbggenerated 2017-11-30 15:36:03
     */
    private Date lastReadTime;

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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(Date lastReadTime) {
        this.lastReadTime = lastReadTime;
    }
}