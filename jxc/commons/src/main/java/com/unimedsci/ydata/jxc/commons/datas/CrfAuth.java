package com.unimedsci.ydata.jxc.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: crf_auth
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class CrfAuth {
    /**
     * Column: crf_auth.crf_auth_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer crfAuthId;

    /**
     * Column: crf_auth.visit_type_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer visitTypeId;

    /**
     * Column: crf_auth.module_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer moduleId;

    /**
     *   授权
DOCTOR
     * Column: crf_auth.auth
    @mbggenerated 2017-11-30 15:36:03
     */
    private String auth;

    public Integer getCrfAuthId() {
        return crfAuthId;
    }

    public void setCrfAuthId(Integer crfAuthId) {
        this.crfAuthId = crfAuthId;
    }

    public Integer getVisitTypeId() {
        return visitTypeId;
    }

    public void setVisitTypeId(Integer visitTypeId) {
        this.visitTypeId = visitTypeId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }
}