package com.unimedsci.ydata.jxc.settings;

import com.sweetw.idata.commons.AwareBean;
import com.unimedsci.ydata.jxc.settings.model.Settings;
import com.unimedsci.ydata.jxc.settings.service.SettingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 *  wanglie 
 *  
 *  read from settings table 
 */
@Component
@Scope("singleton")
public class SettingsBean extends AwareBean{

	private static final Logger _logger = Logger.getLogger(SettingsBean.class);
	
	@Autowired
	SettingService settingService;
	Map<String,String> items=new ConcurrentHashMap<String,String>();
	//DBManage _db;
	boolean _flag=false;

	@Override
	public void init()
	{
		if(!_flag)
		{
		
			List<Settings> settings = settingService.loadSettings();
			for(Settings item:settings)
			{
				items.put(item.key, item.value);
			}
			_flag=true;
			
		}
		_logger.info("load settings size"+items.size());
	}
	public String getValue(String key)
	{
		return items.get(key);
	}

}

