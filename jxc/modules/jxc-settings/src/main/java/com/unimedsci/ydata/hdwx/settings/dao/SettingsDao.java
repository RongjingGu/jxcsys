package com.unimedsci.ydata.hdwx.settings.dao;

import com.unimedsci.ydata.hdwx.settings.model.Settings;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SettingsDao {
	public List<Settings> loadSettings();
}

