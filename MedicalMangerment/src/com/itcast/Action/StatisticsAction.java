package com.itcast.Action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.entity.Promot;
import com.itcast.service.StatisticsService;
import com.medical.webBean.TypeBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import javafx.scene.web.PromptData;

public class StatisticsAction implements ModelDriven<Promot> {

	private StatisticsService statisticsService;

	/**
	 * 模型驱动封装，封装商品jsp页面提交的表单信息
	 * 
	 * @author ysx
	 */
	Promot promot = new Promot();

	public Promot getPromot() {
		return promot;
	}

	public void setPromot(Promot promot) {
		this.promot = promot;
	}

	public StatisticsService getStatisticsService() {
		return statisticsService;
	}

	public void setStatisticsService(StatisticsService statisticsService) {

		this.statisticsService = statisticsService;
	}

	/**
	 * 默认统计7天数据的方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showDate() throws Exception {

		System.out.println("Action!!!");

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;Character=utf-8");
		response.setCharacterEncoding("UTF-8");

		String beginDate;
		String endDate;

		String timeRange = request.getParameter("timeRange");
		System.out.println(timeRange+"timeRange的值");

		if (timeRange == null || timeRange.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date end = new Date();
			endDate = sdf.format(end.getTime() - 1 * 24 * 60 * 60 * 1000);
			beginDate = sdf.format(end.getTime() - 7 * 24 * 60 * 60 * 1000);
		} else {
			String[] split = timeRange.split(" ");
			beginDate = split[0];
			endDate = split[2];
		}

		// 得到一个时间段内的各个类别的销售量
		TypeBean showDate = statisticsService.showDate(beginDate, endDate);

		// 转为json
		String jsonString = JSON.toJSONString(showDate);
		System.out.println("$$$$" + jsonString);
		PrintWriter writer = response.getWriter();
		writer.print(jsonString);
		writer.close();

		// 查询数据库中所有的条件
		List<Promot> listPromot = statisticsService.findPromot();
		// 遍历每个条件
		for (Promot promot : listPromot) {
			// 天数
			int daynum = promot.getDaynum();
			// 比例
			double percent = promot.getPercent();
			// 标记
			int mark = promot.getMark();

			// 开始日期结束日期
			String beginDatePromot;
			String endDatePromot;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date end = new Date();
			// 结束日期（今日时间-1天）
			endDatePromot = sdf.format(end.getTime() - 1 * 24 * 60 * 60 * 1000);
			// 开始日期（今日时间-daynum）
			beginDatePromot = sdf.format(end.getTime() - daynum * 24 * 60 * 60 * 1000);
			System.out.println(beginDatePromot+".."+endDatePromot);
			statisticsService.chooseThreeDays(beginDatePromot, endDatePromot, mark, percent);
		}

		System.out.println("结束.。。。。。。。。。。。。。。。。。");

		return "showIndexData";
	}

	/**
	 * ajax,选择日期智能反馈
	 */
	/*
	 * public String feedback() {
	 * 
	 * System.out.println("ajax,智能反馈......."); HttpServletResponse response =
	 * ServletActionContext.getResponse(); HttpServletRequest request =
	 * ServletActionContext.getRequest();
	 * response.setContentType("text/html;Character=utf-8");
	 * response.setCharacterEncoding("UTF-8");
	 * 
	 * String count = request.getParameter("count"); System.out.println(count); int
	 * parseInt = Integer.parseInt(count);
	 * 
	 * 
	 *//**
		 * 生成今天和过去7天的日期
		 *//*
			 * String beginThreeDate; String beginSevenDate;
			 * 
			 * String endDate; SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 * Date end = new Date(); endDate = sdf.format(end.getTime() - 1 * 24 * 60 * 60
			 * * 1000);
			 * 
			 * //3天 beginThreeDate = sdf.format(end.getTime() - 3 * 24 * 60 * 60 * 1000);
			 * //7天 beginSevenDate = sdf.format(end.getTime() - 7 * 24 * 60 * 60 * 1000);
			 * 
			 * 
			 * //3天 if(parseInt == 1) { System.out.println("三天action..."); Object
			 * chooseThreeDays =
			 * statisticsService.chooseThreeDays(beginThreeDate,endDate,3);
			 * 
			 * //7天 }else if (parseInt == 2) { Object chooseSevernDays =
			 * statisticsService.chooseThreeDays(beginSevenDate,endDate,7); //3天和7天 }else
			 * if(parseInt == 3) { Object chooseThreeDays =
			 * statisticsService.chooseThreeDays(beginThreeDate,endDate,3); Object
			 * chooseSevernDays =
			 * statisticsService.chooseThreeDays(beginSevenDate,endDate,7);
			 * 
			 * }else {
			 * 
			 * }
			 * 
			 * 
			 * 
			 * 
			 * return null; }
			 */

	/**
	 * 智能反馈
	 */
	public String feedbackNum() {

		System.out.println("ajax,选择日期智能反馈");
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;Character=utf-8");
		response.setCharacterEncoding("UTF-8");

//		String day = request.getParameter("day");
//		String ratio = request.getParameter("ratio");
//		
//		System.out.println("%%%%%%%%%%%%%%%%"+day+ratio);
//		
//		Integer mark;
//		int parseInt = Integer.parseInt(day);
//		double parseDouble = Double.parseDouble(ratio);

		Integer daynum = promot.getDaynum();

		Double percent = promot.getPercent();

		statisticsService.settingNews(daynum, percent);
		
		// 查询数据库中所有的条件
				List<Promot> listPromot = statisticsService.findPromot();
				// 遍历每个条件
				for (Promot promot : listPromot) {
					// 天数
					int daynum1 = promot.getDaynum();
					// 比例
					double percent1 = promot.getPercent();
					// 标记
					int mark = promot.getMark();

					// 开始日期结束日期
					String beginDatePromot;
					String endDatePromot;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date end = new Date();
					// 结束日期（今日时间-1天）
					endDatePromot = sdf.format(end.getTime() - 1 * 24 * 60 * 60 * 1000);
					// 开始日期（今日时间-daynum）
					beginDatePromot = sdf.format(end.getTime() - daynum1 * 24 * 60 * 60 * 1000);
					System.out.println(beginDatePromot+".."+endDatePromot);
					statisticsService.chooseThreeDays(beginDatePromot, endDatePromot, mark, percent1);
				}

				System.out.println("结束.。。。。。。。。。。。。。。。。。");
		
		

		return "feedbackNum";

	}

	/**
	 * 查找所有规则
	 * 
	 * @return
	 */
	public String findAllSetting() {

		List<Promot> findAllSetting = statisticsService.findAllSetting();
		ActionContext.getContext().getValueStack().set("findAllSetting", findAllSetting);

		return "findAllSetting";

	}

	/**
	 * 删除规则
	 * 
	 * @return
	 */
	public String deleteSetting() {

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;Character=utf-8");
		response.setCharacterEncoding("UTF-8");

		String promotid = request.getParameter("promotid");
		int parseInt = Integer.parseInt(promotid);

		statisticsService.deleteSetting(parseInt);

		return "deleteSetting";
	}

	@Override
	public Promot getModel() {
		// TODO Auto-generated method stub
		return promot;
	}

}
