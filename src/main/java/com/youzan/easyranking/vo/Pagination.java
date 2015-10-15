package com.youzan.easyranking.vo;

import java.util.List;

import com.youzan.easyranking.util.Constants;

public class Pagination<T> {
	private int pageSize = 10;

	private int currentPageNum;
	private boolean firstPage;
	private boolean lastPage;
	private int totalPageCount;
	private List<T> pageList;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	
	public List<T> getPageList() {
		return pageList;
	}
		
	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void paging(List<T> elementList, String action) {
		// pagination, 10 candidates each page
		if(elementList.size()%10==0) {
			totalPageCount = elementList.size()/10;
		} else {
			totalPageCount = (elementList.size()/10) + 1;
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
		pageList = elementList.subList(fromIndex, toIndex);
	}	
}
