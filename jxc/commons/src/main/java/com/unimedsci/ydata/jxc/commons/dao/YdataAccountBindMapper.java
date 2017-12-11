package com.unimedsci.ydata.jxc.commons.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxc.commons.datas.YdataAccountBind;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YdataAccountBindMapper {
    int deleteByPrimaryKey(Integer ydataAccountBindId);

    int insert(YdataAccountBind record);

    int insertSelective(YdataAccountBind record);

    YdataAccountBind selectByPrimaryKey(Integer ydataAccountBindId);

    List<YdataAccountBind> selectByOpenidAndStatus(
            @Param("openid") String openid,
            @Param("status") YdataAccountBind.Status status
    );

    int updateByPrimaryKeySelective(YdataAccountBind record);

    int updateByPrimaryKey(YdataAccountBind record);

    int unbindByOpenidList(List<String> openidList);

    int unbindByOpenid(String openid);

    List<YdataAccountBind> queryYdataAccountBind(PageBounds pageBounds, @Param(value = "bindStatus") String bindStatus);

    List<YdataAccountBind> queryYdataAccountBindYdataSearch(PageBounds pageBounds,
                                                            @Param(value = "userIds") List<Integer> userIds,
                                                            @Param(value = "bindStatus") String bindStatus);
}