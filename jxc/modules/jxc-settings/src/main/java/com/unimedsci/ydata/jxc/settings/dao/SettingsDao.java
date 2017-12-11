package com.unimedsci.ydata.jxc.settings.dao;

import com.unimedsci.ydata.jxc.settings.model.Settings;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SettingsDao {
	public List<Settings> loadSettings();
}

