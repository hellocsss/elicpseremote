package com.itcast.entity;

import java.util.List;

public class FactoryJson {
	private  Integer code;
	private String msg;
	private  Integer count;
	private List<Factory> data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Factory> getData() {
		return data;
	}
	public void setData(List<Factory> data) {
		this.data = data;
	}
	
}
