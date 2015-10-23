package com.youzan.easyranking.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.util.Constants;
import com.youzan.easyranking.util.MmUtil;
import com.youzan.easyranking.vo.PageView;
import com.youzan.easyranking.vo.Pagination;

public class LoginAction extends AbstractBean {

	private List<Candidate> candidateList;
	private Pagination<Candidate> pagination = new Pagination<Candidate>();
	private PageView pageView = new PageView();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String login() {
		// from welcome page
		getUserInfo().setOpenId((String)ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_OPEN_ID));
		getUserInfo().setIpAddr((String)ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_IP_ADDR));
		initPageView();
		return SUCCESS;
	}
	
	private void initPageView() {
		candidateList = cacheManager.getAllCandiateList();
		for(Candidate candidate : candidateList) {
			List<Vote> voteList = cacheManager.getVoteForUser(userInfo);
			candidate.setVoteAllowed(MmUtil.isVoteAllowed(voteList, userInfo, appInfo));
		}
		pageView.setTotalCandidateCount(cacheManager.getAllCandiateList().size());
		pageView.setTotalVoteCount(cacheManager.getAllVoteList().size());
	}
	
	public PageView getPageView() {
		return pageView;
	}

	public void setPageView(PageView pageView) {
		this.pageView = pageView;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public Pagination<Candidate> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Candidate> pagination) {
		this.pagination = pagination;
	}
	
}
