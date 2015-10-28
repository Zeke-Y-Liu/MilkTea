package com.youzan.easyranking.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AppInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// default 1 hours
	private long voteInterval = 1000*60*60; 
	private boolean isAnonymousAllowed = false;
	// default 3 hours
	private long anonymousVoteInternal = 1000*60*60*3;
	
	List<String> couponUrls = new ArrayList<String>();
	
	public long getVoteInterval() {
		return voteInterval;
	}
	public void setVoteInterval(long voteInterval) {
		this.voteInterval = voteInterval;
	}
	public boolean isAnonymousAllowed() {
		return isAnonymousAllowed;
	}
	public void setAnonymousAllowed(boolean isAnonymousAllowed) {
		this.isAnonymousAllowed = isAnonymousAllowed;
	}
	public long getAnonymousVoteInternal() {
		return anonymousVoteInternal;
	}
	public void setAnonymousVoteInternal(long anonymousVoteInternal) {
		this.anonymousVoteInternal = anonymousVoteInternal;
	}	
		
	 public List<String> getCouponUrls() {
		return couponUrls;
	}
	public void setCouponUrls(List<String> couponUrls) {
		this.couponUrls = couponUrls;
	}	

		
	@Override 
	 public String toString() { 
	            return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
	            	  append("voteInterval", voteInterval).
	  		          append("isAnonymousAllowed", isAnonymousAllowed).
	  		          append("anonymousVoteInternal", anonymousVoteInternal). 
	                  toString(); 
	    }
}
