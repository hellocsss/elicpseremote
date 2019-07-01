package com.itcast.DaoImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.From;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.NotificationDao;
import com.itcast.entity.Email;
import com.itcast.entity.FactoryEmail;
import com.medical.webBean.pieChartPie4;

public class NotificationDaoImpl implements NotificationDao{
	
	//在Dao中注入hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

		/**
		 * 展示今天的通知信息
		 */
		@Override
		public List<Email> showNotificationAll() {
			
			/**
			 * 得到今天的日期
			 */
			String todayString;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			todayString = sdf.format(today);
			
			//查询今天的通知日期
			List<Email> TodayEmail = (List<Email>) hibernateTemplate.find("from Email where Date = ? order by Date,eid desc",todayString);
			
			for (Email email : TodayEmail) {
				System.out.println(email.toString());
			}
			
			
			return TodayEmail;
		}

		
		
		@Override
		public void updateRead(Integer eid) {
			
			Email findemail = hibernateTemplate.get(Email.class, eid);
			findemail.setIsread("已读");
			
			hibernateTemplate.update(findemail);
			
			
		}
		
		/**
		 * 显示昨天的通知消息
		 */
		@Override
		public List<Email> showYesterday() {
			/**
			 * 得到今天的日期
			 */
			String yesterdayString;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date yesterday = new Date();
			yesterdayString = sdf.format(yesterday.getTime()-1*24*60*60*1000);
			
			//查询今天的通知日期
			List<Email> yesterdayEmail = (List<Email>) hibernateTemplate.find("from Email where Date = ? order by Date,eid desc",yesterdayString);
			
			for (Email email : yesterdayEmail) {
				System.out.println(email.toString());
			}
			
			
			return yesterdayEmail;
		}

		/**
		 * 查询更久之前的消息
		 */
		@Override
		public List<Email> showOld() {
			String oldString;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date old = new Date();
			oldString = sdf.format(old.getTime()-2*24*60*60*1000);
			System.out.println("--"+oldString);
			//查询今天的通知日期
			List<Email> oldEmail = (List<Email>) hibernateTemplate.find("from Email \r\n" + 
					"where Date <=? order by Date,eid desc",oldString);
			
			for (Email email : oldEmail) {
				System.out.println(email.toString());
			}
			System.out.println("... ovo");
			
			return oldEmail;
		}

		
		/**
		 * ajax 显示小圆点未读/数量
		 * @return
		 * @throws IOException 
		 */
		@Override
		public Integer upIsReadNum() {
			
			List<Email> unRead = (List<Email>) hibernateTemplate.find("from Email where isread = '未读' ");
			
			//如果未读数量大于0
			if(unRead.size()>0) {
				return unRead.size();
			}
			
			return 0;
		}
		/**
		 * 邮件查看详情
		 */
		@Override
		public pieChartPie4 lookMore(String beginDate, String endDate, String tname) {
			//根据药品分组查询相应时间，相应类别的药品。
			List<Map> list = (List<Map>) hibernateTemplate.find("SELECT new Map(SUM(countes) as value,gname as name)\r\n" + 
					"from IndentDetail\r\n" + 
					"where Date >= ? and Date <=? and tname=?\r\n" + 
					"GROUP BY gname", beginDate,endDate,tname);
			
			pieChartPie4 piechartPie4 =new pieChartPie4();
			
			List<String> listString =new ArrayList<String>();
			for (Map m : list) {
				listString.add((String) m.get("name"));
			}
			
			piechartPie4.setData(listString);
			piechartPie4.setSeriesData(list);
			
			System.out.println("能出来吗？"+piechartPie4);
			return piechartPie4;
		}

		
		//根据id查询邮件
		@Override
		public Email findEmail(Integer eid) {
			List<Email> list = (List<Email>) hibernateTemplate.find("from Email where eid =?", eid);
			if(list.size()>0) {
				return list.get(0);
			}
			return null;
		}

		
		//发送邮件到药厂
		@Override
		public void sendFactoryEmail(FactoryEmail factoryEmail) {
			hibernateTemplate.save(factoryEmail);
		}

}
