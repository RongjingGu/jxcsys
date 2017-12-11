package com.unimedsci.ydata.jxc.main.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.sweetw.idata.commons.DataResult;
import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxc.commons.datas.*;
import com.unimedsci.ydata.jxc.commons.util.Page;
import com.unimedsci.ydata.jxc.commons.util.SortDirection;
import com.unimedsci.ydata.jxc.pdmsInterface.PdmsService;
import com.unimedsci.ydata.jxc.settings.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gurongjing on 2017/12/1.
 * Hfkj
 */
@Component
public class DepartmentManager {
    private final DepartmentService departmentService;
    private final ImageManager imageManager;
    private final PdmsService pdmsService;
    private final SettingsBean settingsBean;

    @Autowired
    public DepartmentManager(DepartmentService departmentService,
                             ImageManager imageManager, PdmsService pdmsService, SettingsBean settingsBean) {
        this.departmentService = departmentService;
        this.imageManager = imageManager;
        this.pdmsService = pdmsService;
        this.settingsBean = settingsBean;
    }

    public List<LastTendency> queryLastTendencyList(HttpServletRequest request, Integer offset, Integer limit, String sort, SortDirection direction, String lastTendencyTitle, Integer lastTendencyId) {
        if (sort != null && sort.equals("createTimeString")) {
            sort = "createTime";
        }
        List<LastTendency> result = departmentService.queryLastTendencyList(offset, limit, sort, direction, lastTendencyTitle, lastTendencyId);
        if (result != null && result.size() > 0) {
            for (LastTendency lastTendency : result) {
                if (lastTendency.getMainImgName() != null) {
                    lastTendency.setMainImgUrl(imageManager.generateUrlByImgUuid(lastTendency.getMainImgName(), request));
                }
            }
        }
        return result;
    }


    public void insertLastTendency(String lastTendencyTitle, Date publishDay, String mainImgName, String htmlText) {
        LastTendency lastTendency = new LastTendency();
        lastTendency.setLastTendencyTitle(lastTendencyTitle);
        lastTendency.setPublishDay(publishDay);
        lastTendency.setMainImgName(mainImgName);
        lastTendency.setHtmlText(htmlText);
        lastTendency.setStatus(LastTendency.LastTendencyStatus.ACTIVE);
        departmentService.insertLastTendency(lastTendency);
    }

    public void deleteLastTendency(Integer lastTendencyId) {
        LastTendency lastTendency = departmentService.selectLastTendencyById(lastTendencyId);
        lastTendency.setStatus(LastTendency.LastTendencyStatus.INACTIVE);
        departmentService.updateLastTendency(lastTendency);
    }

    public void updateLastTendency(Integer lastTendencyId, String lastTendencyTitle, Date publishDay, String mainImgName, String htmlText) {
        LastTendency lastTendency = departmentService.selectLastTendencyById(lastTendencyId);
        lastTendency.setLastTendencyTitle(lastTendencyTitle);
        lastTendency.setPublishDay(publishDay);
        lastTendency.setMainImgName(mainImgName);
        lastTendency.setHtmlText(htmlText);
        departmentService.updateLastTendency(lastTendency);
    }

    public List<Meeting> queryMeetingList(HttpServletRequest request, Integer offset, Integer limit, String sort, SortDirection direction, String meetingTitle, Date beginTime, Date endTime, Integer regionId, Integer meetingId) {
        List<Meeting> result = departmentService.queryMeetingList(offset, limit, sort, direction, meetingTitle, beginTime, endTime, regionId, meetingId);
        if (result != null && result.size() > 0) {
            for (Meeting meeting : result) {
                if (meeting.getMainImgName() != null) {
                    meeting.setMainImgUrl(imageManager.generateUrlByImgUuid(meeting.getMainImgName(), request));
                }
            }
        }
        return result;
    }

    public void addMeeting(String meetingTitle, String mainImgName, Date beginTime, Date endTime, Integer regionId, String regionName, String htmlText) {
        Meeting meeting = new Meeting();
        meeting.setMeetingTitle(meetingTitle);
        meeting.setMainImgName(mainImgName);
        meeting.setBeginTime(beginTime);
        meeting.setEndTime(endTime);
        meeting.setLocationId(regionId);
        meeting.setLocation(regionName);
        meeting.setHtmlText(htmlText);
        meeting.setStatus(Meeting.Meetingstatus.ACTIVE);
        departmentService.insertMeeting(meeting);
    }

    public void deleteMeeting(Integer meetingId) {
        Meeting meeting = departmentService.selectMeetingById(meetingId);
        meeting.setStatus(Meeting.Meetingstatus.INACTIVE);
        departmentService.updateMeeting(meeting);
    }

