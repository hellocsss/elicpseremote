package com.itcast.entity;

import javax.persistence.criteria.CriteriaBuilder.In;

public class FactoryEmail {

	private Integer feid;
	private String name;//邮件标题
	private String Date;//邮件时间
	private Integer mark;//标记
	private String tname;//种类
	private String isread;//是否已读 0/1
	private String content;//文章内容
	private Double percent; //比例
	private String sendName;//发送人
	private Integer eid;
	
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getFeid() {
		return feid;
	}
	public void setFeid(Integer feid) {
		this.feid = feid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	@Override
	public String toString() {
		return "FactoryEmail [feid=" + feid + ", name=" + name + ", Date=" + Date + ", mark=" + mark + ", tname="
				+ tname + ", isread=" + isread + ", content=" + content + ", percent=" + percent + ", sendName="
				+ sendName + ", eid=" + eid + "]";
	}
	
	
	
}

