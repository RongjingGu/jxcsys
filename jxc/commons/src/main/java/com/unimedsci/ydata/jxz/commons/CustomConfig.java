package com.unimedsci.ydata.jxz.commons;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类说明:修改医生解绑、带关键字查询病例、短信验证码
 */
@Component
public class CustomConfig {
	 @Value("${wx.token}")
	 public String token;
	 public String getToken(){
		return token;
	}
	 
	 @Value("${wx.appid}")
	 public String appId;
	 public String getAppId(){
		 return appId;
	 }
	 
	 @Value("${wx.secret}")
	 public String secret;
	 public String getSecret(){
		 return secret;
	 }
	 
	 @Value("${wx.appname}")
	 public String appName;
	 public String getAppName(){
		 return this.appName;
	 }
	 
	 @Value("${shortmessage.account}")
	 public String shortMessageAccount;
	 public String getShortmessageAccount(){
		 return shortMessageAccount;
	 }

	 @Value("${shortmessage.key}")
	 public String shortMessageKey;
	 public String getShortmessageKey(){
		 return shortMessageKey;
	 }	 
	 
	 @Value("${shortmessage.channel}")
	 public String shortMessageChannel;
	 public String getShortmessageChannel(){
		 return shortMessageChannel;
	 }	
	 
	 @Value("${shortmessage.url}")
	 public String shortMessageUrl;
	 public String getShortmessageUrl(){
		 return shortMessageUrl;
	 }	
	 
	 @Value("${shortmessage.signature}")
	 public String shortMessageSignature;
	 public String getShortMessageSignature(){
		 return shortMessageSignature;
	 }
}
