package com.medical.webBean;

import java.util.List;

public class IndexBar1 {

	private List<String> xAxis;
	private List<Double> data;
	
	public List<String> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<String> xAxis) {
		this.xAxis = xAxis;
	}

	public List<Double> getData() {
		return data;
	}

	public void setData(List<Double> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return " {xAxis=" + xAxis + ", data=" + data + "}";
	}
	
	
}
