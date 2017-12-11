package com.unimedsci.ydata.jxc.main.manager;

import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxc.commons.dao.*;
import com.unimedsci.ydata.jxc.commons.datas.*;
import com.unimedsci.ydata.jxc.commons.util.SortDirection;
import com.unimedsci.ydata.jxc.commons.util.StringUtil;
import com.unimedsci.ydata.jxc.pdmsInterface.PdmsService;
import com.unimedsci.ydata.jxc.settings.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Gurongjing on 2017/11/30.
 * hfkj
 */
@Service
public class DepartmentService {
    final String HDWX_HOSPITAL_DEPARTMENT_ID = "HDWX_HOSPITAL_DEPARTMENT_ID";

    private final SettingsBean settings;
    private final PdmsService pdmsService;
    private final LastTendencyMapper lastTendencyMapper;
    private final MeetingMapper meetingMapper;
    private final ResearchSubjectMapper researchSubjectMapper;
    private final CarrouselImgMapper carrouselImgMapper;
    private final DepartmentMapper departmentMapper;
    private final PopularScienceCategoryMapper popularScienceCategoryMapper;
    private final RegionADao regionDao;
    private final PopularScienceMapper popularScienceMapper;
    private final QuestionStoreMapper questionStoreMapper;
    private final QuestionStoreKeywordMapper questionStoreKeywordMapper;
    private final YdataAccountBindMapper ydataAccountBindMapper;

    @Autowired
    public DepartmentService(
            SettingsBean settings, PdmsService pdmsService,
                             LastTendencyMapper lastTendencyMapper,
                             MeetingMapper meetingMapper, ResearchSubjectMapper researchSubjectMapper,
                             CarrouselImgMapper carrouselImgMapper,
                             DepartmentMapper departmentMapper,
                             PopularScienceCategoryMapper popularScienceCategoryMapper,
                             RegionADao regionDao,
                             PopularScienceMapper popularScienceMapper,
                             QuestionStoreMapper questionStoreMapper,
                             QuestionStoreKeywordMapper questionStoreKeywordMapper,
                             YdataAccountBindMapper ydataAccountBindMapper) {
        this.settings = settings;
        this.pdmsService = pdmsService;

        this.lastTendencyMapper = lastTendencyMapper;
        this.meetingMapper = meetingMapper;
        this.researchSubjectMapper = researchSubjectMapper;
        this.carrouselImgMapper = carrouselImgMapper;
        this.departmentMapper = departmentMapper;
        this.popularScienceCategoryMapper = popularScienceCategoryMapper;
        this.regionDao = regionDao;
        this.popularScienceMapper = popularScienceMapper;
        this.questionStoreMapper = questionStoreMapper;
        this.questionStoreKeywordMapper = questionStoreKeywordMapper;
        this.ydataAccountBindMapper = ydataAccountBindMapper;
    }


