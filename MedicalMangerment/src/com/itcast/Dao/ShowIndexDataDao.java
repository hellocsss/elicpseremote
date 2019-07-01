package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.IndentDetail;
import com.medical.webBean.IndexBar1;
import com.medical.webBean.IndexPieChart;

public interface ShowIndexDataDao {
	
	
	public Double sumOfAll();
	
	
	public List<IndentDetail> countNumOfType(String today);


	//本月销售金额总数
	public double MonthTotalMoney();

	//本月销售订单总数
	public int MonthTotalIndent();

	//本日销售金额总数
	public double DayTotalMoney();

	//本日销售订单总数
	public int DayTotalIndent();
	
	/**
	 * 前台扇形图
	 */
	public IndexPieChart TyprOfCharts();
	
	//近7天的销售
	public IndexBar1 SevenDaysMoney(String sevenBeginDate, String sevenEndDate) throws Exception;
	

}
