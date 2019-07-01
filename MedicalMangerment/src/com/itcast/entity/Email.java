package com.itcast.entity;

/**
 * 药店邮件列表实体类
 * @author ypf
 *
 */
public class Email {
	private Integer eid;
	private String name;
	private String Date;
	private Integer mark;
	private String tname;
	private String isread;//是否已读 0/1
	private String content;
	private Double percent; //比例
	
	
	
	

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
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
	
	
	
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "Email [eid=" + eid + ", name=" + name + ", Date=" + Date + ", mark=" + mark + ", tname=" + tname
				+ ", isread=" + isread + ", content=" + content + ", percent=" + percent + "]";
	}
	
	
	
}
