package com.youzan.easyranking.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.util.Helper;
import com.youzan.easyranking.util.MmUtil;
import com.youzan.easyranking.vo.PageView;

public class VoteAction extends AbstractBean {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(VoteAction.class);
	private long candidateId;
	
	private PageView pageView = new PageView();

	public String voteCandidate() {
		logger.info("VoteAction:voteCandidate:candidateId=" + candidateId);
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
		pageView.setCandidateVo(Helper.toCandidateVo(cacheManager.addNewVote(vote)));
		return SUCCESS;
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	private void initPageView() {
		pageView.setCandidateVo(Helper.toCandidateVo(cacheManager.getCandidateById(candidateId)));
		List<Vote> voteList = cacheManager.getVoteForUser(userInfo);
		pageView.getCandidateVo().setVoteAllowed(MmUtil.isVoteAllowed(voteList, userInfo, appInfo));
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
