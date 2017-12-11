package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.Region;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionADao {
    int deleteByPrimaryKey(Integer regionId);

    int insert(Region record);

    Region selectByPrimaryKey(Integer regionId);

    int updateByPrimaryKey(Region record);

    List<Region> getRegionListByParentId(@Param(value = "parentId") Integer parentId);
}