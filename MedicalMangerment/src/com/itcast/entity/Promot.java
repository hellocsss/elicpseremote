package com.itcast.entity;

public class Promot {
	
	private Integer id;
	private Integer daynum;
	private Double percent;
	private Integer mark;
	
	
	
	
	@Override
	public String toString() {
		return "promot [id=" + id + ", daynum=" + daynum + ", percent=" + percent + ", mark=" + mark + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDaynum() {
		return daynum;
	}
	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}

	
	
	
	
	

}
