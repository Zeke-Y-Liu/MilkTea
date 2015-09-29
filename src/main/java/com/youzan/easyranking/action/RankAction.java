package com.youzan.easyranking.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.dao.ICandidateDao;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.util.Constants;

public class RankAction extends ActionSupport {
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
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
		candidateList = candidateDao.getAllCandidates();
		if(Constants.ACTION_RANK_RESULT.equals(action)) {
			System.out.println("BBBBBBBB");
			
			return Constants.ACTION_RANK_RESULT;
		} 
		System.out.println("CCCCCCC");
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
		System.err.println("candidateId=" + candidateId);
		votedCandidate = candidateDao.getCandidateById(Long.valueOf(candidateId));
		System.err.println("OK");
		return Constants.ACTION_RESULT_VOTE;
	}

	public Candidate getVotedCandidate() {
		System.err.println("call ed");
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
