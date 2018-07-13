package com.unimedsci.ydata.jxc.commons.dao;

import com.unimedsci.ydata.jxc.commons.datas.Settings;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsMapper {
    int deleteByPrimaryKey(String key);

    int insert(Settings record);

    Settings selectByPrimaryKey(String key);

    int updateByPrimaryKey(Settings record);

    Settings querySetting();
}