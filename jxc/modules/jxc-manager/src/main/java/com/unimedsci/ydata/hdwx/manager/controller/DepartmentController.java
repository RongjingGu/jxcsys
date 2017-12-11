package com.unimedsci.ydata.hdwx.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetw.idata.commons.DataResult;
import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxz.commons.datas.ResearchSubject;
import com.unimedsci.ydata.jxz.commons.util.Params;
import com.unimedsci.ydata.jxz.commons.util.SortDirection;
import com.unimedsci.ydata.jxc.main.manager.DepartmentManager;
import com.unimedsci.ydata.jxc.main.manager.DepartmentService;
import com.unimedsci.ydata.hdwx.settings.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by Gurongjing on 2017/11/30.
 * hfkj
 */
@Controller("departmentEdit")
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentManager departmentManager;
    private final DepartmentService departmentService;
    private final SettingsBean settingsBean;

    @Autowired
    public DepartmentController(DepartmentManager departmentManager, DepartmentService departmentService, SettingsBean settingsBean) {
        this.departmentManager = departmentManager;
        this.departmentService = departmentService;
        this.settingsBean = settingsBean;
    }

    /**
     * 添加最新动态（后台）
     *
     * @param lastTendencyTitle 动态标题
     * @param publishDay        发布时间
     * @param mainImgName       主图名称
     * @param htmlText          内容
     */
    @RequestMapping(value = "/addLastTendency", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject addLastTendency(HttpServletRequest request,
                                      @RequestParam(value = "lastTendencyTitle") String lastTendencyTitle,
                                      @RequestParam(value = "publishDay") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishDay,
                                      @RequestParam(value = "mainImgName") String mainImgName,
                                      @RequestParam(value = "htmlText") String htmlText) {
        try {

            departmentManager.insertLastTendency(lastTendencyTitle, publishDay, mainImgName, htmlText);
            JSONObject object = new JSONObject();
            object.put("success", "添加科室最新动态成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("添加科室最新动态失败");
        }
    }

    /**
     * 添加最新动态（后台）
     *
     * @param lastTendencyId 动态ID
     */
    @RequestMapping(value = "/deleteLastTendency", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject deleteLastTendency(HttpServletRequest request,
                                         @RequestParam(value = "lastTendencyId", required = false) Integer lastTendencyId) {
        try {
            departmentManager.deleteLastTendency(lastTendencyId);
            JSONObject object = new JSONObject();
            object.put("success", "删除科室最新动态成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("删除科室最新动态失败");
        }
    }

    /**
     * 添加最新动态（后台）
     *
     * @param lastTendencyTitle 动态标题
     * @param publishDay        发布时间
     * @param mainImgName       主图名称
     * @param htmlText          内容
     */
    @RequestMapping(value = "/modifyLastTendency", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject modifyLastTendency(HttpServletRequest request,
                                         @RequestParam(value = "lastTendencyId") Integer lastTendencyId,
                                         @RequestParam(value = "lastTendencyTitle") String lastTendencyTitle,
                                         @RequestParam(value = "publishDay") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishDay,
                                         @RequestParam(value = "mainImgName") String mainImgName,
                                         @RequestParam(value = "htmlText") String htmlText) {
        try {
            departmentManager.updateLastTendency(lastTendencyId, lastTendencyTitle, publishDay, mainImgName, htmlText);
            JSONObject object = new JSONObject();
            object.put("success", "修改科室最新动态成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改科室最新动态失败");
        }
    }

    /**
     * 添加会议
     *
     * @param request      request
     * @param meetingTitle 会议标题
     * @param mainImgName  主图名称
     * @param beginTime    会议开始时间
     * @param endTime      计划会议结束时间
     * @param regionId     会议地点
     * @param htmlText     会议内容
     * @return jsonObject
     */
    @RequestMapping(value = "/addMeeting", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject addMeeting(HttpServletRequest request,
                                 @RequestParam(value = "meetingTitle") String meetingTitle,
                                 @RequestParam(value = "mainImgName", required = false) String mainImgName,
                                 @RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date beginTime,
                                 @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
                                 @RequestParam(value = "regionId") Integer regionId,
                                 @RequestParam(value = "regionName", required = false) String regionName,
                                 @RequestParam(value = "htmlText", required = false) String htmlText) {
        try {
            departmentManager.addMeeting(meetingTitle, mainImgName, beginTime, endTime, regionId, regionName, htmlText);
            JSONObject object = new JSONObject();
            object.put("success", "添加科室会议成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("添加科室会议失败");
        }
    }

    /**
     * 删除科室会议（后台）
     *
     * @param request   request
     * @param meetingId 会议ID
     * @return JSONObject
     */
    @RequestMapping(value = "/deleteMeeting", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject deleteMeeting(HttpServletRequest request,
                                    @RequestParam(value = "meetingId") Integer meetingId) {
        try {
            departmentManager.deleteMeeting(meetingId);
            JSONObject object = new JSONObject();
            object.put("success", "删除科室会议成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("删除科室会议失败");
        }
    }

    /**
     * 修改会议（后台）
     *
     * @param request      request
     * @param meetingId    会议ID
     * @param meetingTitle 会议标题
     * @param mainImgName  主图名称
     * @param beginTime    会议开始时间
     * @param endTime      计划会议结束时间
     * @param regionId     会议地点
     * @param htmlText     会议内容
     * @return jsonObject
     */
    @RequestMapping(value = "/modifyMeeting", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject modifyMeeting(HttpServletRequest request,
                                    @RequestParam(value = "meetingId") Integer meetingId,
                                    @RequestParam(value = "meetingTitle") String meetingTitle,
                                    @RequestParam(value = "mainImgName", required = false) String mainImgName,
                                    @RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date beginTime,
                                    @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
                                    @RequestParam(value = "regionId") Integer regionId,
                                    @RequestParam(value = "regionName", required = false) String regionName,
                                    @RequestParam(value = "htmlText", required = false) String htmlText) {
        try {

            departmentManager.modifyMeeting(meetingId, meetingTitle, mainImgName, beginTime, endTime, regionId, regionName, htmlText);
            JSONObject object = new JSONObject();
            object.put("success", "修改会议成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改会议失败");
        }
    }

    /**
     * 添加研究课题
     *
     * @param request              request
     * @param researchSubjectTitle 研究课题标题
     * @param researchType         研究课题类型
     * @param beginTime            计划开始时间
     * @param endTime              计划结束时间
     * @param researchStatus       研究课题状态
     * @param mainImgName          主图名
     * @param malady               适应症
     * @param interveneMethod      干预手段
     * @param sponsor              申办者
     * @param cro                  这个我也不知道是什么
     * @param reseacher            主要研究者
     * @param clinicalTrailStaging 时期
     * @param htmlText             研究方案
     * @return JSONObject
     */
    @RequestMapping(value = "/addResearchSubject", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject addResearchSubject(HttpServletRequest request,
                                         @RequestParam(value = "researchSubjectTitle") String researchSubjectTitle,
                                         @RequestParam(value = "researchType", required = false) ResearchSubject.ResearchSubjectType researchType,
                                         @RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
                                         @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
                                         @RequestParam(value = "researchStatus", required = false) ResearchSubject.researchStatus researchStatus,
                                         @RequestParam(value = "mainImgName", required = false) String mainImgName,
                                         @RequestParam(value = "malady", required = false) String malady,
                                         @RequestParam(value = "interveneMethod", required = false) String interveneMethod,
                                         @RequestParam(value = "sponsor", required = false) String sponsor,
                                         @RequestParam(value = "cro", required = false) String cro,
                                         @RequestParam(value = "reseacher", required = false) String reseacher,
                                         @RequestParam(value = "clinicalTrailStaging", required = false) Integer clinicalTrailStaging,
                                         @RequestParam(value = "htmlText", required = false) String htmlText) {
        try {
            departmentManager.addResearchSubject(researchSubjectTitle, researchType, beginTime, endTime, researchStatus, mainImgName, malady, interveneMethod, sponsor, cro, reseacher, clinicalTrailStaging, htmlText);
            JSONObject object = new JSONObject();
            object.put("success", "添加科室研究课题成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("添加科室研究课题失败");
        }
    }

    /**
     * 删除科室研究课题（后台）
     *
     * @param request           request
     * @param researchSubjectId 研究课题ID
     * @return JSONObject
     */
    @RequestMapping(value = "/deleteResearchSubjectId", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject deleteResearchSubjectId(HttpServletRequest request,
                                              @RequestParam(value = "researchSubjectId") Integer researchSubjectId) {
        try {
            departmentManager.deleteResearchSubjectId(researchSubjectId);
            JSONObject object = new JSONObject();
            object.put("success", "删除科室研究课题成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("删除科室研究课题失败");
        }
    }

    /**
     * 修改科室研究课题（后台）
     *
     * @param request              request
     * @param researchSubjectId    研究课题ID
     * @param researchSubjectTitle 研究课题标题
     * @param researchType         研究课题类型
     * @param beginTime            计划开始时间
     * @param endTime              计划结束时间
     * @param researchStatus       研究课题状态
     * @param mainImgName          主图名
     * @param malady               适应症
     * @param interveneMethod      干预手段
     * @param sponsor              申办者
     * @param cro                  这个我也不知道是什么
     * @param reseacher            主要研究者
     * @param clinicalTrailStaging 时期
     * @param htmlText             研究方案
     * @return jsonObject
     */
    @RequestMapping(value = "/modifyResearchSubject", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject modifyResearchSubject(HttpServletRequest request,
                                            @RequestParam(value = "researchSubjectId") Integer researchSubjectId,
                                            @RequestParam(value = "researchSubjectTitle") String researchSubjectTitle,
                                            @RequestParam(value = "researchType", required = false) ResearchSubject.ResearchSubjectType researchType,
                                            @RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date beginTime,
                                            @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
                                            @RequestParam(value = "researchStatus", required = false) ResearchSubject.researchStatus researchStatus,
                                            @RequestParam(value = "mainImgName", required = false) String mainImgName,
                                            @RequestParam(value = "malady", required = false) String malady,
                                            @RequestParam(value = "interveneMethod", required = false) String interveneMethod,
                                            @RequestParam(value = "sponsor", required = false) String sponsor,
                                            @RequestParam(value = "cro", required = false) String cro,
                                            @RequestParam(value = "reseacher", required = false) String reseacher,
                                            @RequestParam(value = "clinicalTrailStaging", required = false) Integer clinicalTrailStaging,
                                            @RequestParam(value = "htmlText", required = false) String htmlText) {
        try {
            departmentManager.modifyResearchSubject(researchSubjectId, researchSubjectTitle, researchType, beginTime, endTime
                    , researchStatus, mainImgName, malady, interveneMethod, sponsor, cro, reseacher, clinicalTrailStaging, htmlText);
            JSONObject object = new JSONObject();
            object.put("success", "修改科室研究课题成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改科室研究课题失败");
        }
    }

    /**
     * 添加轮播图片
     *
     * @param request     request
     * @param description 描述
     * @param mainImgName 图片名
     * @param item        顺序
     * @param uri         跳转链接
     * @return JSONObject
     */
    @RequestMapping(value = "/addCarrouselImg", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject addCarrouselImg(HttpServletRequest request,
                                      @RequestParam(value = "description", required = false) String description,
                                      @RequestParam(value = "mainImgName", required = false) String mainImgName,
                                      @RequestParam(value = "item", required = false) Integer item,
                                      @RequestParam(value = "uri", required = false) String uri) {
        try {
            departmentManager.addCarrouselImg(description, mainImgName, item, uri);
            JSONObject object = new JSONObject();
            object.put("success", "添加轮播图片成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("添加轮播图片失败");
        }
    }

    /**
     * 删除科室会议（后台）
     *
     * @param request        request
     * @param carrouselImgId 会议ID
     * @return JSONObject
     */
    @RequestMapping(value = "/deleteCarrouselImg", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject deleteCarrouselImg(HttpServletRequest request,
                                         @RequestParam(value = "carrouselImgId") Integer carrouselImgId) {
        try {
            departmentManager.deleteCarrouselImg(carrouselImgId);
            JSONObject object = new JSONObject();
            object.put("success", "删除轮播图片成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("删除轮播图片失败");
        }
    }

    /**
     * 修改轮播图片（后台）
     *
     * @param carrouselImgId 轮播图片ID
     * @param request        request
     * @param description    描述
     * @param mainImgName    图片名
     * @param order          顺序
     * @param uri            跳转链接
     * @return JSONObject
     */
    @RequestMapping(value = "/modifyCarrouselImg", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject modifyCarrouselImg(HttpServletRequest request,
                                        @RequestParam(value = "carrouselImgId") Integer carrouselImgId,
                                        @RequestParam(value = "description", required = false) String description,
                                        @RequestParam(value = "mainImgName", required = false) String mainImgName,
                                        @RequestParam(value = "order", required = false) Integer order,
                                        @RequestParam(value = "uri", required = false) String uri) {
        try {

            departmentManager.modifCarrouselImg(carrouselImgId, description, mainImgName, order, uri);
            JSONObject object = new JSONObject();
            object.put("success", "修改轮播图片成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改轮播图片失败");
        }
    }

    /**
     * 修改科室信息
     *
     * @param request           request
     * @param departmentName    科室名称
     * @param departmentLogeImg loge图名称
     * @param departmentMainImg 主图名称
     * @param htmlText          介绍内容
     * @return JSONObject
     */
    @RequestMapping(value = "/modifyDepartment", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject addDepartment(HttpServletRequest request,
                                    @RequestParam(value = "departmentName") String departmentName,
                                    @RequestParam(value = "departmentLogeImg", required = false) String departmentLogeImg,
                                    @RequestParam(value = "departmentMainImg", required = false) String departmentMainImg,
                                    @RequestParam(value = "htmlText", required = false) String htmlText) {
        try {
            departmentService.updateDepartment(departmentName, departmentLogeImg, departmentMainImg, new StringBuffer(htmlText));

            JSONObject object = new JSONObject();

            object.put("success", "科室信息修改成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改科室信息失败");
        }
    }

    /**
     * 添加问题分类
     *
     * @param request      request
     * @param categoryName 描述
     * @return JSONObject
     */
    @RequestMapping(value = "/addPopularScienceCategory", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject addPopularScienceCategory(HttpServletRequest request,
                                                @RequestParam(value = "categoryName") String categoryName) {
        try {
            departmentManager.addPopularScienceCategory(categoryName);
            JSONObject object = new JSONObject();
            object.put("success", "添加问题分类成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("添加问题分类失败");
        }
    }

    /**
     * 删除问题分类（后台）
     *
     * @param request                  request
     * @param popularScienceCategoryId 问题ID
     * @return JSONObject
     */
    @RequestMapping(value = "/deletePopularScienceCategory", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject deletePopularScienceCategory(HttpServletRequest request,
                                                   @RequestParam(value = "popularScienceCategoryId") Integer popularScienceCategoryId) {
        try {
            departmentManager.deletePopularScienceCategory(popularScienceCategoryId);
            JSONObject object = new JSONObject();
            object.put("success", "删除问题分类成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("删除问题分类失败");
        }
    }

    /**
     * 修改问题分类（后台）
     *
     * @param request                  request
     * @param popularScienceCategoryId 轮播图片ID
     * @param categoryName             图片名
     * @return JSONObject
     */
    @RequestMapping(value = "/modifyPopularScienceCategory", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject modifyPopularScienceCategory(HttpServletRequest request,
                                                   @RequestParam(value = "popularScienceCategoryId") Integer popularScienceCategoryId,
                                                   @RequestParam(value = "categoryName", required = false) String categoryName) {
        try {

            departmentManager.modifyPopularScienceCategory(popularScienceCategoryId, categoryName);
            JSONObject object = new JSONObject();
            object.put("success", "修改问题分类成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改问题分类失败");
        }
    }

    /**
     * 排序问题分类
     *
     * @param params 参数
     * @return json
     */
    @RequestMapping(value = "/sortPopularScienceCategory", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject sortQuestionCategory(Params params) {
        try {
            Map<String, Object> objectMap = params.getParams();
            for (String key : objectMap.keySet()) {
                Integer popularScienceCategoryId = Integer.parseInt(key);
                Integer order = Integer.parseInt(objectMap.get(key).toString());
                departmentService.updateOrderByPrimaryKey(popularScienceCategoryId, order);
            }
            JSONObject result = new JSONObject();
            result.put("success", "调整问题分类排序成功");
            return result;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("调整问题分类排序失败");
        }
    }

    //文章开始




    /**
     * 添加文章
     *
     * @param request                  request
     * @param popularScienceTitle      主图名
     * @param mainImgName              主图名
     * @param publishTime              发布时间（日期）
     * @param popularScienceCategoryId 分类ID
     * @param htmlText                 科普内容HtmlText
     * @return JSONObject
     */
    @RequestMapping(value = "/addPopularScience", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject addPopularScience(HttpServletRequest request,
                                        @RequestParam(value = "popularScienceTitle") String popularScienceTitle,
                                        @RequestParam(value = "mainImgName") String mainImgName,
                                        @RequestParam(value = "publishTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishTime,
                                        @RequestParam(value = "popularScienceCategoryId") Integer popularScienceCategoryId,
                                        @RequestParam(value = "htmlText") String htmlText) {
        try {
            departmentManager.addPopularScience(popularScienceTitle, mainImgName, publishTime, popularScienceCategoryId, htmlText);
            JSONObject object = new JSONObject();
            object.put("success", "添加文章成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("添加文章失败");
        }
    }

    /**
     * 删除文章（后台）
     *
     * @param request          request
     * @param popularScienceId 问题ID
     * @return JSONObject
     */
    @RequestMapping(value = "/deletePopularScience", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject deletePopularScience(HttpServletRequest request,
                                           @RequestParam(value = "popularScienceId") Integer popularScienceId) {
        try {
            departmentManager.deletePopularScience(popularScienceId);
            JSONObject object = new JSONObject();
            object.put("success", "删除文章成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("删除文章失败");
        }
    }

    /**
     * 修改文章（后台）
     *
     * @param request                  request
     * @param popularScienceId         要修改ID
     * @param popularScienceTitle      主图名
     * @param mainImgName              主图名
     * @param publishTime              发布时间（日期）
     * @param popularScienceCategoryId 分类ID
     * @param htmlText                 科普内容HtmlText
     * @return JSONObject
     */
    @RequestMapping(value = "/modifyPopularScience", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject modifyPopularScience(HttpServletRequest request,
                                           @RequestParam(value = "popularScienceId") Integer popularScienceId,
                                           @RequestParam(value = "popularScienceTitle") String popularScienceTitle,
                                           @RequestParam(value = "mainImgName") String mainImgName,
                                           @RequestParam(value = "publishTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishTime,
                                           @RequestParam(value = "popularScienceCategoryId") Integer popularScienceCategoryId,
                                           @RequestParam(value = "htmlText") String htmlText) {
        try {
            departmentManager.modifyPopularScience(popularScienceId, popularScienceTitle, mainImgName, publishTime, popularScienceCategoryId, htmlText);
            JSONObject object = new JSONObject();
            object.put("success", "修改文章成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改文章失败");
        }
    }


    //文章开始
    /**
     * 添加问题库
     *
     * @param request  reuestion
     * @param question 问题标题
     * @param answer   答案
     * @param params   关键词
     * @return JSONObject
     */
    @RequestMapping(value = "/addQuestionStore", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject addQuestionStore(HttpServletRequest request,
                                       @RequestParam(value = "question", required = false) String question,
                                       @RequestParam(value = "answer", required = false) String answer,
                                       Params params) {
        try {
            departmentManager.addQuestionStore(question, answer, params.getKeywords());
            JSONObject object = new JSONObject();
            object.put("success", "添加问题库成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("添加问题库失败");
        }
    }

    /**
     * 删除问题库（后台）
     *
     * @param request         request
     * @param questionStoreId 问题ID
     * @return JSONObject
     */
    @RequestMapping(value = "/deleteQuestionStore", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject deleteQuestionStore(HttpServletRequest request,
                                          @RequestParam(value = "questionStoreId") Integer questionStoreId) {
        try {
            departmentManager.deleteQuestionStore(questionStoreId);
            JSONObject object = new JSONObject();
            object.put("success", "删除问题库成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("删除问题库失败");
        }
    }

    /**
     * 删除问题库（后台）
     *
     * @param request                request
     * @param questionStoreKeywordId 问题ID
     * @return JSONObject
     */
    @RequestMapping(value = "/deleteQuestionStoreKeyword", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject deleteQuestionStoreKeyword(HttpServletRequest request,
                                                 @RequestParam(value = "questionStoreKeywordId") Integer questionStoreKeywordId) {
        try {
            departmentManager.deleteQuestionStoreKeyword(questionStoreKeywordId);
            JSONObject object = new JSONObject();
            object.put("success", "删除问题库关键字成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("删除问题库失败");
        }
    }

    /**
     * 修改问题库（后台）
     *
     * @param request         request
     * @param questionStoreId 要修改ID
     * @return JSONObject
     */
    @RequestMapping(value = "/modifyQuestionStore", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject modifyQuestionStore(HttpServletRequest request,
                                          @RequestParam(value = "questionStoreId") Integer questionStoreId,
                                          @RequestParam(value = "question", required = false) String question,
                                          @RequestParam(value = "answer", required = false) String answer,
                                          Params params) {
        try {
            departmentManager.modifyQuestionStore(questionStoreId, question, answer, params.getKeywords());
            JSONObject object = new JSONObject();
            object.put("success", "修改问题库成功");
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("修改问题库失败");
        }
    }

    /**
     * 人员管理查看病人
     *
     * @param request          request
     * @param userCompellation 姓名
     * @param userMobile       手机号
     * @param hospitalCode     住院号
     * @param bindStatus       绑定状态
     * @return DataResult
     */
    @RequestMapping(value = "/queryPatients", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public DataResult queryPatients(HttpServletRequest request,
                                    @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                    @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                    @RequestParam(value = "sort", required = false) String sort,
                                    @RequestParam(value = "direction", required = false, defaultValue = "ASC") SortDirection direction,
                                    @RequestParam(value = "userCompellation", required = false) String userCompellation,
                                    @RequestParam(value = "userMobile", required = false) String userMobile,
                                    @RequestParam(value = "hospitalCode", required = false) String hospitalCode,
                                    @RequestParam(value = "bindStatus", required = false) String bindStatus) {
        try {
            return departmentManager.queryPatients(offset,limit,sort,direction,userCompellation, userMobile, hospitalCode, bindStatus);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查看病人失败");
        }
    }

}
