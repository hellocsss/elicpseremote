package com.itcast.Dao;

import java.io.IOException;
import java.util.List;

import com.itcast.entity.Email;
import com.itcast.entity.FactoryEmail;
import com.medical.webBean.pieChartPie4;

public interface NotificationDao {
	
	/**
	 * 展示今天的通知信息
	 * @return
	 */
	List<Email> showNotificationAll();

	/**
	 * 修改已读/未读消息
	 * @return
	 */
	void updateRead(Integer eid);

	/**
	 * 显示昨天的通知消息
	 * @return
	 */
	List<Email> showYesterday();

	/**
	 * 查询更久之前的消息
	 * @return
	 */
	List<Email> showOld();

	/**
	 * ajax 显示小圆点未读/数量
	 * @return
	 * @throws IOException 
	 */
	Integer upIsReadNum();

	
	//邮件查看详情
	pieChartPie4 lookMore(String beginDate, String endDate, String tname);

	
	//根据id查询邮件
	Email findEmail(Integer eid);
	
	
	//发送邮件到药厂
	void sendFactoryEmail(FactoryEmail factoryEmail);

	
	
	
	

	
	

}
