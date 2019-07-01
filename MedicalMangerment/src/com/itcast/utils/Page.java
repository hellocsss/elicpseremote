package com.itcast.utils;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = 5599632798780L;

	// pagesize 锛屾瘡涓�〉鏄剧ず璁板綍鏁�
	private int showCount = 10;
	// 鎬婚〉鏁�
	private int totalPage;
	// 鎬昏褰曟暟
	private int totalResult;
	// 褰撳墠椤�
	private int currentPage;
	// 褰撳墠鏄剧ず鍒扮殑 ID, 鍦�mysql limit 涓氨鏄涓�釜鍙傛暟.
	private int currentResult;
	// 鎺掑簭瀛楁
	private String sortField;
	// 鎺掑簭鏂瑰紡
	private String order;

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public int getTotalPage() {
//		return totalPage;
		return (this.totalResult - 1) / this.showCount + 1;
	}

//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentResult() {
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
