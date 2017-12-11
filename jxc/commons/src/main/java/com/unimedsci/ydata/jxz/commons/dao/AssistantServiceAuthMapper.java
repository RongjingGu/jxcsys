package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.AssistantServiceAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantServiceAuthMapper {
    int deleteByPrimaryKey(Integer assistantServiceAuthId);

    int insert(AssistantServiceAuth record);

    int insertSelective(AssistantServiceAuth record);

    AssistantServiceAuth selectByPrimaryKey(Integer assistantServiceAuthId);

    int updateByPrimaryKeySelective(AssistantServiceAuth record);

    int updateByPrimaryKey(AssistantServiceAuth record);
}