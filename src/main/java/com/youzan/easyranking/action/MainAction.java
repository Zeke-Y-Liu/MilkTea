package com.youzan.easyranking.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.util.Constants;
import com.youzan.easyranking.util.MmUtil;
import com.youzan.easyranking.vo.PageView;
import com.youzan.easyranking.vo.Pagination;

public class MainAction extends AbstractBean {
	private static Logger logger = Logger.getLogger(MainAction.class);
	private static final long serialVersionUID = 1L;
	private List<Candidate> candidateList;
	private String searchText;
	private Pagination<Candidate> pagination = new Pagination<Candidate>();
	private PageView pageView = new PageView();
		
	public String mainPage() {
		logger.info("function=" + function + " action=" +action + " currentPage=" + pagination.getCurrentPageNum());
		
		if(Constants.ACTION_SPECIFIED_PAGE.equalsIgnoreCase(action)) {
			// paging the list
			candidateList = cacheManager.getAllCandiateList();
		} else if (Constants.ACTION_SEARCH_CANDIDATE.equalsIgnoreCase(action)) {
			candidateList = searchCandidate(searchText);
		} else {
			candidateList = cacheManager.getAllCandiateList();
		}
		pagination.paging(candidateList, action);
		initPageView();
		return SUCCESS;
	}
	
	private List<Candidate> searchCandidate(String searchText) {
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
		return result;
	}


	public List<Candidate> getCandidateList() {
		return candidateList;
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
		List<Vote> voteList = cacheManager.getVoteForUser(userInfo);
		for(Candidate candidate : pagination.getPageList()) {
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

}
