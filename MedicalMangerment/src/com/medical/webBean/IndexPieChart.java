package com.medical.webBean;

import java.util.List;
import java.util.Map;

public class IndexPieChart {
	
	
	private List<Map> datas;
	
	private List<String> legend;

	
	
	public List<Map> getDatas() {
		return datas;
	}

	public void setDatas(List<Map> datas) {
		this.datas = datas;
	}

	public List<String> getLegend() {
		return legend;
	}

	public void setLegend(List<String> legend) {
		this.legend = legend;
	}

	@Override
	public String toString() {
		return "IndexPieChart [datas=" + datas + ", legend=" + legend + "]";
	}
	

	
	
	

}
