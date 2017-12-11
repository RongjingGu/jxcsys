package com.unimedsci.ydata.jxz.commons.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxz.commons.datas.LastTendency;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LastTendencyMapper {
    int deleteByPrimaryKey(Integer lastTendencyId);

    int insert(LastTendency record);

    int insertSelective(LastTendency record);

    LastTendency selectByPrimaryKey(Integer lastTendencyId);

    int updateByPrimaryKeySelective(LastTendency record);

    int updateByPrimaryKey(LastTendency record);

    List<LastTendency> queryLastTendencyList(PageBounds pageBounds,
                                             @Param(value = "lastTendencyTitle") String lastTendencyTitle,
                                             @Param(value = "lastTendencyId") Integer lastTendencyId);
}