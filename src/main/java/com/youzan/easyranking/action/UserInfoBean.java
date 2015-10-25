package com.youzan.easyranking.action;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String openId;
	private String ipAddr;
	private String requestToken;

	public UserInfoBean() {
		
	}
	public UserInfoBean(String openId, String ipAddr) {
		this.openId = openId;
		this.ipAddr = ipAddr;
	}
	
	public String getVoteKey() {
		if(!StringUtils.isBlank(openId)) {
			return openId;
		} else {
			return ipAddr;
		}
	}
	
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getRequestToken() {
		return requestToken;
	}

	public void setRequestToken(String requestToken) {
		this.requestToken = requestToken;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public boolean isAnonymous() {
		return StringUtils.isBlank(openId);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(openId).append(ipAddr).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		UserInfoBean that = (UserInfoBean) obj;
		return new EqualsBuilder().append(openId, that.openId).append(ipAddr, that.ipAddr).isEquals();
	}
	
	 @Override 
	 public String toString() { 
	            return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
	            	  append("openId", openId).
	  		          append("ipAddr", ipAddr).
	  		          append("requestToken", requestToken). 
	                  toString(); 
	    }
	
}
