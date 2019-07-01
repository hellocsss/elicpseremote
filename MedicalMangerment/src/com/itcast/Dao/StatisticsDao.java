package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.Promot;
import com.medical.webBean.TypeBean;

public interface StatisticsDao {

	TypeBean showDate(String beginDate, String endDate) throws Exception;

	Object chooseThreeDays(String beginThreeDate, String endDate,int mark, double percent);

	Object settingNews(Integer day, Double percent);

	List<Promot> findAllSetting();

	void deleteSetting(Integer id);

	
	//遍历所有条件
	List<Promot> findPromot();


}
