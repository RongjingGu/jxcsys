package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.QuestionStoreKeyword;
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