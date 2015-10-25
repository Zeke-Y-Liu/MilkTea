package com.youzan.easyranking.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.util.Constants;
import com.youzan.easyranking.vo.PageView;

public class LoginAction extends AbstractBean {
	private static Logger logger = Logger.getLogger(CouponAction.class);
	private List<Candidate> candidateList;
	// private Pagination<Candidate> pagination = new Pagination<Candidate>();
	private PageView pageView = new PageView();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String login() {
		// from welcome page
		logger.info("openId=" + ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_OPEN_ID));
		logger.info("ipAddr=" + ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_IP_ADDR));
		getUserInfo().setOpenId((String)ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_OPEN_ID));
		getUserInfo().setIpAddr((String)ActionContext.getContext().getSession().get(Constants.ATTRIBUTE_IP_ADDR));
		candidateList = cacheManager.getAllCandiateList();
		initPageView();
		return SUCCESS;
	}
	
	private void initPageView() {
		pageView.paging(candidateList, action);
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
