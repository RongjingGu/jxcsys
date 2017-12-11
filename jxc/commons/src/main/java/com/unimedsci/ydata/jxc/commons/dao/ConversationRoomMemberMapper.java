package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.ConversationRoomMember;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRoomMemberMapper {
    int deleteByPrimaryKey(Integer conversationRoomMemberId);

    int insert(ConversationRoomMember record);

    int insertSelective(ConversationRoomMember record);

    ConversationRoomMember selectByPrimaryKey(Integer conversationRoomMemberId);

    int updateByPrimaryKeySelective(ConversationRoomMember record);

    int updateByPrimaryKey(ConversationRoomMember record);
}