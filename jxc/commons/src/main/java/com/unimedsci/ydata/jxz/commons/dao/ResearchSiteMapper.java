package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.ResearchSite;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchSiteMapper {
    int deleteByPrimaryKey(Integer reseachSiteId);

    int insert(ResearchSite record);

    int insertSelective(ResearchSite record);

    ResearchSite selectByPrimaryKey(Integer reseachSiteId);

    int updateByPrimaryKeySelective(ResearchSite record);

    int updateByPrimaryKey(ResearchSite record);
}