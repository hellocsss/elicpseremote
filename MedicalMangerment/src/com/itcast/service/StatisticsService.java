package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.StatisticsDao;
import com.itcast.entity.Promot;
import com.medical.webBean.TypeBean;

@Transactional
public class StatisticsService {

	private StatisticsDao statisticsDao;

	public void setStatisticsDao(StatisticsDao statisticsDao) {
		this.statisticsDao = statisticsDao;
	}
	
	//
	public TypeBean showDate(String beginDate, String endDate) throws Exception {
		return statisticsDao.showDate(beginDate,endDate);
	}

	public Object chooseThreeDays(String beginDate, String endDate,int mark, double percent) {
		
		return statisticsDao.chooseThreeDays(beginDate,endDate,mark,percent);
		
	}
	
	/**
	 * 插入设置的提示反馈信息
	 * @return 
	 */
	public Object settingNews(Integer day, Double percent) {
		
		return statisticsDao.settingNews(day,percent);
		
	}

	public List<Promot> findAllSetting() {
		// TODO Auto-generated method stub
		return statisticsDao.findAllSetting();
		
	}

	public void deleteSetting(Integer id) {
		// TODO Auto-generated method stub
		 statisticsDao.deleteSetting(id);
	}

	
	//遍历所有条件
	public List<Promot> findPromot() {
		return statisticsDao.findPromot();
	}
	
	
	
}
