package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: research_subject
 *
 * @mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class ResearchSubject {

    public static enum ResearchSubjectType {
        INTERVENTION,//干预
        NON_INTERVENTION//非干预
    }

    public static enum researchStatus {
        PREPARING,// 准备中
        INTO,//  入组中
        IN,//  入组完成
        COMPLETED,//已完成
        INACTIVE,//已删除
    }

    /**
     * Column: research_subject.research_subject_id
     *
     * @mbggenerated 2017-11-30 15:36:04
     */
    private Integer researchSubjectId;

    /**
     * 研究课题名称
     */
    private String researchSubjectTitle;

    /**
     * 研究类型
     * INTERVENTION 干预
     * NON-INTERVENTION  非干预
     */
    private ResearchSubjectType researchType;

    /**
     * 研究开始时间
     */
    private Date beginTime;

    /**
     * 研究
     */
    private Date endTime;

    /**
     * 研究状态
     * PREPARING 准备中
     * INTO   入组中
     * IN       入组完成
     * COMPLETED 已完成
     */
    private researchStatus researchStatus;

    /**
     * 主图名
     */
    private String mainImgName;
    private String mainImgUrl;

    /**
     * 适应症
     */
    private String malady;

    /**
     * 干预手段
     */
    private String interveneMethod;

    /**
     * 申办者
     */
    private String sponsor;

    /**
     * 这个我也不知道是什么
     */
    private String cro;

    /**
     * 主要研究者
     */
    private String reseacher;

    /**
     * 临床试验分期
     * 999    不适用
     * 1        I期
     * 2        II期
     * 3        III期
     * 4        IV期
     */
    public static final Integer clinicalTrailStagingONE = 1;
    public static final Integer clinicalTrailStagingTWO = 2;
    public static final Integer clinicalTrailStagingTHREE = 3;
    public static final Integer clinicalTrailStagingTFORE = 4;
    public static final Integer clinicalTrailStagingNotApplicable = 999;
    private Integer clinicalTrailStaging;

    private Date createTime;

    private Date modifyTime;

    /**
     * 研究方案
     */
    private String htmlText;

    public Integer getResearchSubjectId() {
        return researchSubjectId;
    }

    public void setResearchSubjectId(Integer researchSubjectId) {
        this.researchSubjectId = researchSubjectId;
    }

    public String getResearchSubjectTitle() {
        return researchSubjectTitle;
    }

    public void setResearchSubjectTitle(String researchSubjectTitle) {
        this.researchSubjectTitle = researchSubjectTitle == null ? null : researchSubjectTitle.trim();
    }

    public ResearchSubjectType getResearchType() {
        return researchType;
    }

    public void setResearchType(ResearchSubjectType researchType) {
        this.researchType = researchType;
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

    public ResearchSubject.researchStatus getResearchStatus() {
        return researchStatus;
    }

    public void setResearchStatus(ResearchSubject.researchStatus researchStatus) {
        this.researchStatus = researchStatus;
    }

    public String getMainImgName() {
        return mainImgName;
    }

    public void setMainImgName(String mainImgName) {
        this.mainImgName = mainImgName == null ? null : mainImgName.trim();
    }

    public String getMalady() {
        return malady;
    }

    public void setMalady(String malady) {
        this.malady = malady == null ? null : malady.trim();
    }

    public String getInterveneMethod() {
        return interveneMethod;
    }

    public void setInterveneMethod(String interveneMethod) {
        this.interveneMethod = interveneMethod == null ? null : interveneMethod.trim();
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro == null ? null : cro.trim();
    }

    public String getReseacher() {
        return reseacher;
    }

    public void setReseacher(String reseacher) {
        this.reseacher = reseacher == null ? null : reseacher.trim();
    }

    public Integer getClinicalTrailStaging() {
        return clinicalTrailStaging;
    }

    public void setClinicalTrailStaging(Integer clinicalTrailStaging) {
        this.clinicalTrailStaging = clinicalTrailStaging;
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