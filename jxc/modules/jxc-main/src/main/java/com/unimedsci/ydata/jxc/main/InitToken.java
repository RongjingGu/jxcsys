package com.unimedsci.ydata.jxc.main;

import com.sweetw.idata.commons.AwareBean;
import com.sweetw.idata.commons.utils.RemoteService;
import com.sweetw.idata.commons.utils.Utility;
import com.sweetw.idata.wx.data.WxAccessTokenRequest;
import com.sweetw.idata.wx.data.WxAccessTokenResponse;
import com.sweetw.idata.wx.data.WxTicketResponse;
import com.sweetw.idata.wx.global.WXGlobal;
import com.unimedsci.ydata.jxz.commons.CustomConfig;
import com.unimedsci.ydata.jxz.commons.util.TaskTimerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

@Component
@Scope("singleton")
public class InitToken extends AwareBean{
	private static final Logger _logger = Logger.getLogger(InitToken.class);

	
	@Autowired
	public CustomConfig config;
	
	@Override
	public void init()
	{
		initTokenTask();
	}

	public  void initTokenTask() {
		//每隔7000秒，更新一次操作码
		TaskTimerUtil.schedule(new TimerTask() {
			public void run() {
				getAccessToken();
			}
		}, 5000, 900 * 1000);
	}
	
	
	/**
	 *         1 Seconds (0-59) 
        2 Minutes (0-59) 
        3 Hours (0-23) 
        4 Day of month (1-31) 
        5 Month (1-12 or JAN-DEC) 
        6 Day of week (1-7 or SUN-SAT) 
        7 Year (1970-2099) 
        取值：可以是单个值，如6； 
            也可以是个范围，如9-12； 
            也可以是个列表，如9,11,13 
            也可以是任意取值，使用* 
	 */
	//@Scheduled(cron="0, 30,59 * * * *")  //每半小时运行一次
	public  void getAccessToken() {
		StringBuffer out = new StringBuffer();
		WxAccessTokenRequest request = new WxAccessTokenRequest();
		
		
		_logger.info("appid:"+config.getAppId()+"secret"+config.getSecret());
		
		request.setAppid(config.getAppId());
       	request.setSecret(config.getSecret());	
        String postData = Utility.object2Form(request);

		try {
			_logger.info("url:"+WXGlobal.ACCESS_TOKEN_URL+"request"+postData);
			RemoteService.getResponse(WXGlobal.ACCESS_TOKEN_URL, "", postData,"GET", "application/X-WWW-form-urlencoded", out);
			_logger.info("getResponse"+out);
			
			WxAccessTokenResponse response = Utility.JsonDeserialize(WxAccessTokenResponse.class,out);
			 
			WXGlobal.accessToken = response.getAccess_token();

			_logger.info("accessToken"+WXGlobal.accessToken);

			
			StringBuffer wxOut =  new StringBuffer();
			
			//https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi
			

			String ticketRequest="?access_token="+	WXGlobal.accessToken +"&type=jsapi";
			
			RemoteService.getResponse(WXGlobal.WX_TICKET_URL, "", ticketRequest,"GET", "application/X-WWW-form-urlencoded", wxOut);
			
			WxTicketResponse ticketResponse = Utility.JsonDeserialize(WxTicketResponse.class,wxOut);
			
			WXGlobal.ticket = ticketResponse.getTicket();
			
			_logger.info("ticket"+WXGlobal.ticket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
	}
	
}


