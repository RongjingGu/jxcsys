package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.Conversation;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationMapper {
    int deleteByPrimaryKey(Integer conversationId);

    int insert(Conversation record);

    int insertSelective(Conversation record);

    Conversation selectByPrimaryKey(Integer conversationId);

    int updateByPrimaryKeySelective(Conversation record);

    int updateByPrimaryKey(Conversation record);
}