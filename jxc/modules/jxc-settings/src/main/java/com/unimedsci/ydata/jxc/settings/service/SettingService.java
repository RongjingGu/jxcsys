package com.unimedsci.ydata.jxc.settings.service;

import com.unimedsci.ydata.jxc.settings.dao.SettingsDao;
import com.unimedsci.ydata.jxc.settings.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED)
@Service
public class SettingService {
	@Autowired
	private SettingsDao settingsDao;
	
	public List<Settings> loadSettings() {
		return settingsDao.loadSettings();
	}
	
}
