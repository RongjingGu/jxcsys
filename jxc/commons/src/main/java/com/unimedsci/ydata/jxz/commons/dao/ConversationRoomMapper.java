package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.ConversationRoom;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRoomMapper {
    int deleteByPrimaryKey(Integer conversationRoomId);

    int insert(ConversationRoom record);

    int insertSelective(ConversationRoom record);

    ConversationRoom selectByPrimaryKey(Integer conversationRoomId);

    int updateByPrimaryKeySelective(ConversationRoom record);

    int updateByPrimaryKey(ConversationRoom record);
}