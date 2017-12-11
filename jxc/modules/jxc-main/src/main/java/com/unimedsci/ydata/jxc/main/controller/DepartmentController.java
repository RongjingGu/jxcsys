package com.unimedsci.ydata.jxc.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.sweetw.idata.commons.DataResult;
import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxc.commons.datas.*;
import com.unimedsci.ydata.jxc.main.manager.DepartmentManager;
import com.unimedsci.ydata.jxc.main.manager.DepartmentService;
import com.unimedsci.ydata.jxc.commons.util.Page;
import com.unimedsci.ydata.jxc.commons.util.SortDirection;
import com.unimedsci.ydata.jxc.settings.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alan on 2017/12/9.
 */
@Controller("departmentQuery")
@RequestMapping("/department")
public class DepartmentController {

    private final SettingsBean settings;
    private final DepartmentManager departmentManager;
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(SettingsBean settings,
                                DepartmentManager departmentManager, DepartmentService departmentService) {
        this.settings = settings;
        this.departmentManager = departmentManager;
        this.departmentService = departmentService;
    }

    /**
     * 根据父节点查询省市
     *
     * @param parentId 父节点ID
     * @return result
     */
    @RequestMapping(value = "/getRegionListByParentId", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject getRegionListByParentId(@RequestParam(value = "parentId", required = false) Integer parentId) {

        try {
            if (parentId == null) {
                List<Region> regions = new ArrayList<Region>();
                return Page.createJsonObjectResult(regions);
            }

            List<Region> regions = departmentService.getRegionListByParentId(parentId);
            return Page.createJsonObjectResult(regions);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询省市失败");
        }

    }

    /**
     * 查询最新动态（后台）
     *
     * @param request           request
     * @param offset            页数
     * @param limit             每页几个
     * @param sort              排序字段
     * @param direction         排序方向
     * @param lastTendencyTitle 最新动态标题模糊搜索
     * @param lastTendencyId    单查ID
     * @return dataResult
     */
    @RequestMapping(value = "/queryLastTendencyList", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public DataResult queryLastTendencyList(HttpServletRequest request,
                                            @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                            @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                            @RequestParam(value = "sort", required = false) String sort,
                                            @RequestParam(value = "direction", required = false, defaultValue = "ASC") SortDirection direction,
                                            @RequestParam(value = "lastTendencyTitle", required = false) String lastTendencyTitle,
                                            @RequestParam(value = "lastTendencyId", required = false) Integer lastTendencyId) {
        try {
            List<LastTendency> lastTendencies = departmentManager.queryLastTendencyList(request, offset, limit, sort, direction, lastTendencyTitle, lastTendencyId);
            return Page.createDataResult((PageList) lastTendencies);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询最新动态失败");
        }
    }


    /**
     * 查询科室会议
     *
     * @param request      request
     * @param offset       当前页
     * @param limit        每页个数
     * @param sort         排序字段
     * @param direction    排序方向
     * @param meetingTitle 会议标题
     * @param beginTime    会议开始时间
     * @param endTime      会议结束时间
     * @param regionId     会议地点
     * @param meetingId    会议单查ID
     * @return DataResult
     */
    @RequestMapping(value = "/queryMeetingList", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public DataResult queryMeetingList(HttpServletRequest request,
                                       @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                       @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                       @RequestParam(value = "sort", required = false) String sort,
                                       @RequestParam(value = "direction", required = false, defaultValue = "ASC") SortDirection direction,
                                       @RequestParam(value = "meetingTitle", required = false) String meetingTitle,
                                       @RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date beginTime,
                                       @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
                                       @RequestParam(value = "regionId", required = false) Integer regionId,
                                       @RequestParam(value = "meetingId", required = false) Integer meetingId) {
        try {
            List<Meeting> meetings = departmentManager.queryMeetingList(request, offset, limit, sort, direction, meetingTitle, beginTime, endTime, regionId, meetingId);
            return Page.createDataResult((PageList) meetings);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询科室会议失败");
        }
    }


    /**
     * 查询科室研究
     *
     * @param request              request
     * @param offset               当前页
     * @param limit                每页个数
     * @param sort                 排序字段
     * @param direction            排序方向
     * @param researchSubjectTitle 科室研究标题
     * @param researchType         科室研究类型   INTERVENTION//干预,NON_INTERVENTION//非干预
     * @param beginTime            研究开始时间
     * @param endTime              研究结束时间
     * @param researchStatus       研究状态,PREPARING//准备中,INTO//入组中,IN//入组完成,COMPLETED//已完成,INACTIVE//已删除
     * @param researchSubjectId    单查接口ID
     * @return DataResult
     */
    @RequestMapping(value = "/queryResearchSubjectList", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public DataResult queryResearchSubjectList(HttpServletRequest request,
                                               @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                               @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                               @RequestParam(value = "sort", required = false) String sort,
                                               @RequestParam(value = "direction", required = false, defaultValue = "ASC") SortDirection direction,
                                               @RequestParam(value = "researchSubjectTitle", required = false) String researchSubjectTitle,
                                               @RequestParam(value = "researchType", required = false) ResearchSubject.ResearchSubjectType researchType,
                                               @RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date beginTime,
                                               @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
                                               @RequestParam(value = "researchStatus", required = false) ResearchSubject.researchStatus researchStatus,
                                               @RequestParam(value = "researchSubjectId", required = false) Integer researchSubjectId) {
        try {
            List<ResearchSubject> researchSubjects = departmentManager.queryResearchSubjectList(request, offset, limit, sort, direction, researchSubjectTitle, researchType, beginTime, endTime, researchStatus, researchSubjectId);
            return Page.createDataResult((PageList) researchSubjects);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询科室会议失败");
        }
    }


    /**
     * 查询首页轮播图
     *
     * @param request        request
     * @param offset         当前页
     * @param limit          每页个数
     * @param sort           排序字段
     * @param direction      排序方向
     * @param carrouselImgId 单查接口ID
     * @return DataResult
     */
    @RequestMapping(value = "/queryCarrouselImgList", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public DataResult queryCarrouselImgList(HttpServletRequest request,
                                            @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                            @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                            @RequestParam(value = "sort", required = false) String sort,
                                            @RequestParam(value = "direction", required = false, defaultValue = "ASC") SortDirection direction,
                                            @RequestParam(value = "carrouselImgId", required = false) Integer carrouselImgId) {
        try {
            List<CarrouselImg> carrouselImgs = departmentManager.queryCarrouselImgsList(request, offset, limit, sort, direction, carrouselImgId);
            return Page.createDataResult((PageList) carrouselImgs);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询轮播图片失败");
        }
    }

    /**
     * 查询科室信息
     *
     * @param request request
     * @return JSONObject
     */
    @RequestMapping(value = "/queryDepartment", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public JSONObject queryDepartmentById(HttpServletRequest request) {
        try {

            JSONObject department = departmentService.queryDepartment();
            JSONObject object = new JSONObject();
            object.put("department", department);
            return object;
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询科室信息失败");
        }
    }


    /**
     * 查询问题分类
     *
     * @param request      request
     * @param offset       当前页
     * @param limit        每页个数
     * @param sort         排序字段
     * @param direction    排序方向
     * @param categoryName 问题名称
     * @return DataResult
     */
    @RequestMapping(value = "/queryPopularScienceCategoryList", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public DataResult queryPopularScienceCategoryList(HttpServletRequest request,
                                                      @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                                      @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                                      @RequestParam(value = "sort", required = false) String sort,
                                                      @RequestParam(value = "direction", required = false, defaultValue = "ASC") SortDirection direction,
                                                      @RequestParam(value = "categoryName", required = false) String categoryName) {
        try {
            List<PopularScienceCategory> ps = departmentManager.queryPopularScienceCategoryList(offset, limit, sort, direction, categoryName);
            return Page.createDataResult((PageList) ps);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询问题分类失败");
        }
    }

    /**
     * 查询科普宣教分类
     *
     * @param request             request
     * @param offset              页数
     * @param limit               个数
     * @param sort                排序字段
     * @param direction           排序方向
     * @param popularScienceTitle 问题名称
     * @return DataResult
     */
    @RequestMapping(value = "/queryPopularScienceList", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public DataResult queryPopularScienceList(HttpServletRequest request,
                                              @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                              @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                              @RequestParam(value = "sort", required = false) String sort,
                                              @RequestParam(value = "direction", required = false, defaultValue = "ASC") SortDirection direction,
                                              @RequestParam(value = "popularScienceTitle", required = false) String popularScienceTitle,
                                              @RequestParam(value = "popularScienceCategoryId", required = false) Integer popularScienceCategoryId,
                                              @RequestParam(value = "popularScienceId", required = false) Integer popularScienceId) {
        try {
            List<PopularScience> ps = departmentManager.queryPopularScienceList(request, offset, limit, sort, direction, popularScienceTitle, popularScienceCategoryId, popularScienceId);
            return Page.createDataResult((PageList) ps);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询文章失败");
        }
    }

    /**
     * 查询问题库
     *
     * @param request         request
     * @param offset          页数
     * @param limit           个数
     * @param sort            排序字段
     * @param direction       排序方向
     * @param question        问题名称
     * @param keyword         关键词
     * @param questionStoreId 单查ID
     * @return DataResult
     */
    @RequestMapping(value = "/queryQuestionStoreList", method = {RequestMethod.GET, RequestMethod.POST},
            headers = "Accept=application/json;charset=utf-8")
    @ResponseBody
    @Transactional
    public DataResult queryQuestionStoreList(HttpServletRequest request,
                                             @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
                                             @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                             @RequestParam(value = "sort", required = false) String sort,
                                             @RequestParam(value = "direction", required = false, defaultValue = "ASC") SortDirection direction,
                                             @RequestParam(value = "question", required = false) String question,
                                             @RequestParam(value = "keyword", required = false) String keyword,
                                             @RequestParam(value = "questionStoreId", required = false) Integer questionStoreId) {
        try {
            List<QuestionStore> ps = departmentManager.queryQuestionStoreList(offset, limit, sort, direction, question, keyword, questionStoreId);
            return Page.createDataResult((PageList) ps);
        } catch (CustomException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询问题库失败");
        }
    }
}
