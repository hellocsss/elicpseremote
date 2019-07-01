package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.ShowIndexDataDao;
import com.itcast.entity.IndentDetail;
import com.medical.webBean.IndexBar1;
import com.medical.webBean.IndexPieChart;

@Transactional
public class ShowIndexDataService {
	
	private ShowIndexDataDao showIndexDataDao;

	public void setShowIndexDataDao(ShowIndexDataDao showIndexDataDao) {
		this.showIndexDataDao = showIndexDataDao;
	}
	
	
	public Double sumOfAll() {
		
		return showIndexDataDao.sumOfAll();
	}
	
	
	
	public List<IndentDetail> countNumOfType(List<IndentDetail> listOfIndent){
		
		//showIndexDataDao.countNumOfType(listOfIndent);
		
		return null;
	}

	//本月销售总额
	public double MonthTotalMoney() {
		
		return showIndexDataDao.MonthTotalMoney();
	}

	//本月销售订单
	public int MonthTotalIndent() {
		return showIndexDataDao.MonthTotalIndent();
	}

	//本日销售总额
	public double DayTotalMoney() {
		return showIndexDataDao.DayTotalMoney();
	}

	//本日销售订单
	public int DayTotalIndent() {
		return showIndexDataDao.DayTotalIndent();
	}
	
	/**
	 * 前台扇形图
	 */
	public IndexPieChart TyprOfCharts() {
		return showIndexDataDao.TyprOfCharts();
	}
	//近7天销售金额趋势
	public IndexBar1 SevenDaysMoney(String sevenBeginDate, String sevenEndDate) throws Exception{
		// TODO Auto-generated method stub
		return showIndexDataDao.SevenDaysMoney(sevenBeginDate,sevenEndDate);
	}

	
	
}
