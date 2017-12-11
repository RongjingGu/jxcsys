package com.unimedsci.ydata.jxc.commons.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxc.commons.datas.QuestionStore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionStoreMapper {
    int deleteByPrimaryKey(Integer questionStoreId);

    int insert(QuestionStore record);

    int insertSelective(QuestionStore record);

    QuestionStore selectByPrimaryKey(Integer questionStoreId);

    int updateByPrimaryKeySelective(QuestionStore record);

    int updateByPrimaryKey(QuestionStore record);

    List<QuestionStore> queryQuestionStoreList(PageBounds pageBounds,
                                                @Param(value = "question") String question,
                                                @Param(value = "keyword") String keyword,
                                                @Param(value = "questionStoreId") Integer questionStoreId);
}