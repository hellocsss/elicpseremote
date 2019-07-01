package com.itcast.DaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.ShowIndexDataDao;
import com.itcast.entity.IndentDetail;
import com.itcast.utils.GetDays;
import com.medical.webBean.IndexBar1;
import com.medical.webBean.IndexPieChart;
import com.opensymphony.xwork2.util.ResolverUtil.NameEndsWith;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class ShowIndexDataImpl implements ShowIndexDataDao{
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/**
	 * 首页显示销售总金额
	 * @return
	 */
	public Double sumOfAll() {
		
		List<IndentDetail> IndentDetail = (List<com.itcast.entity.IndentDetail>) hibernateTemplate.find("from IndentDetail");
		Double sum = 0.0;
		
		for (IndentDetail indentDetail2 : IndentDetail) {
			System.out.println(indentDetail2.getSubtotal());
			
			sum = sum + indentDetail2.getSubtotal();
		}
		
		
		return sum;
	}
	
	/**
	 * 统计当天各个类别的销售数量
	 */
	public List<IndentDetail> countNumOfType(List<IndentDetail> listOfIndent) {
		
//		List<IndentDetail> findday = (List<IndentDetail>) hibernateTemplate.find("select SUM(count),tname from Indentdetail where TO_DAYS(NOW())=TO_DAYS(?)",today);
//		
//		for (IndentDetail indentDetail : findday) {
//			System.out.println(indentDetail.toString());
//		}
		
		return null;
	}

	@Override
	public List<IndentDetail> countNumOfType(String today) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 本月销售总额
	 */
	@Override
	public double MonthTotalMoney() {
		System.out.println("impl每月的到了吗");
		List<Double> list = (List<Double>) hibernateTemplate.find("select SUM(subtotal) \r\n" + 
				"from IndentDetail \r\n" + 
				"where DATE_FORMAT(Date,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')");
		if(list.size()>0 && list.get(0)!=null) {
			return list.get(0);
		}
		System.out.println("impl每月的出了吗");
		return 0.0;
	}

	/**
	 * 本月销售订单总数
	 */
	@Override
	public int MonthTotalIndent() {
		List<Integer> list = (List<Integer>) hibernateTemplate.find("select iid\r\n" + 
				"from Indent\r\n" + 
				"where DATE_FORMAT(Date,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')");
		if(list.size()>0) {
			return list.size();
		}
		return 0;
	}

	/**
	 * 本日销售总金额
	 */
	@Override
	public double DayTotalMoney() {
		List<Double>	list = (List<Double>) hibernateTemplate.find("select SUM(subtotal) \r\n" + 
				"from IndentDetail \r\n" + 
				"where TO_DAYS(Date)=TO_DAYS(NOW())");
		if(list.size()>0 && list.get(0)!=null) {
			System.out.println(list);
			System.out.println("还是会进来？");
			return list.get(0);
		}
		System.out.println(list.size()+"0.0");
		return 0.0;
		
	}

	/**
	 * 本日订单销售总数
	 */
	@Override
	public int DayTotalIndent() {
		List<Integer> list = (List<Integer>) hibernateTemplate.find("select iid \r\n" + 
				"from Indent\r\n" + 
				"where TO_DAYS(Date)=TO_DAYS(NOW())");
		if(list.size()>0) {
			System.out.println(list);
			return list.size();
		}
		System.out.println(list);
		return 0;
	}

	/**
	 * 前台扇形图,
	 */
	@Override
	public IndexPieChart TyprOfCharts() {
		
		System.out.println("前台扇形图...........");
	
		//Map 查询字段取别名，new map
		//通过别名作为map集合的键，就可以取到对应的值
		List<Map> findTypeNum = (List<Map>) hibernateTemplate.find("select new map(SUM(countes)as value,tname as name )\r\n" + 
				"from IndentDetail\r\n" + 
				"where TO_DAYS(Date)=TO_DAYS(NOW())\r\n" + 
				"group by tname\r\n");
		
		//声明一个临时保存类别名的集合
		List<String> nameList = new ArrayList<String>();
		
		//把类别名保存到集合里
		for (Map map : findTypeNum) {
			//System.out.println(map.get("name")+":"+map.get("value"));
			nameList.add((String) map.get("name"));
		}
		
		//把值放入实体类
		IndexPieChart indexPieChart = new IndexPieChart();
		indexPieChart.setDatas(findTypeNum);
		indexPieChart.setLegend(nameList);
		
		System.out.println(indexPieChart.toString());
		
				
		
		
		return indexPieChart;

	}
	
	/**
	 * 近7天的销售金额
	 * @throws Exception 
	 */
	@Override
	public IndexBar1 SevenDaysMoney(String sevenBeginDate, String sevenEndDate) throws Exception {
		System.out.println(sevenBeginDate+"..ovo.."+sevenEndDate);
		List<Double> list = (List<Double>) hibernateTemplate.find("select SUM(subtotal)\r\n" + 
				"from IndentDetail\r\n" + 
				"WHERE Date <= ? and Date >= ?\r\n" + 
				"GROUP BY Date", sevenEndDate,sevenBeginDate);
		System.out.println("list是："+list);
		IndexBar1 indexBar1 =new IndexBar1();
		indexBar1.setData(list);
		List dateList =GetDays.getDays(sevenBeginDate, sevenEndDate);
		indexBar1.setxAxis(dateList);
		System.out.println("您好？"+indexBar1);
		return indexBar1;
	}
	
	
	

	
	
}
