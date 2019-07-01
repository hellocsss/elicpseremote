package com.medical.webBean;

import java.util.ArrayList;
import java.util.List;

public class TypeBean {
	
	private List<String> legend;
	private List<String> xAxis;
	private List<List<Integer>> datas;
	
	
	
	public List<String> getLegend() {
		return legend;
	}
	public void setLegend(List<String> legend) {
		this.legend = legend;
	}
	public List<String> getxAxis() {
		return xAxis;
	}
	public void setxAxis(List<String> xAxis) {
		this.xAxis = xAxis;
	}
	
	
	public List<List<Integer>> getDatas() {
		return datas;
	}
	public void setDatas(List<List<Integer>> datas) {
		this.datas = datas;
	}
	@Override
	public String toString() {
		return "{legend=" + legend + ", xAxis=" + xAxis + ", datas=" + datas + "}";
	}

}
