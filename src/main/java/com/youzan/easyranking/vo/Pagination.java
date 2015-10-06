package com.youzan.easyranking.vo;

import java.util.List;

import com.youzan.easyranking.util.Constants;

public class Pagination<T> {
	private int pageSize = 4;

	private int currentPageNum;
	private boolean isFirstPage;
	private boolean isLastPage;
	private List<T> pageList;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
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

	public void paging(List<T> elementList, String action) {
		// pagination, 4 candidates each page
		int fromIndex = 0;
		int toIndex = pageSize;
		
		if (Constants.ACTION_PREVIOUS.equals(action)) {
			currentPageNum = currentPageNum - 1;
		} else if (Constants.ACTION_NEXT.equals(action)) {
			currentPageNum = currentPageNum + 1;
		} else { // come from other page, default to first page
			currentPageNum = 0;
		}
		fromIndex = currentPageNum * pageSize;
		toIndex = fromIndex + pageSize;
		if (fromIndex <= 0) {
			fromIndex = 0;
			isFirstPage = true;
		}
		if (fromIndex > elementList.size()) {
			fromIndex = elementList.size();
		}
		if (toIndex >= elementList.size()) {
			toIndex = elementList.size();
			isLastPage = true;
		}
		pageList = elementList.subList(fromIndex, toIndex);
	}	
}
