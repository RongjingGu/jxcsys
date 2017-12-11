package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.CrfAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface CrfAuthMapper {
    int deleteByPrimaryKey(Integer crfAuthId);

    int insert(CrfAuth record);

    int insertSelective(CrfAuth record);

    CrfAuth selectByPrimaryKey(Integer crfAuthId);

    int updateByPrimaryKeySelective(CrfAuth record);

    int updateByPrimaryKey(CrfAuth record);
}