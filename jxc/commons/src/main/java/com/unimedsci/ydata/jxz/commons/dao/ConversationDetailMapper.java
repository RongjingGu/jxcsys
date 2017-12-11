package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.ConversationDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationDetailMapper {
    int deleteByPrimaryKey(Long conversationDetailId);

    int insert(ConversationDetail record);

    int insertSelective(ConversationDetail record);

    ConversationDetail selectByPrimaryKey(Long conversationDetailId);

    int updateByPrimaryKeySelective(ConversationDetail record);

    int updateByPrimaryKey(ConversationDetail record);
}