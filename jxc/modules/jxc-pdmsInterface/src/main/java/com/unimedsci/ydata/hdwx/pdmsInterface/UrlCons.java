package com.unimedsci.ydata.hdwx.pdmsInterface;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by Gurongjing on 2017/12/7.
 * edit
 */
public class UrlCons {

    public static final String PDMS_HOST = "PDMS_HOST";

    public static final String PDMS_APPLICATION_USER = "PDMS_APPLICATION_USER";

    public static final String PDMS_APPLICATION_PASSWORD = "PDMS_APPLICATION_PASSWORD";

    public static final String PDMS_LIST_ALL_PATIENT = "PDMS_LIST_ALL_PATIENT";

    public static final String HDWX_HOSPITAL_DEPARTMENT_ID = "HDWX_HOSPITAL_DEPARTMENT_ID";

    public static final String PDMS_QUERY_PATIENT = "PDMS_QUERY_PATIENT";

    public static final String PDMS_QUERY_YDATA_USER_INFO = "user/queryYdataUserInfo.do";

    public static final String PDMS_QUERY_YDATA_PATIENTS = "user/queryYdataPatients.do";


    final String PDMS_QUERY_HOS_DEP_BY_ID = "hospitalDepartment/queryHospitalDepartmentById.do";

    final String PDMS_UPDATE_HOS_DEP = "hospitalDepartment/updateHospitalDepartment.do";

    final String PDMS_QUERY_APPLICATION_USER_BY_APP_ID_AND_USER_NAME = "application/queryAppUserByAppIdAndUserName.do";
}
