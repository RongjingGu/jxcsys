package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.ConversationQuestionStore;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationQuestionStoreMapper {
    int deleteByPrimaryKey(Long conversationQuestionStoreId);

    int insert(ConversationQuestionStore record);

    int insertSelective(ConversationQuestionStore record);

    ConversationQuestionStore selectByPrimaryKey(Long conversationQuestionStoreId);

    int updateByPrimaryKeySelective(ConversationQuestionStore record);

    int updateByPrimaryKey(ConversationQuestionStore record);
}