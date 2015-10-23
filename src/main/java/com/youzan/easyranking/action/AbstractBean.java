package com.youzan.easyranking.action;

import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.cache.CacheManager;

public class AbstractBean extends ActionSupport {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected String function;
	protected String action;
	protected CacheManager cacheManager;
	protected UserInfoBean userInfo;
	protected AppInfoBean appInfo;
	
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public CacheManager getCacheManager() {
		return cacheManager;
	}
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	public UserInfoBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoBean userInfo) {
		this.userInfo = userInfo;
	}
	public AppInfoBean getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(AppInfoBean appInfo) {
		this.appInfo = appInfo;
	}
		
}
