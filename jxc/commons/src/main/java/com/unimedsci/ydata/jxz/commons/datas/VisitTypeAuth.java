package com.unimedsci.ydata.jxz.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: visit_type_auth
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class VisitTypeAuth {
    /**
     * Column: visit_type_auth.visit_type_auth_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer visitTypeAuthId;

    /**
     *   访视Id
     * Column: visit_type_auth.visit_type_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer visitTypeId;

    /**
     *   授权
DOCTOR 医生
ASSITANT  医助
PATIENT   患者
     * Column: visit_type_auth.auth
    @mbggenerated 2017-11-30 15:36:04
     */
    private String auth;

    public Integer getVisitTypeAuthId() {
        return visitTypeAuthId;
    }

    public void setVisitTypeAuthId(Integer visitTypeAuthId) {
        this.visitTypeAuthId = visitTypeAuthId;
    }

    public Integer getVisitTypeId() {
        return visitTypeId;
    }

    public void setVisitTypeId(Integer visitTypeId) {
        this.visitTypeId = visitTypeId;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }
}