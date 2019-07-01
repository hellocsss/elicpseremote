package com.itcast.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.NotificationDao;
import com.itcast.entity.Email;
import com.itcast.entity.FactoryEmail;
import com.medical.webBean.pieChartPie4;

//事务的注解记得一定不要忘了加！
@Transactional
public class NotificationService {
	
	private NotificationDao notificationDao;

	public NotificationDao getNotificationDao() {
		return notificationDao;
	}

	public void setNotificationDao(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
	}

	/**
	 * 展示今天的通知信息
	 * @return 
	 */
	public List<Email> showAllNotification() {
		// TODO Auto-generated method stub
		return notificationDao.showNotificationAll();
		
	}

	/**
	 * 修改已读/未读消息
	 * @return
	 */
	public void updateRead(Integer eid) {
		// TODO Auto-generated method stub
		notificationDao.updateRead(eid);
		
	}
	/**
	 * 查询昨天的消息
	 * @return
	 */
	public List<Email> showYesterday() {
		// TODO Auto-generated method stub
		return notificationDao.showYesterday();
	}

	/**
	 * 查询更久之前的消息
	 * @return
	 */
	public List<Email> showOld() {
		// TODO Auto-generated method stub
		return notificationDao.showOld();
	}
	
	/**
	 * ajax 显示小圆点未读/数量
	 * @return
	 * @throws IOException 
	 */
	public Integer upIsReadNum() {
		
		Integer upIsReadNum = notificationDao.upIsReadNum();
		
		return upIsReadNum;

		
	}

	//邮件查看详情
	public pieChartPie4 lookMore(String beginDate, String endDate, String tname) {
		return notificationDao.lookMore(beginDate,endDate,tname);
	}

	//根据id查询邮件
	public Email findEmail(Integer eid) {
		
		return notificationDao.findEmail(eid);
	}

	//发送邮件到药厂
	public void sendFactoryEmail(FactoryEmail factoryEmail) {

		notificationDao.sendFactoryEmail(factoryEmail);
	}
	

}
