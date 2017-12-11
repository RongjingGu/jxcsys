package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.ConversationReadRecord;
import com.unimedsci.ydata.jxz.commons.datas.ConversationReadRecordKey;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationReadRecordMapper {
    int deleteByPrimaryKey(ConversationReadRecordKey key);

    int insert(ConversationReadRecord record);

    int insertSelective(ConversationReadRecord record);

    ConversationReadRecord selectByPrimaryKey(ConversationReadRecordKey key);

    int updateByPrimaryKeySelective(ConversationReadRecord record);

    int updateByPrimaryKey(ConversationReadRecord record);
}