    public void modifyMeeting(Integer meetingId, String meetingTitle, String mainImgName, Date beginTime, Date endTime, Integer regionId, String regionName, String htmlText) {
        Meeting meeting = departmentService.selectMeetingById(meetingId);
        meeting.setMeetingTitle(meetingTitle);
        meeting.setMainImgName(mainImgName);
        meeting.setBeginTime(beginTime);
        meeting.setEndTime(endTime);
        meeting.setLocationId(regionId);
        meeting.setLocation(regionName);
        meeting.setHtmlText(htmlText);
        departmentService.updateMeeting(meeting);
    }

    public void addResearchSubject(String researchSubjectTitle, ResearchSubject.ResearchSubjectType researchType, Date beginTime, Date endTime,
                                   ResearchSubject.researchStatus researchStatus, String mainImgName, String malady, String interveneMethod,
                                   String sponsor, String cro, String reseacher, Integer clinicalTrailStaging, String htmlText) {
        ResearchSubject rs = new ResearchSubject();
        rs.setResearchSubjectTitle(researchSubjectTitle);
        rs.setResearchType(researchType);
        rs.setBeginTime(beginTime);
        rs.setEndTime(endTime);
        rs.setResearchStatus(researchStatus);
        rs.setMainImgName(mainImgName);
        rs.setMalady(malady);
        rs.setInterveneMethod(interveneMethod);
        rs.setSponsor(sponsor);
        rs.setCro(cro);
        rs.setReseacher(reseacher);
        rs.setClinicalTrailStaging(clinicalTrailStaging);
        rs.setHtmlText(htmlText);
        departmentService.insertResearchSubject(rs);
    }

    public void deleteResearchSubjectId(Integer researchSubjectId) {
        ResearchSubject rs = departmentService.selectResearchSubjectById(researchSubjectId);
        rs.setResearchStatus(ResearchSubject.researchStatus.INACTIVE);
        departmentService.updateResearchSubject(rs);
    }

    public void modifyResearchSubject(Integer researchSubjectId, String researchSubjectTitle,
                                      ResearchSubject.ResearchSubjectType researchType,
                                      Date beginTime, Date endTime,
                                      ResearchSubject.researchStatus researchStatus,
                                      String mainImgName, String malady,
                                      String interveneMethod, String sponsor,
                                      String cro, String reseacher, Integer clinicalTrailStaging, String htmlText) {
        ResearchSubject rs = departmentService.selectResearchSubjectById(researchSubjectId);
        rs.setResearchSubjectTitle(researchSubjectTitle);
        rs.setResearchType(researchType);
        rs.setBeginTime(beginTime);
        rs.setEndTime(endTime);
        rs.setResearchStatus(researchStatus);
        rs.setMainImgName(mainImgName);
        rs.setMalady(malady);
        rs.setInterveneMethod(interveneMethod);
        rs.setSponsor(sponsor);
        rs.setCro(cro);
        rs.setReseacher(reseacher);
        rs.setClinicalTrailStaging(clinicalTrailStaging);
        rs.setHtmlText(htmlText);
        departmentService.updateResearchSubject(rs);
    }

    public List<ResearchSubject> queryResearchSubjectList(HttpServletRequest request,
                                                          Integer offset,
                                                          Integer limit,
                                                          String sort,
                                                          SortDirection direction,
                                                          String researchSubjectTitle,
                                                          ResearchSubject.ResearchSubjectType researchType,
                                                          Date beginTime,
                                                          Date endTime,
                                                          ResearchSubject.researchStatus researchStatus,
                                                          Integer researchSubjectId) {
        List<ResearchSubject> result = departmentService.queryResearchSubjectList(offset, limit, sort, direction, researchSubjectTitle, researchType, beginTime, endTime, researchStatus, researchSubjectId);
        if (result != null && result.size() > 0) {
            for (ResearchSubject researchSubject : result) {
                if (researchSubject.getMainImgName() != null) {
                    researchSubject.setMainImgUrl(imageManager.generateUrlByImgUuid(researchSubject.getMainImgName(), request));
                }
            }
        }
        return result;
    }

    public void addCarrouselImg(String description, String mainImgName, Integer order, String uri) {
        if (order != null) {
            CarrouselImg carrouselImg = departmentService.queryCarrouseImgByOrderId(order);
            if (carrouselImg != null)
                //customException
                throw new CustomException("该轮播顺序以存在不能添加");
        }
        CarrouselImg ci = new CarrouselImg();
        ci.setDescription(description);
        ci.setMainImgName(mainImgName);
        ci.setItem(order);
        ci.setUri(uri);
        ci.setStatus(CarrouselImg.CarrouselImgstatus.ACTIVE);
        departmentService.insertCarrouselImg(ci);
    }

    public void deleteCarrouselImg(Integer carrouselImgId) {
        CarrouselImg ci = departmentService.selectCarrouselImgById(carrouselImgId);
        ci.setStatus(CarrouselImg.CarrouselImgstatus.INACTIVE);
        departmentService.updateCarrouselImg(ci);
    }

