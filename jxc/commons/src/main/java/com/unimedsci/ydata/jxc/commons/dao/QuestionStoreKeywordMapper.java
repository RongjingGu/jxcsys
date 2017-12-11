package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.QuestionStoreKeyword;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionStoreKeywordMapper {
    int deleteByPrimaryKey(Integer questionStoreKeywordId);

    int insert(QuestionStoreKeyword record);

    int insertSelective(QuestionStoreKeyword record);

    QuestionStoreKeyword selectByPrimaryKey(Integer questionStoreKeywordId);

    int updateByPrimaryKeySelective(QuestionStoreKeyword record);

    int updateByPrimaryKey(QuestionStoreKeyword record);


}