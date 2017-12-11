package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.YdataAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface YdataAccountMapper {
    int deleteByPrimaryKey(Integer ydataAccountId);

    int insert(YdataAccount record);

    int insertSelective(YdataAccount record);

    YdataAccount selectByPrimaryKey(Integer ydataAccountId);

    int updateByPrimaryKeySelective(YdataAccount record);

    int updateByPrimaryKey(YdataAccount record);
}