    public List<LastTendency> queryLastTendencyList(Integer offset, Integer limit, String sort, SortDirection direction, String lastTendencyTitle, Integer lastTendencyId) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return lastTendencyMapper.queryLastTendencyList(pageBounds, lastTendencyTitle, lastTendencyId);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return lastTendencyMapper.queryLastTendencyList(pageBounds, lastTendencyTitle, lastTendencyId);
        }
    }

    public void insertLastTendency(LastTendency lastTendency) {
        lastTendencyMapper.insert(lastTendency);
    }

    public LastTendency selectLastTendencyById(Integer lastTendencyId) {
        return lastTendencyMapper.selectByPrimaryKey(lastTendencyId);
    }

    public void updateLastTendency(LastTendency lastTendency) {
        lastTendencyMapper.updateByPrimaryKey(lastTendency);
    }

    public List<Meeting> queryMeetingList(Integer offset, Integer limit, String sort, SortDirection direction, String meetingTitle, Date beginTime, Date endTime, Integer regionId, Integer meetingId) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return meetingMapper.queryMeetingList(pageBounds, meetingTitle, beginTime, endTime, regionId, meetingId);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return meetingMapper.queryMeetingList(pageBounds, meetingTitle, beginTime, endTime, regionId, meetingId);
        }
    }

    public void insertMeeting(Meeting meeting) {
        meetingMapper.insert(meeting);
    }

    public Meeting selectMeetingById(Integer meetingId) {
        return meetingMapper.selectByPrimaryKey(meetingId);
    }

    public void updateMeeting(Meeting meeting) {
        meetingMapper.updateByPrimaryKey(meeting);
    }

    public void insertResearchSubject(ResearchSubject rs) {
        researchSubjectMapper.insert(rs);
    }

    public ResearchSubject selectResearchSubjectById(Integer researchSubjectId) {
        return researchSubjectMapper.selectByPrimaryKey(researchSubjectId);
    }

    public void updateResearchSubject(ResearchSubject rs) {
        researchSubjectMapper.updateByPrimaryKey(rs);
    }

    public List<ResearchSubject> queryResearchSubjectList(Integer offset, Integer limit, String sort, SortDirection direction,
                                                          String researchSubjectTitle, ResearchSubject.ResearchSubjectType researchType,
                                                          Date beginTime, Date endTime, ResearchSubject.researchStatus researchStatus, Integer researchSubjectId) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return researchSubjectMapper.queryResearchSubjectList(pageBounds, researchSubjectTitle, researchType, beginTime, endTime, researchStatus, researchSubjectId);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return researchSubjectMapper.queryResearchSubjectList(pageBounds, researchSubjectTitle, researchType, beginTime, endTime, researchStatus, researchSubjectId);
        }
    }


    public void insertCarrouselImg(CarrouselImg ci) {
        carrouselImgMapper.insert(ci);
    }

    public CarrouselImg queryCarrouseImgByOrderId(Integer order) {
        return carrouselImgMapper.queryCarrouseImgByOrderId(order);
    }

    public CarrouselImg selectCarrouselImgById(Integer carrouselImgId) {
        return carrouselImgMapper.selectByPrimaryKey(carrouselImgId);
    }

    public void updateCarrouselImg(CarrouselImg ci) {
        carrouselImgMapper.updateByPrimaryKey(ci);
    }

    public List<CarrouselImg> queryCarrouselImgsList(Integer offset, Integer limit, String sort, SortDirection direction, Integer carrouselImgId) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return carrouselImgMapper.queryCarrouselImgsList(pageBounds, carrouselImgId);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return carrouselImgMapper.queryCarrouselImgsList(pageBounds, carrouselImgId);
        }
    }

    /*public void addDepartment(String departmentName, String departmentLogeImg, String departmentMainImg, String htmlText) {
        Department de = new Department();
        de.setDepartmentName(departmentName);
        de.setDepartmentLogeImg(departmentLogeImg);
        de.setDepartmentMainImg(departmentMainImg);
        de.setHtmlText(htmlText);
        departmentMapper.insert(de);
    }*/

   /* public Department queryDepartmentById(Integer departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }
    */
    public JSONObject queryDepartment(){
        Integer hosDepId = Integer.valueOf(settings.getValue(HDWX_HOSPITAL_DEPARTMENT_ID));

        return pdmsService.queryHosDepById(hosDepId);
    }

    public JSONObject updateDepartment(String localName,String logoImgUuid,String mainImgUuid,StringBuffer htmlText){
        Integer hosDepId = Integer.valueOf(settings.getValue(HDWX_HOSPITAL_DEPARTMENT_ID));


        return pdmsService.updateHosDep(hosDepId,localName,logoImgUuid,mainImgUuid,htmlText);
    }

    public void modifyDepartment(Integer departmentId, String departmentName, String departmentLogeImg, String departmentMainImg, String htmlText) {
        Department department = departmentMapper.selectByPrimaryKey(departmentId);
        department.setDepartmentName(departmentName);
        department.setDepartmentLogeImg(departmentLogeImg);
        department.setDepartmentMainImg(departmentMainImg);
        department.setHtmlText(htmlText);
        departmentMapper.updateByPrimaryKey(department);
    }

    public List<PopularScienceCategory> queryPopularScienceCategoryList(Integer offset, Integer limit, String sort, SortDirection direction, String categoryName) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return popularScienceCategoryMapper.queryPopularScienceCategoryList(pageBounds, categoryName);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return popularScienceCategoryMapper.queryPopularScienceCategoryList(pageBounds, categoryName);
        }
    }

    public PopularScienceCategory queryPopularScienceCategoryByName(String categoryName) {
        return popularScienceCategoryMapper.queryPopularScienceCategoryByName(categoryName);
    }

    public void insertPopularScienceCategory(PopularScienceCategory pstemp) {
        popularScienceCategoryMapper.insert(pstemp);
    }

    public PopularScienceCategory queryPopularScienceCategoryById(Integer popularScienceCategoryId) {
        return popularScienceCategoryMapper.selectByPrimaryKey(popularScienceCategoryId);
    }

    public void updatePopularScienceCategory(PopularScienceCategory ci) {
        popularScienceCategoryMapper.updateByPrimaryKey(ci);
    }

    public void updateOrderByPrimaryKey(Integer popularScienceCategoryId, Integer order) {
        popularScienceCategoryMapper.updateOrderByPrimaryKey(popularScienceCategoryId, order);
    }

    public List<Region> getRegionListByParentId(Integer parentId) {
        return regionDao.getRegionListByParentId(parentId);
    }

    public List<PopularScience> queryPopularScienceList(Integer offset, Integer limit, String sort, SortDirection direction, String popularScienceTitle, Integer popularScienceCategoryId, Integer popularScienceId) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return popularScienceMapper.queryPopularScienceList(pageBounds, popularScienceTitle, popularScienceCategoryId, popularScienceId);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return popularScienceMapper.queryPopularScienceList(pageBounds, popularScienceTitle, popularScienceCategoryId, popularScienceId);
        }
    }

    public void insertPopularScience(PopularScience ps) {
        popularScienceMapper.insert(ps);
    }

    public PopularScience queryPopularScienceById(Integer popularScienceId) {
        return popularScienceMapper.selectByPrimaryKey(popularScienceId);
    }

    public void updatePopularScience(PopularScience ps) {
        popularScienceMapper.updateByPrimaryKey(ps);
    }

    public List<QuestionStore> queryQuestionStoreList(Integer offset, Integer limit, String sort, SortDirection direction, String question, String keyword, Integer questionStoreId) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return questionStoreMapper.queryQuestionStoreList(pageBounds, question, keyword, questionStoreId);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return questionStoreMapper.queryQuestionStoreList(pageBounds, question, keyword, questionStoreId);
        }
    }

    public void insertQuestionStore(QuestionStore qs) {
        questionStoreMapper.insert(qs);
    }

    public QuestionStore queryQuestionStoreById(Integer questionStoreId) {
        return questionStoreMapper.selectByPrimaryKey(questionStoreId);
    }

    public void updateQuestionStore(QuestionStore ps) {
        questionStoreMapper.updateByPrimaryKey(ps);
    }

    public void deleteQuestionStoreKeyword(Integer questionStoreKeywordId) {
        questionStoreKeywordMapper.deleteByPrimaryKey(questionStoreKeywordId);
    }

    public void insertQuestionStoreKeyword(QuestionStoreKeyword qsk) {
        questionStoreKeywordMapper.insert(qsk);
    }

    public List<YdataAccountBind> queryYdataAccountBind(Integer offset, Integer limit, String sort, SortDirection direction, String bindStatus) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return ydataAccountBindMapper.queryYdataAccountBind(pageBounds, bindStatus);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return ydataAccountBindMapper.queryYdataAccountBind(pageBounds, bindStatus);
        }
    }

    public List<YdataAccountBind> queryYdataAccountBindYdataSearch(Integer offset, Integer limit, String sort, SortDirection direction, List<Integer> userIds, String bindStatus) {
        if (sort != null && !"".equals(sort)) {
            PageBounds pageBounds = StringUtil.orderToPageBounds(offset, limit, sort, direction);
            return ydataAccountBindMapper.queryYdataAccountBindYdataSearch(pageBounds, userIds, bindStatus);
        } else {
            PageBounds pageBounds = new PageBounds(offset, limit);
            return ydataAccountBindMapper.queryYdataAccountBindYdataSearch(pageBounds, userIds, bindStatus);
        }
    }
}
