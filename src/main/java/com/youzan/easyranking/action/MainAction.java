package com.youzan.easyranking.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.cache.CacheManager;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.util.Constants;
import com.youzan.easyranking.vo.PageView;
import com.youzan.easyranking.vo.Pagination;

public class MainAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(MainAction.class);
	private static final long serialVersionUID = 1L;
	private String function;
	private String action;
	private String openId;
	private List<Candidate> candidateList;
	private String searchText;
	private Pagination<Candidate> pagination = new Pagination<Candidate>();
	private CacheManager cacheManager;
	private PageView pageView = new PageView();
	
	public String mainPage() {
		logger.info("function=" + function + " action=" +action + " currentPage=" + pagination.getCurrentPageNum() + " openId=" + openId);
		String result = SUCCESS;
		initPageView();
		if(Constants.ACTION_SPECIFIED_PAGE.equalsIgnoreCase(action)) {
			
				result = gotoPage();
		} else if (Constants.ACTION_SEARCH_CANDIDATE.equalsIgnoreCase(action)) {
			result = searchCandidate(searchText);
		} else {
			result = initMainPage();
		}
		logger.info("result=" + result);
		return result;
	}
	
	private String searchCandidate(String searchText) {
		candidateList = cacheManager.getAllCandiateList();
		List<Candidate> result = new ArrayList<Candidate>();
		if(StringUtils.isBlank(searchText)) {
			result = candidateList;
		} else {
			for(Candidate candidate : candidateList) {
				String idStr = candidate.getId() + "";
				String name = candidate.getCandidateName();
				if(idStr.contains(searchText) || name.contains(searchText)) {
					result.add(candidate);
				}
			}
		}
		pagination.paging(result, action);
		return SUCCESS;
	}
	
	private String initMainPage() {
		candidateList = cacheManager.getAllCandiateList();
		pagination.paging(candidateList, action);
		return SUCCESS;
	}
	
	private String gotoPage() {
		candidateList = cacheManager.getAllCandiateList();
		pagination.paging(candidateList, action);
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
	public List<Candidate> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	public CacheManager getCacheManager() {
		return cacheManager;
	}
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	public Pagination<Candidate> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<Candidate> pagination) {
		this.pagination = pagination;
	}

	public String getShowImageFilePath() {
		return Constants.WEB_CONTEXT_ROOT + Constants.IMAGE_FILE_RELATIVE_PATH;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
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