    public void modifCarrouselImg(Integer carrouselImgId, String description, String mainImgName, Integer order, String uri) {
        if (order != null) {
            CarrouselImg carrouselImg = departmentService.queryCarrouseImgByOrderId(order);
            if (carrouselImg != null)
                //customException
                throw new CustomException("该轮播顺序以存在不能修改");
        }
        CarrouselImg ci = departmentService.selectCarrouselImgById(carrouselImgId);
        ci.setDescription(description);
        ci.setMainImgName(mainImgName);
        ci.setItem(order);
        ci.setUri(uri);
        departmentService.updateCarrouselImg(ci);

    }

    public List<CarrouselImg> queryCarrouselImgsList(HttpServletRequest request, Integer offset, Integer limit, String sort, SortDirection direction, Integer carrouselImgId) {
        if (sort != null && sort.equals("order")) {
            sort = "`order`";
        }
        List<CarrouselImg> result = departmentService.queryCarrouselImgsList(offset, limit, sort, direction, carrouselImgId);
        if (result != null && result.size() > 0) {
            for (CarrouselImg carrouselImg : result) {
                if (carrouselImg.getMainImgName() != null) {
                    carrouselImg.setMainImgUrl(imageManager.generateUrlByImgUuid(carrouselImg.getMainImgName(), request));
                }
            }
        }
        return result;
    }

    public List<PopularScienceCategory> queryPopularScienceCategoryList(Integer offset, Integer limit, String sort, SortDirection direction, String categoryName) {
        return departmentService.queryPopularScienceCategoryList(offset, limit, sort, direction, categoryName);
    }

    public void addPopularScienceCategory(String categoryName) {
        PopularScienceCategory ps = departmentService.queryPopularScienceCategoryByName(categoryName);
        if (ps != null) {
            throw new CustomException("该问题分类已存在不可添加");
        }
        PopularScienceCategory pstemp = new PopularScienceCategory();
        pstemp.setCategoryName(categoryName);
        departmentService.insertPopularScienceCategory(pstemp);
    }

    public void deletePopularScienceCategory(Integer popularScienceCategoryId) {
        PopularScienceCategory ci = departmentService.queryPopularScienceCategoryById(popularScienceCategoryId);
        ci.setStatus(PopularScienceCategory.PopularScienceCategoryStatus.INACTIVE);
        departmentService.updatePopularScienceCategory(ci);
    }

    public void modifyPopularScienceCategory(Integer popularScienceCategoryId, String categoryName) {
        PopularScienceCategory ci = departmentService.queryPopularScienceCategoryById(popularScienceCategoryId);
        ci.setCategoryName(categoryName);
        departmentService.updatePopularScienceCategory(ci);
    }

    public List<PopularScience> queryPopularScienceList(HttpServletRequest request, Integer offset, Integer limit, String sort, SortDirection direction, String popularScienceTitle, Integer popularScienceCategoryId, Integer popularScienceId) {
        List<PopularScience> result = departmentService.queryPopularScienceList(offset, limit, sort, direction, popularScienceTitle, popularScienceCategoryId, popularScienceId);
        if (result != null && result.size() > 0) {
            for (PopularScience popularScience : result) {
                if (popularScience.getMainImgName() != null) {
                    popularScience.setMainImgUrl(imageManager.generateUrlByImgUuid(popularScience.getMainImgName(), request));
                }
            }
        }
        return result;
    }

    public void addPopularScience(String popularScienceTitle, String mainImgName, Date publishTime, Integer popularScienceCategoryId, String htmlText) {
        PopularScience ps = new PopularScience();
        ps.setPopularScienceTitle(popularScienceTitle);
        ps.setPublishTime(publishTime);
        ps.setMainImgName(mainImgName);
        ps.setPopularScienceCategoryId(popularScienceCategoryId);
        ps.setHtmlText(htmlText);
        ps.setStatus(PopularScience.PopularScienceStatus.ACTIVE);
        departmentService.insertPopularScience(ps);
    }

    public void deletePopularScience(Integer popularScienceId) {
        PopularScience ps = departmentService.queryPopularScienceById(popularScienceId);
        ps.setStatus(PopularScience.PopularScienceStatus.INACTIVE);
        departmentService.updatePopularScience(ps);
    }

    public void modifyPopularScience(Integer popularScienceId, String popularScienceTitle, String mainImgName, Date publishTime, Integer popularScienceCategoryId, String htmlText) {
        PopularScience ps = departmentService.queryPopularScienceById(popularScienceId);
        ps.setPopularScienceTitle(popularScienceTitle);
        ps.setMainImgName(mainImgName);
        ps.setPublishTime(publishTime);
        ps.setPopularScienceCategoryId(popularScienceCategoryId);
        ps.setHtmlText(htmlText);
        departmentService.updatePopularScience(ps);
    }

