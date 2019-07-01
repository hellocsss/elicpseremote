package com.itcast.entity;

import java.util.List;

public class PageBean {
	//表示当前页
   private Integer currentPage;
   //总记录数
   private Integer totalCount;
   //每页显示的记录数
   private Integer pageSize;
   //总页数
   private Integer totalPage;
   //开始位置
   private Integer begin;
   //每页显示的List集合
   private List<Repertory> list;
   
   
public Integer getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(Integer currentPage) {
	this.currentPage = currentPage;
}
public Integer getTotalCount() {
	return totalCount;
}
public void setTotalCount(Integer totalCount) {
	this.totalCount = totalCount;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Integer getTotalPage() {
	return totalPage;
}
public void setTotalPage(Integer totalPage) {
	this.totalPage = totalPage;
}
public Integer getBegin() {
	return begin;
}
public void setBegin(Integer begin) {
	this.begin = begin;
}
public List<Repertory> getList() {
	return list;
}
public void setList(List<Repertory> list) {
	this.list = list;
}
@Override
public String toString() {
	return "PageBean [currentPage=" + currentPage + ", totalCount=" + totalCount + ", pageSize=" + pageSize
			+ ", totalPage=" + totalPage + ", begin=" + begin + ", list=" + list + "]";
}
   
   
   
}
