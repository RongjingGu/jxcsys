package com.unimedsci.ydata.jxc.pdmsInterface;

import com.alibaba.fastjson.JSONObject;
import com.sweetw.idata.commons.exception.CustomException;
import com.sweetw.idata.commons.utils.RemoteService;
import com.unimedsci.ydata.jxc.commons.util.StringUtil;
import com.unimedsci.ydata.jxc.settings.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gurongjing on 2017/12/7.
 * edite
 */
@Service
@Transactional(propagation = Propagation.NESTED)
public class PdmsService extends UrlCons {

    final static Logger _logger = Logger.getLogger(PdmsService.class.getName());


    private final SettingsBean settings;

    @Autowired
    public PdmsService(SettingsBean settings) {
        this.settings = settings;
    }

    private JSONObject getPdmsResponse(String url, String arg) {
        try {
            String host = settings.getValue(PDMS_HOST);
//            host = "http://localhost:12002/interface/";
            StringBuffer out = new StringBuffer();
            if (StringUtil.isEmpty(url)) {
                throw new CustomException("配置错误，服务名称为空");
            }
            _logger.info("url[" + host + url + "?" + arg + "]");
            RemoteService.getResponse(host + url, "", arg, "POST", "application/x-www-form-urlencoded", out, 200000);
            _logger.info("response" + out.toString());
            JSONObject jsonObject = JSONObject.parseObject(out.toString());
            if (jsonObject != null && !StringUtils.isEmpty(jsonObject.getString("error"))) {
                throw new CustomException(jsonObject.getString("error"));
            }
            return jsonObject;
        } catch (CustomException ex) {
            throw ex;
        } catch (Exception e) {
            _logger.log(Level.FINE, e.getMessage());
            throw new CustomException("网络连接异常或接口数据错误");
        }
    }

    /**
     * 查看说有用户
     *
     * @return jsonObject
     * @throws Exception exception
     */
    public JSONObject listAllPatient() throws Exception {
        String url = settings.getValue(PDMS_LIST_ALL_PATIENT);
        String arg = "";
        return getPdmsResponse(url, arg);
    }


    public JSONObject queryYdataPatients(Integer investigationId, String userCompellation, String userMobile, String hospitalCode) {
        String url = PDMS_QUERY_YDATA_PATIENTS;

        StringBuilder arg = new StringBuilder();
        arg.append("investigationId=").append(investigationId);
        if (userCompellation != null && !userCompellation.equals("")) {
            arg.append("&userCompellation=").append(userCompellation);
        }
        if (userMobile != null && !userMobile.equals("")) {
            arg.append("&userMobile=").append(userMobile);
        }
        if (hospitalCode != null && !hospitalCode.equals("")) {
            arg.append("&hospitalCode=").append(hospitalCode);
        }
        return getPdmsResponse(url, arg.toString());
    }

    public JSONObject queryYdataUserInfo(List<Integer> userIds) {
        String url = PDMS_QUERY_YDATA_USER_INFO;
        StringBuilder arg = new StringBuilder();
        Integer i = 0;
        for (Integer userId : userIds) {
            arg.append("userIds["+i+"]=").append(userId).append("&");
            i += 1;
        }
        return getPdmsResponse(url, arg.toString());
    }


    /**
     * 根据用户名和应用ID获取用户在该应用中的角色
     *
     * @return 返回应用
     */
    public JSONObject queryAppUserByAppIdAndUserName(String userName) {
        String url = PDMS_QUERY_APPLICATION_USER_BY_APP_ID_AND_USER_NAME;//settings.getValue(YDATA_QUERY_APPLICATION_USER_BY_APP_ID_AND_USER_NAME);
        String args = "userName=" + userName;
        return getPdmsResponse(url, args);
    }

    /**
     * 查询医院科室信息
     *
     * @return 返回医院科室信息
     */
    public JSONObject queryHosDepById(Integer hosDepId) {
        String url = PDMS_QUERY_HOS_DEP_BY_ID;//settings.getValue(YDATA_QUERY_APPLICATION_USER_BY_APP_ID_AND_USER_NAME);
        String args = "hospitalDepartmentId=" + hosDepId;
        return getPdmsResponse(url, args);
    }

    /**
     * 修改医院科室信息
     *
     * @return 返回
     */
    public JSONObject updateHosDep(Integer hosDepId,
                                   String localName, String logoImgUuid, String mainImgUuid,StringBuffer htmlText){
        String url = PDMS_UPDATE_HOS_DEP;//settings.getValue(YDATA_QUERY_APPLICATION_USER_BY_APP_ID_AND_USER_NAME);
        String args = "hospitalDepartmentId=" + hosDepId + "&localName=" +localName
                + "&logoImgUuid=" + logoImgUuid + "&mainImgUuid=" + mainImgUuid
                + "&htmlText=" + htmlText.toString();
        return getPdmsResponse(url, args);
    }
}
