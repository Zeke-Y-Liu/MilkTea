package com.youzan.easyranking.action;

import java.util.Date;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.cache.CacheManager;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.util.Constants;

public class VoteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(RankAction.class);
	private String function;
	private String action;
	private String openId;
	private long candidateId;
	private CacheManager cacheManager;
	private Candidate candidate;

	public String voteCandidate() {
		candidate = cacheManager.getCandidateById(candidateId);
		return SUCCESS;
	}
	
	public String vote() {
		logger.info("VoteAction:vote");
		logger.info("candidateId=" + candidateId);
		Vote vote = new Vote();
		vote.setCandidateId(candidateId);
		vote.setUserOpenId("testUserOpenId");
		vote.setVoteTime(new Date());
		candidate = cacheManager.addNewVote(vote);
		return SUCCESS;
	}

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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getShowImageFilePath() {
		return Constants.WEB_CONTEXT_ROOT + Constants.IMAGE_FILE_RELATIVE_PATH;
	}
}
