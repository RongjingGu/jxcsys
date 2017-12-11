package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.Conversation;
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