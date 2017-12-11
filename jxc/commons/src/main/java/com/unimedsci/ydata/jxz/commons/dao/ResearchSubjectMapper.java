package com.unimedsci.ydata.jxz.commons.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxz.commons.datas.ResearchSubject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ResearchSubjectMapper {
    int deleteByPrimaryKey(Integer researchSubjectId);

    int insert(ResearchSubject record);

    int insertSelective(ResearchSubject record);

    ResearchSubject selectByPrimaryKey(Integer researchSubjectId);

    int updateByPrimaryKeySelective(ResearchSubject record);

    int updateByPrimaryKey(ResearchSubject record);

    List<ResearchSubject> queryResearchSubjectList(PageBounds pageBounds,
                                                   @Param(value = "researchSubjectTitle") String researchSubjectTitle,
                                                   @Param(value = "researchType") ResearchSubject.ResearchSubjectType researchType,
                                                   @Param(value = "beginTime") Date beginTime,
                                                   @Param(value = "endTime") Date endTime,
                                                   @Param(value = "researchStatus") ResearchSubject.researchStatus researchStatus,
                                                   @Param(value = "researchSubjectId") Integer researchSubjectId);


}