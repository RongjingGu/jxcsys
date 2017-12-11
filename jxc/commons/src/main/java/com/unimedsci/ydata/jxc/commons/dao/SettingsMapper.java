package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.Settings;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsMapper {
    int deleteByPrimaryKey(String key);

    int insert(Settings record);

    int insertSelective(Settings record);

    Settings selectByPrimaryKey(String key);

    int updateByPrimaryKeySelective(Settings record);

    int updateByPrimaryKey(Settings record);
}