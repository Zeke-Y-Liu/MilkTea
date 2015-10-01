package com.youzan.easyranking.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.dao.ICandidateDao;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.util.Constants;

public class RankAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(RankAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String function;
	private String action;
	private long candidateId;
	private List<Candidate> candidateList;
	private ICandidateDao candidateDao;
	private Candidate votedCandidate;
	
	public String rank() {
		logger.info("RankAction:rank");
		logger.info("function=" + function + " action=" + action + " candidateId=" + candidateId);
		candidateList = candidateDao.getAllCandidates();
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

	public ICandidateDao getCandidateDao() {
		return candidateDao;
	}

	public void setCandidateDao(ICandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}

	public String getShowImageFilePath() {
		return Constants.WEB_CONTEXT_ROOT + Constants.IMAGE_FILE_RELATIVE_PATH;
	}	
	
	public String vote() {
		logger.info("RankAction:vote");
		logger.info("candidateId=" + candidateId);
		votedCandidate = candidateDao.getCandidateById(Long.valueOf(candidateId));
		votedCandidate.setPoll(votedCandidate.getPoll() +1);
		candidateDao.updateCandidate(votedCandidate);
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
	
	
}
