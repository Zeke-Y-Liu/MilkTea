package com.youzan.easyranking.vo;

import java.util.List;

import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.util.Constants;
import com.youzan.easyranking.util.Helper;

public class PageView {

	public long totalCandidateCount;
	public long totalVoteCount;
	public long totalVisitorCount;

	private int pageSize = 6;

	private int currentPageNum;
	private boolean firstPage;
	private boolean lastPage;
	private int totalPageCount;
	private List<CandidateVo> pageList;
	private CandidateVo candidateVo;

	public List<CandidateVo> paging(List<Candidate> elementList, String action) {
		// pagination, 10 candidates each page
		if(elementList.size()%10==0) {
			totalPageCount = elementList.size()/pageSize;
		} else {
			totalPageCount = (elementList.size()/pageSize) + 1;
		}
		int fromIndex = 0;
		int toIndex = pageSize;
		
		if (Constants.ACTION_PREVIOUS_PAGE.equals(action)) {
			currentPageNum = currentPageNum - 1;
		} else if (Constants.ACTION_NEXT_PAGE.equals(action)) {
			currentPageNum = currentPageNum + 1;
		} else { 
			// come from other page, default to first page current page = 0;
			// OR go to specific page, current populated from page parameter
		}
		fromIndex = currentPageNum * pageSize;
		toIndex = fromIndex + pageSize;
		if (fromIndex <= 0) {
			fromIndex = 0;
			firstPage = true;
		}
		if (fromIndex > elementList.size()) {
			fromIndex = elementList.size();
		}
		if (toIndex >= elementList.size()) {
			toIndex = elementList.size();
			lastPage = true;
		}
		pageList = Helper.fromCandidateList(elementList.subList(fromIndex, toIndex));
		return pageList;
	}	
	
	public long getTotalCandidateCount() {
		return totalCandidateCount;
	}

	public void setTotalCandidateCount(int totalCandidateCount) {
		this.totalCandidateCount = totalCandidateCount;
	}

	public long getTotalVoteCount() {
		return totalVoteCount;
	}

	public void setTotalVoteCount(int totalVoteCount) {
		this.totalVoteCount = totalVoteCount;
	}

	public long getTotalVisitorCount() {
		return totalVisitorCount;
	}

	public void setTotalVisitorCount(long totalVisitorCount) {
		this.totalVisitorCount = totalVisitorCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public List<CandidateVo> getPageList() {
		return pageList;
	}

	public void setPageList(List<CandidateVo> pageList) {
		this.pageList = pageList;
	}

	public CandidateVo getCandidateVo() {
		return candidateVo;
	}

	public void setCandidateVo(CandidateVo candidateVo) {
		this.candidateVo = candidateVo;
	}
}
