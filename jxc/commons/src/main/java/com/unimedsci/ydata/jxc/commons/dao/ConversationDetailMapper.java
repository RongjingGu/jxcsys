package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.ConversationDetail;
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