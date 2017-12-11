package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

public class PopularScience {
    public static enum PopularScienceStatus{
        ACTIVE,INACTIVE
    }

    private Integer popularScienceId;

    /**
     *   标题
     */
    private String popularScienceTitle;

    /**
     *   主图名
     */
    private String mainImgName;
    private String mainImgUrl;

    /**
     *   发布时间（日期）
     */
    private Date publishTime;

    private Integer popularScienceCategoryId;

    /**
     *   科普内容HtmlText
     */
    private String htmlText;

    private Date createTime;
    private PopularScienceStatus status;

    public Integer getPopularScienceId() {
        return popularScienceId;
    }

    public void setPopularScienceId(Integer popularScienceId) {
        this.popularScienceId = popularScienceId;
    }

    public String getPopularScienceTitle() {
        return popularScienceTitle;
    }

    public void setPopularScienceTitle(String popularScienceTitle) {
        this.popularScienceTitle = popularScienceTitle == null ? null : popularScienceTitle.trim();
    }

    public String getMainImgName() {
        return mainImgName;
    }

    public void setMainImgName(String mainImgName) {
        this.mainImgName = mainImgName == null ? null : mainImgName.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPopularScienceCategoryId() {
        return popularScienceCategoryId;
    }

    public void setPopularScienceCategoryId(Integer popularScienceCategoryId) {
        this.popularScienceCategoryId = popularScienceCategoryId;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText == null ? null : htmlText.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PopularScienceStatus getStatus() {
        return status;
    }

    public void setStatus(PopularScienceStatus status) {
        this.status = status;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }
}