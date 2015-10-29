package com.youzan.easyranking.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.vo.PageView;

public class LoginAction extends AbstractBean {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	String openId = "";
	String ipAddr = "";
	
	private List<Candidate> candidateList;
	// private Pagination<Candidate> pagination = new Pagination<Candidate>();
	private PageView pageView = new PageView();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String login() {
		// from welcome page
		logger.info("login:" + "openId=" + openId + "| ipAddr=" + ipAddr);
		getUserInfo().setOpenId(openId);
		getUserInfo().setIpAddr(ipAddr);
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
}
