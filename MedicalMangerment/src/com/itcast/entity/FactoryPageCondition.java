package com.itcast.entity;

/**
 * 药厂列表查询条件
 * @author zby
 *
 */
public class FactoryPageCondition {

	private String fname;//药品名称
	private String fgongying;//供应商实体属性 1个供应商
	private String fchufang;	//类别实体属性 非处方药
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
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
	public FactoryPageCondition(String fname, String fgongying, String fchufang) {
		super();
		this.fname = fname;
		this.fgongying = fgongying;
		this.fchufang = fchufang;
	}
	public FactoryPageCondition() {
		super();
	}
	
	
	
	
	
	
	
	
}
