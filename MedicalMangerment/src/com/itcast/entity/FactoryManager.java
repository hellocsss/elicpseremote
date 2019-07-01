package com.itcast.entity;

public class FactoryManager {

	private int Fmid;//类别id
	private String Fmname;//名字
	private String Fmpassword; //密码
	public int getFmid() {
		return Fmid;
	}
	public void setFmid(int fmid) {
		Fmid = fmid;
	}
	public String getFmname() {
		return Fmname;
	}
	public void setFmname(String fmname) {
		Fmname = fmname;
	}
	public String getFmpassword() {
		return Fmpassword;
	}
	public void setFmpassword(String fmpassword) {
		Fmpassword = fmpassword;
	}
	@Override
	public String toString() {
		return "FactoryManager [Fmid=" + Fmid + ", Fmname=" + Fmname + ", Fmpassword=" + Fmpassword + "]";
	}
	
	
	
	
}
