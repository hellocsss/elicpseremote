package com.itcast.entity;

public class Indent {

	private Integer iid;
	private String indentid;
	private Double indentPrice;
	private String indentDate;
	private String Date;
	
	
	private User user;

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	

	public String getIndentid() {
		return indentid;
	}

	public void setIndentid(String indentid) {
		this.indentid = indentid;
	}

	public Double getIndentPrice() {
		return indentPrice;
	}

	public void setIndentPrice(Double indentPrice) {
		this.indentPrice = indentPrice;
	}

	public String getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(String indentDate) {
		this.indentDate = indentDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "Indent [iid=" + iid + ", indentid=" + indentid + ", indentPrice=" + indentPrice + ", indentDate="
				+ indentDate + ", Date=" + Date + ", user=" + user + "]";
	}

	

	
	
}
