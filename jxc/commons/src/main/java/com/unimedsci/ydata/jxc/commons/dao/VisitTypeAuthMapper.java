package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.VisitTypeAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitTypeAuthMapper {
    int deleteByPrimaryKey(Integer visitTypeAuthId);

    int insert(VisitTypeAuth record);

    int insertSelective(VisitTypeAuth record);

    VisitTypeAuth selectByPrimaryKey(Integer visitTypeAuthId);

    int updateByPrimaryKeySelective(VisitTypeAuth record);

    int updateByPrimaryKey(VisitTypeAuth record);
}