    public List<QuestionStore> queryQuestionStoreList(Integer offset, Integer limit, String sort, SortDirection direction, String question, String keyword, Integer questionStoreId) {
        return departmentService.queryQuestionStoreList(offset, limit, sort, direction, question, keyword, questionStoreId);
    }

    public void addQuestionStore(String question, String answer, List<String> keywords) {
        QuestionStore qs = new QuestionStore();
        qs.setQuestion(question);
        qs.setAnswer(answer);
        qs.setStatus(QuestionStore.QuestionStoreStatus.ACTIVE);

        insertQuestionStoreKeyword(keywords, qs.getQuestionStoreId());
    }

    public void deleteQuestionStore(Integer questionStoreId) {
        QuestionStore ps = departmentService.queryQuestionStoreById(questionStoreId);
        ps.setStatus(QuestionStore.QuestionStoreStatus.INACTIVE);
        departmentService.updateQuestionStore(ps);
    }

    public void deleteQuestionStoreKeyword(Integer questionStoreKeywordId) {
        departmentService.deleteQuestionStoreKeyword(questionStoreKeywordId);
    }

    public void modifyQuestionStore(Integer questionStoreId, String question, String answer, List<String> keywords) {
        QuestionStore qs = departmentService.queryQuestionStoreById(questionStoreId);
        qs.setQuestion(question);
        qs.setAnswer(answer);
        departmentService.updateQuestionStore(qs);
        insertQuestionStoreKeyword(keywords, questionStoreId);
    }

    private void insertQuestionStoreKeyword(List<String> keywords, Integer questionStoreId) {
        if (keywords != null && keywords.size() > 0) {
            for (String keyword : keywords) {
                QuestionStoreKeyword qsk = new QuestionStoreKeyword();
                qsk.setQuestionStoreId(questionStoreId);
                qsk.setKeyword(keyword);
                departmentService.insertQuestionStoreKeyword(qsk);
            }
        }
    }

    public DataResult queryPatients(Integer offset, Integer limit, String sort, SortDirection direction, String userCompellation, String userMobile, String hospitalCode, String bindStatus) {
        if (userCompellation == null && userMobile == null && hospitalCode == null) {
            //没有ydata数据库搜索的过程
            List<YdataAccountBind> result = departmentService.queryYdataAccountBind(offset, limit, sort, direction, bindStatus);
            if (result != null && result.size() > 0) {
                List<Integer> userIds = getYdataUserIds(result);
                JSONObject object = pdmsService.queryYdataUserInfo(userIds);
                changeYdataAccount(result, object);
            }
            return Page.createDataResult((PageList) result);
        } else {
            //有ydata数据库搜索的过程
            Integer investigationId = Integer.valueOf(settingsBean.getValue("HDWX_INVESTIGATION_ID"));
            JSONObject result = pdmsService.queryYdataPatients(investigationId, userCompellation, userMobile, hospitalCode);
            //得到所有ydataids
            List<Integer> userIds = makeYdataUserIds(result);
            List<YdataAccountBind> result1 = departmentService.queryYdataAccountBindYdataSearch(offset, limit, sort, direction, userIds,bindStatus);
            changeYdataAccount(result1,result);
            return Page.createDataResult((PageList) result1);
        }
    }

    private List<Integer> makeYdataUserIds(JSONObject result) {
        List<Integer> userIds = new ArrayList<Integer>();
        JSONArray array = result.getJSONArray("data");
        if (array != null && array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                Integer userId = array.getJSONObject(i).getInteger("userId");
                if (userId != null)
                    userIds.add(userId);
            }
        }
        return userIds;
    }

    /**
     * 将ydata查出的信息赋值给result
     *
     * @param result result
     * @param object object
     */
    private void changeYdataAccount(List<YdataAccountBind> result, JSONObject object) {
        JSONArray array = object.getJSONArray("data");
        for (YdataAccountBind yb : result) {
            if (array != null && array.size() > 0) {
                for (int i = 0; i < array.size(); i++) {
                    JSONObject object1 = array.getJSONObject(i);
                    if (object1.getInteger("userId").equals(yb.getYdataUuid())) {
                        yb.setUserCompellation(object1.getString("userCompellation"));
                        yb.setUserMobile(object1.getString("userMobile"));
                        yb.setHospitalCode(object1.getString("hospitalCode"));
                    }
                }
            }

        }
    }

    private List<Integer> getYdataUserIds(List<YdataAccountBind> result) {
        List<Integer> userIds = new ArrayList<Integer>();
        for (YdataAccountBind ydataAccountBind : result) {
            userIds.add(ydataAccountBind.getYdataUuid());
        }
        return userIds;
    }
}
