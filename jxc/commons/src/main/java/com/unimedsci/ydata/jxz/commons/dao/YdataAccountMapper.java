package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.YdataAccount;
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