package com.unimedsci.ydata.jxz.commons.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxz.commons.datas.PopularScience;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularScienceMapper {
    int deleteByPrimaryKey(Integer popularScienceId);

    int insert(PopularScience record);

    int insertSelective(PopularScience record);

    PopularScience selectByPrimaryKey(Integer popularScienceId);

    int updateByPrimaryKeySelective(PopularScience record);

    int updateByPrimaryKeyWithBLOBs(PopularScience record);

    int updateByPrimaryKey(PopularScience record);

    List<PopularScience> queryPopularScienceList(PageBounds pageBounds,
                                                 @Param(value = "popularScienceTitle") String popularScienceTitle,
                                                 @Param(value = "popularScienceCategoryId") Integer popularScienceCategoryId,
                                                 @Param(value = "popularScienceId") Integer popularScienceId);
}