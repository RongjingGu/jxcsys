package com.unimedsci.ydata.jxc.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: research_site
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class ResearchSite {
    /**
     * Column: research_site.reseach_site_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer reseachSiteId;

    /**
     * Column: research_site.reseach_subject_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer reseachSubjectId;

    /**
     *   医院
     * Column: research_site.hospital
    @mbggenerated 2017-11-30 15:36:04
     */
    private String hospital;

    /**
     *   科室
     * Column: research_site.department
    @mbggenerated 2017-11-30 15:36:04
     */
    private String department;

    /**
     *   主要研究者
     * Column: research_site.main_researcher
    @mbggenerated 2017-11-30 15:36:04
     */
    private String mainResearcher;

    /**
     *   状态
ACTIVE 
INACTIVE
     * Column: research_site.status
    @mbggenerated 2017-11-30 15:36:04
     */
    private String status;

    public Integer getReseachSiteId() {
        return reseachSiteId;
    }

    public void setReseachSiteId(Integer reseachSiteId) {
        this.reseachSiteId = reseachSiteId;
    }

    public Integer getReseachSubjectId() {
        return reseachSubjectId;
    }

    public void setReseachSubjectId(Integer reseachSubjectId) {
        this.reseachSubjectId = reseachSubjectId;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getMainResearcher() {
        return mainResearcher;
    }

    public void setMainResearcher(String mainResearcher) {
        this.mainResearcher = mainResearcher == null ? null : mainResearcher.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}