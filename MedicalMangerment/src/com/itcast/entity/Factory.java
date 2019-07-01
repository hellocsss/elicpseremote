package com.itcast.entity;

public class Factory {
	private Integer fid;//主键
	private String fname;//药品名称
	private double fprice; //单价
	private String fvalDate;//保质期
	private String fproductDate;//生产日期
	private Integer fnum;//数量
	private String fgongying;//供应商实体属性 1个供应商
	private String fchufang;	//类别实体属性 非处方药
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public double getFprice() {
		return fprice;
	}
	public void setFprice(double fprice) {
		this.fprice = fprice;
	}
	public String getFvalDate() {
		return fvalDate;
	}
	public void setFvalDate(String fvalDate) {
		this.fvalDate = fvalDate;
	}
	public String getFproductDate() {
		return fproductDate;
	}
	public void setFproductDate(String fproductDate) {
		this.fproductDate = fproductDate;
	}
	public Integer getFnum() {
		return fnum;
	}
	public void setFnum(Integer fnum) {
		this.fnum = fnum;
	}
	public String getFgongying() {
		return fgongying;
	}
	public void setFgongying(String fgongying) {
		this.fgongying = fgongying;
	}
	public String getFchufang() {
		return fchufang;
	}
	public void setFchufang(String fchufang) {
		this.fchufang = fchufang;
	}
	
	
	
	
	
	
	
	
	
	
	
}
