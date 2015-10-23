package com.youzan.easyranking.action;

import java.util.Date;

import org.apache.log4j.Logger;

import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.util.Constants;
import com.youzan.easyranking.vo.PageView;

public class VoteAction extends AbstractBean {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(VoteAction.class);
	private long candidateId;
	private Candidate candidate;
	
	private PageView pageView = new PageView();

	public String voteCandidate() {
		candidate = cacheManager.getCandidateById(candidateId);
		initPageView();
		return SUCCESS;
	}
	
	public String vote() {
		logger.info("VoteAction:vote:candidateId=" + candidateId);
		Vote vote = new Vote();
		vote.setCandidateId(candidateId);
		vote.setUserOpenId(getUserInfo().getOpenId());
		vote.setVoteIpAddr(getUserInfo().getIpAddr());
		vote.setVoteTime(new Date());
		candidate = cacheManager.addNewVote(vote);
		return SUCCESS;
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
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
	
	private void initPageView() {
		pageView.setTotalCandidateCount(cacheManager.getAllCandiateList().size());
		pageView.setTotalVoteCount(cacheManager.getAllVoteList().size());
	}

	public PageView getPageView() {
		return pageView;
	}

	public void setPageView(PageView pageView) {
		this.pageView = pageView;
	}
}
