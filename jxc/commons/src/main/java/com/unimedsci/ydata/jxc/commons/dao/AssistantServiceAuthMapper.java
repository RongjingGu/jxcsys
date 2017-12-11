package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.AssistantServiceAuth;
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