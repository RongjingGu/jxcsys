package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.HotConversation;
import org.springframework.stereotype.Repository;

@Repository
public interface HotConversationMapper {
    int deleteByPrimaryKey(Integer hotConversationId);

    int insert(HotConversation record);

    int insertSelective(HotConversation record);

    HotConversation selectByPrimaryKey(Integer hotConversationId);

    int updateByPrimaryKeySelective(HotConversation record);

    int updateByPrimaryKey(HotConversation record);
}