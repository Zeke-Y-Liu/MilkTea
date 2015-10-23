package com.youzan.easyranking.action;

public class AppInfoBean {

	// default 1 hours
	private long voteInterval = 1000*60*60; 
	private boolean isAnonymousAllowed = false;
	// default 3 hours
	private long anonymousVoteInternal = 1000*60*60*3;
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
}
