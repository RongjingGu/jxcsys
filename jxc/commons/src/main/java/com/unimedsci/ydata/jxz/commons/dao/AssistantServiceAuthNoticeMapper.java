package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.AssistantServiceAuthNotice;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantServiceAuthNoticeMapper {
    int deleteByPrimaryKey(Integer assistantServiceAuthNoticeId);

    int insert(AssistantServiceAuthNotice record);

    int insertSelective(AssistantServiceAuthNotice record);

    AssistantServiceAuthNotice selectByPrimaryKey(Integer assistantServiceAuthNoticeId);

    int updateByPrimaryKeySelective(AssistantServiceAuthNotice record);

    int updateByPrimaryKey(AssistantServiceAuthNotice record);
}