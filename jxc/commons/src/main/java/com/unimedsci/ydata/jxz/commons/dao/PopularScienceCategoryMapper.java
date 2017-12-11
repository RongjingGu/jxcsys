package com.unimedsci.ydata.jxz.commons.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxz.commons.datas.PopularScienceCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularScienceCategoryMapper {
    int deleteByPrimaryKey(Integer popularScienceCategoryId);

    int insert(PopularScienceCategory record);

    int insertSelective(PopularScienceCategory record);

    PopularScienceCategory selectByPrimaryKey(Integer popularScienceCategoryId);

    int updateByPrimaryKeySelective(PopularScienceCategory record);

    int updateByPrimaryKey(PopularScienceCategory record);

    List<PopularScienceCategory> queryPopularScienceCategoryList(PageBounds pageBounds,
                                                                 @Param(value = "categoryName") String categoryName);

    PopularScienceCategory queryPopularScienceCategoryByName(@Param(value = "categoryName") String categoryName);


    void updateOrderByPrimaryKey(@Param(value = "popularScienceCategoryId") Integer popularScienceCategoryId,
                                 @Param(value = "order") Integer order);
}