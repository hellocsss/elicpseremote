package com.itcast.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.entity.IndentDetail;
import com.itcast.service.IndentDetailService;
import com.itcast.service.ShowIndexDataService;
import com.medical.webBean.IndexBar1;
import com.medical.webBean.IndexPieChart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowIndexDataAction extends ActionSupport{
	
	private ShowIndexDataService showIndexDataService;
	
	public void setShowIndexDataService(ShowIndexDataService showIndexDataService) {
		this.showIndexDataService = showIndexDataService;
	}
	
	private IndentDetailService indentDetailService;
	
	public void setIndentDetailService(IndentDetailService indentDetailService) {
		this.indentDetailService = indentDetailService;
	}




/**
 * 
 * 主页显示数据
 * @return
 * @throws IOException 
 */
	public String showIndexData(){
		
		
		
		System.out.println("主页显示数据.....");
		
		Double sumOfAll = showIndexDataService.sumOfAll();
		
		ActionContext.getContext().getValueStack().set("sumOfAll", sumOfAll);
		
		
		/**
		 * 统计本月销售总额
		 */
		System.out.println("本月总销售，来了吗老弟？");
		double MonthTotalMoney= showIndexDataService.MonthTotalMoney();
		ActionContext.getContext().getValueStack().push(MonthTotalMoney);
		System.out.println(MonthTotalMoney);
		System.out.println("本月总销售，走了老弟！");
		
		/**
		 * 统计本月销售订单
		 */
		int MonthTotalIndent =showIndexDataService.MonthTotalIndent();
		ActionContext.getContext().getValueStack().push(MonthTotalIndent);
		
		/**
		 * 统计本日销售总额
		 */
		double DayTotalMoney= showIndexDataService.DayTotalMoney();
		System.out.println(DayTotalMoney);
		ActionContext.getContext().getValueStack().push(DayTotalMoney);
		System.out.println(DayTotalMoney);
		
		/**
		 * 统计本日销售订单
		 * 
		 */
		int DayTotalIndent= showIndexDataService.DayTotalIndent();
		ActionContext.getContext().getValueStack().push(DayTotalIndent);
		
		
		
		
		
		
		return "showIndexData";
		
		
		
	}
	
	
	/**
	 * 统计前台扇形图，通过前台的ajax进入，无返回值
	 * @throws IOException 
	 */
	
	public String countNumOfType() throws IOException{
		
		System.out.println("统计前台扇形图..............");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		IndexPieChart typrOfCharts = showIndexDataService.TyprOfCharts();
		System.out.println(typrOfCharts.toString());
		
		//转json
		String jsonString = JSON.toJSONString(typrOfCharts);
		System.out.println("$$$$"+jsonString);
		response.getWriter().print(jsonString);
		
		
		return null;
	}

	/**
	 * 最近7天的销售总金额趋势
	 */
	public String SevenDaysMoney() throws Exception{
		System.out.println("？？？");
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;Character=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String SevenBeginDate;
		String SevenEndDate;
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Date end =new Date();
		SevenEndDate =sdf.format(end);
		SevenBeginDate= sdf.format(end.getTime()-6*24*60*60*1000);
		IndexBar1 indexBar1=showIndexDataService.SevenDaysMoney(SevenBeginDate,SevenEndDate);
		//转json
		String jsonString = JSON.toJSONString(indexBar1);
		response.getWriter().print(jsonString);
		
		return null;
	}
}
