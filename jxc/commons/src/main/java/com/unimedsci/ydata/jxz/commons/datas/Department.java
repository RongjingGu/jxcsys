package com.unimedsci.ydata.jxz.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: department
@mbggenerated do_not_delete_during_merge 2017-12-01 13:09:15
 */
public class Department {
    private Integer departmentId;

    /**
     *   科室名称
     */
    private String departmentName;

    /**
     *   loge图名称
     */
    private String departmentLogeImg;

    /**
     *   主图名称
     */
    private String departmentMainImg;

    /**
     */
    private String htmlText;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentLogeImg() {
        return departmentLogeImg;
    }

    public void setDepartmentLogeImg(String departmentLogeImg) {
        this.departmentLogeImg = departmentLogeImg == null ? null : departmentLogeImg.trim();
    }

    public String getDepartmentMainImg() {
        return departmentMainImg;
    }

    public void setDepartmentMainImg(String departmentMainImg) {
        this.departmentMainImg = departmentMainImg == null ? null : departmentMainImg.trim();
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText == null ? null : htmlText.trim();
    }
}