package com.youzan.easyranking.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.util.Constants;
import com.youzan.easyranking.util.MmUtil;
import com.youzan.easyranking.vo.CandidateVo;
import com.youzan.easyranking.vo.PageView;
import com.youzan.easyranking.vo.Pagination;

public class LoginAction extends AbstractBean {

	private List<Candidate> candidateList;
	// private Pagination<Candidate> pagination = new Pagination<Candidate>();
	private PageView pageView = new PageView();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String login() {
		// from welcome page
		System.out.println("Session=" + ActionContext.getContext().getSession());
		System.out.println("openId=" + ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_OPEN_ID));
		System.out.println("userInfo=" + getUserInfo());
		getUserInfo().setOpenId((String)ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_OPEN_ID));
		getUserInfo().setIpAddr((String)ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_IP_ADDR));
		candidateList = cacheManager.getAllCandiateList();
		initPageView();
		return SUCCESS;
	}
	
	private void initPageView() {
		pageView.paging(candidateList, action);
		List<Vote> voteList = cacheManager.getVoteForUser(userInfo);
		for(CandidateVo candidateVo : pageView.getPageList()) {
			candidateVo.setVoteAllowed(MmUtil.isVoteAllowed(voteList, userInfo, appInfo));
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
}
