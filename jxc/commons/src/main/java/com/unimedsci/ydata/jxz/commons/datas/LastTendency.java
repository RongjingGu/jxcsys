package com.unimedsci.ydata.jxz.commons.datas;

import com.unimedsci.ydata.jxz.commons.util.DateFormatUtil;

import java.util.Date;

public class LastTendency {

    public static enum LastTendencyStatus {
        ACTIVE, INACTIVE
    }

    private Integer lastTendencyId;

    /**
     * 标题
     */
    private String lastTendencyTitle;

    /**
     * 主图名
     */
    private String mainImgName;

    private String mainImgUrl;

    /**
     * 发布时间（日期）
     */
    private Date publishDay;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最近修改时间
     */
    private Date modifyTime;

    /**
     * 状态
     * ACTIVE
     * INACTIVE 已删除
     */
    private LastTendencyStatus status;

    /**
     * 动态内容Html文本
     */
    private String htmlText;

    private String createTimeString;

    public String getCreateTimeString() {
        if (this.createTime != null) {
            return DateFormatUtil.getYMDHS(this.createTime);
        } else {
            return "";
        }
    }

    private String publishDayString;

    public String getPublishDayString() {
        if (this.publishDay != null) {
            return DateFormatUtil.getFormatValueYMD(this.publishDay);
        } else {
            return "";
        }
    }

    public Integer getLastTendencyId() {
        return lastTendencyId;
    }

    public void setLastTendencyId(Integer lastTendencyId) {
        this.lastTendencyId = lastTendencyId;
    }

    public String getLastTendencyTitle() {
        return lastTendencyTitle;
    }

    public void setLastTendencyTitle(String lastTendencyTitle) {
        this.lastTendencyTitle = lastTendencyTitle == null ? null : lastTendencyTitle.trim();
    }

    public String getMainImgName() {
        return mainImgName;
    }

    public void setMainImgName(String mainImgName) {
        this.mainImgName = mainImgName == null ? null : mainImgName.trim();
    }

    public Date getPublishDay() {
        return publishDay;
    }

    public void setPublishDay(Date publishDay) {
        this.publishDay = publishDay;
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

    public LastTendencyStatus getStatus() {
        return status;
    }

    public void setStatus(LastTendencyStatus status) {
        this.status = status;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText == null ? null : htmlText.trim();
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }
}