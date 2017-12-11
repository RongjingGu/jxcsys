package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: meeting
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class Meeting {

    public static enum Meetingstatus{
        ACTIVE,INACTIVE
    }
    /**
     * Column: meeting.meeting_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer meetingId;

    /**
     *   会议标题
     * Column: meeting.meeting_title
    @mbggenerated 2017-11-30 15:36:04
     */
    private String meetingTitle;

    /**
     *   会议开始时间
     * Column: meeting.begin_time
    @mbggenerated 2017-11-30 15:36:04
     */
    private Date beginTime;

    /**
     *   会议结束时间
     * Column: meeting.end_time
    @mbggenerated 2017-11-30 15:36:04
     */
    private Date endTime;

    /**
     *   主图名
     * Column: meeting.main_img_name
    @mbggenerated 2017-11-30 15:36:04
     */
    private String mainImgName;

    private String mainImgUrl;

    /**
     *   城市id（会议地点）
     * Column: meeting.location_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer locationId;

    /**
     *   城市名称（会议地点）
     * Column: meeting.location
    @mbggenerated 2017-11-30 15:36:04
     */
    private String location;

    /**
     *   创建时间
     * Column: meeting.create_time
    @mbggenerated 2017-11-30 15:36:04
     */
    private Date createTime;

    /**
     *   状态
ACTIVE 
INACTIVE  已删除
     * Column: meeting.status
    @mbggenerated 2017-11-30 15:36:04
     */
    private Meetingstatus status;

    /**
     *   会议详情Html文本
     * Column: meeting.html_text
    @mbggenerated 2017-11-30 15:36:04
     */
    private String htmlText;

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle == null ? null : meetingTitle.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMainImgName() {
        return mainImgName;
    }

    public void setMainImgName(String mainImgName) {
        this.mainImgName = mainImgName == null ? null : mainImgName.trim();
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Meetingstatus getStatus() {
        return status;
    }

    public void setStatus(Meetingstatus status) {
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