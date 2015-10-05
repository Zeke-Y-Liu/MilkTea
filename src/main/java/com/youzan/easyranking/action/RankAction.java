package com.youzan.easyranking.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.cache.CacheManger;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.util.Constants;

public class RankAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(RankAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String function;
	private String action;
	private String userOpenId;
	private long candidateId;
	private List<Candidate> candidateList;
	private CacheManger cacheManager;
	private Candidate votedCandidate;
	
	public String rank() {
		logger.info("RankAction:rank");
		logger.info("function=" + function + " action=" + action + " candidateId=" + candidateId);
		candidateList = cacheManager.getAllCandiateList();
		if(Constants.ACTION_VIEW_CANDIDATE_LIST.equals(action)) {
			logger.info("RankAction:rank");
			return Constants.RESULT_CANDIDATE_LIST;
		} 
		return INPUT;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public CacheManger getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManger cacheManager) {
		this.cacheManager = cacheManager;
	}

	public String getShowImageFilePath() {
		return Constants.WEB_CONTEXT_ROOT + Constants.IMAGE_FILE_RELATIVE_PATH;
	}	
	
	public String vote() {
		logger.info("RankAction:vote");
		logger.info("candidateId=" + candidateId);
		Vote vote = new Vote();
		vote.setCandidateId(candidateId);
		vote.setUserOpenId("testUserOpenId");
		vote.setVoteTime(new Date());
		votedCandidate = cacheManager.addNewVote(vote);
		return Constants.RESULT_VOTE;
	}

	public Candidate getVotedCandidate() {
		return votedCandidate;
	}

	public void setVotedCandidate(Candidate votedCandidate) {
		this.votedCandidate = votedCandidate;
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
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

	public String getUserOpenId() {
		return userOpenId;
	}

	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
	}
		
}
