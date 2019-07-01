package com.medical.webBean;

import java.util.List;
import java.util.Map;

public class pieChartPie4 {

	private List<String> data;
	
	private List<Map> seriesData;
	

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public List<Map> getSeriesData() {
		return seriesData;
	}

	public void setSeriesData(List<Map> seriesData) {
		this.seriesData = seriesData;
	}

	@Override
	public String toString() {
		return "{data=" + data + ", seriesData=" + seriesData + "}";
	}


	
}
