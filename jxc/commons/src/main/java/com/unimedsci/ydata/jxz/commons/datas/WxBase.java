package com.unimedsci.ydata.jxz.commons.datas;

import com.sweetw.idata.wx.data.WxUser;

import java.util.Date;

public class WxBase extends WxUser{
	
	public static enum WxStatus {SUBSCRIBE,UNSUBSCRIBE};
	

	
	protected WxStatus status;
	
	protected Date subscribeTime;
	
	protected Date unsubscribeTime;

	public WxStatus getStatus() {
		return status;
	}

	public void setStatus(WxStatus status) {
		this.status = status;
	}

	public Date getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public Date getUnsubscribeTime() {
		return unsubscribeTime;
	}

	public void setUnsubscribeTime(Date unsubscribeTime) {
		this.unsubscribeTime = unsubscribeTime;
	}
}