package com.itcast.DaoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;import org.w3c.dom.ls.LSException;

import com.itcast.Dao.StatisticsDao;
import com.itcast.entity.Email;
import com.itcast.entity.IndentDetail;
import com.itcast.entity.Promot;
import com.itcast.entity.Type;

import com.itcast.utils.GetDays;
import com.medical.webBean.TypeBean;

public class StatisticsDaoImpl implements StatisticsDao{

private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 	得到一个时间段内的各个类别的销售量
	 * @throws Exception 
	 */
	@Override
	public TypeBean showDate(String beginDate,String endDate) throws Exception {

		System.out.println("开始得到一个时间段内的各个类别的销售量。。。。。");
		
		System.out.println("统计的能来吗？");
//		String DateBegin="2019-05-01";
//		String DateEnd="2019-05-05";
		
		
		//查询所有类别
		List<String> findType = (List<String>) hibernateTemplate.find("select tname from Type");
		for (String type : findType) {
			System.out.println(type.toString());
		}
		ArrayList<List<Integer>> datas = new ArrayList<>();
		
		for (String type : findType) {
			System.out.println("for............................."+type);
			List<Integer> list = (List<Integer>)hibernateTemplate.find("SELECT SUM(countes) as data " + 
					"from IndentDetail \r\n" + 
					"where Date <= ? and Date >= ? and tname = ?\r\n" + 
					"group by tname,Date", endDate,beginDate,type);
			System.out.println("jieshu..."+list);
		
			//遍历查出来的销量，如果有为空的，赋值为0
			
			/*
			 * List<Integer> dataList =new ArrayList<Integer>();
			 * 
			 * for (Map list2 : list) { Integer i = (Integer) list2.get(list2.keySet());
			 * dataList.add(i); }
			 */
			 
			datas.add(list);
			
			System.out.println(list.toString());
		}
		
		
		//传入开始时间/结束时间两个参数
		List days;

		days = GetDays.getDays(beginDate, endDate);
		TypeBean tmpBean = new TypeBean();
		tmpBean.setLegend(findType);
		tmpBean.setDatas(datas);
		tmpBean.setxAxis(days);
		System.out.println(tmpBean.toString());
			
		
		
		return tmpBean;
	}
	
	
	/**
	 * ajax,选择日期智能反馈
	 */
	public void feedback() {

		
	}
	
	/**
	 * 反馈3天的信息
	 */
	@Override
	public Object chooseThreeDays(String beginDate, String endDate, int mark,double percent) {
		
		System.out.println("反馈3天的信息impl...........");
		List<Map> BeginCounts = (List<Map>) hibernateTemplate.find("select new Map(SUM(countes) as count,tname as name) from IndentDetail where Date = ? group by tname order by tname", beginDate);
		List<Map> EndCounts = (List<Map>) hibernateTemplate.find("select new Map(SUM(countes) as count,tname as name) from IndentDetail where Date = ? group by tname order by tname", endDate);
		
		for (Map beginMap : BeginCounts) {
			//System.out.println(beginMap.get("count")+":"+beginMap.get("name"));
			for (Map endMap : EndCounts) {
				//System.out.println(endMap.get("count")+":"+endMap.get("name"));
				if(beginMap.get("name").equals(endMap.get("name"))) {
					
					int end = Integer.parseInt(String.valueOf(endMap.get("count")));
					int begin = Integer.parseInt(String.valueOf(beginMap.get("count")));
					
					//计算得到两个日期类别销售数量相差比例
					double percentRatio =percent/100;
					double ratio = (end - begin)/begin;
					//如果比率大于0.5
					if(ratio > percentRatio) {
						System.out.println(endMap.get("name")+ ":" +ratio);
						
						/**
						 * 得到今天的日期
						 */
						String todayString;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date today = new Date();
						todayString = sdf.format(today);
						String message = null;
						
						List<Email> findEmail = (List<Email>) hibernateTemplate.find("from Email where mark = ? and Date = ? and tname = ? and percent=?",mark,todayString,endMap.get("name"),percent);
						
						if(findEmail.size() == 0) {

							message =  "系统消息："+"【"+endMap.get("name")+"】"+ "药品销售近"+mark+"天数据异常反馈！";
								
							Email email = new Email();
							email.setDate(todayString);
							email.setMark(mark);
							email.setName(message);
							String tname = String.valueOf(endMap.get("name"));
							email.setTname(tname);
							email.setIsread("未读");
							email.setPercent(percent);
							String contentString = beginDate+"-"+endDate +"期间"+endMap.get("name")+"药品销售数据超出"+ratio*100+"%"+"，数据异常。";
							email.setContent(contentString);
							
							
							hibernateTemplate.save(email);
							
							
						}
						
						
						
						
					}
									
					
				}
				
			}
			
		}
		System.out.println("######################");
		
		
		
		
		return BeginCounts;
	}
	
	
	
	
	/**
	 * 插入设置的提示反馈信息
	 * @return 
	 */
	@Override
	public Object settingNews(Integer day, Double percent) {
		// TODO Auto-generated method stub
		
		
		
		List<Promot> news = (List<Promot>) hibernateTemplate.find("from Promot where daynum = ? and percent = ?", day,percent);
		
		if(news.size()>0) {
			System.out.println("规则已经存在！");
			
		}else {
			Promot setting = new Promot();
			setting.setDaynum(day);
			setting.setMark(day);
			setting.setPercent(percent);
			hibernateTemplate.saveOrUpdate(setting);			
		}
		
		
		
		return null;
	}

	
	@Override
	public List<Promot> findAllSetting() {
		// TODO Auto-generated method stub
		
		List<Promot> allpromot = (List<Promot>) hibernateTemplate.find("from Promot");
		
		return allpromot;
	}

	/**
	 * 删除规则
	 */
	@Override
	public void deleteSetting(Integer id) {
		// TODO Auto-generated method stub
		Promot promot = hibernateTemplate.get(Promot.class, id);
		
		hibernateTemplate.delete(promot);
		
	}

	
	//遍历所有条件
	@Override
	public List<Promot> findPromot() {
		List<Promot> list = (List<Promot>) hibernateTemplate.find("from Promot");
		
		return list;
	}
	
	
	
	
	
	
	
	
	
}
