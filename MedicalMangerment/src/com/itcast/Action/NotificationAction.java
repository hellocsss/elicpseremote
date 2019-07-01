package com.itcast.Action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.itcast.entity.Email;
import com.itcast.entity.Factory;
import com.itcast.entity.FactoryEmail;
import com.itcast.entity.OrderShop;
import com.itcast.service.NotificationService;
import com.medical.webBean.pieChartPie4;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class NotificationAction extends ActionSupport{
	
	private NotificationService notificationService;

	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	
	private Integer eid;
	

	private String tname;
	
	private String Date;
	
	private Integer mark;
	
	
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setDate(String date) {
		Date = date;
	}

	/**
	 * 显示通知信息
	 * @return
	 */
	
	public String showNotification(){
		
		System.out.println("显示所有通知信息");
		//查询今天的消息
		List<Email> showAllNotification = notificationService.showAllNotification();
		//查询昨天的消息
		List<Email> showYesterday = notificationService.showYesterday();
		//查询更久之前的消息
		List<Email> showOld = notificationService.showOld();
		
		
		
		//向值栈放对象
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		
		valueStack.set("showAllNotification", showAllNotification);
		valueStack.set("showYesterday", showYesterday);
		valueStack.set("showOld", showOld);
		
		
		
		
		System.out.println("action结束！");
		
		
		return "showNotification";
	}
	
	/**
	 * ajax 修改已读/未读消息
	 * @return
	 * @throws IOException 
	 */
	public void updateRead() throws IOException{
		
		System.out.println("修改已读/未读消息action！");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String eid = request.getParameter("eid");
		int parseInt = Integer.parseInt(eid);
		
		//response.getWriter().print(eid);
		
		//System.out.println(eid);
		
		//更新已读/未读
		notificationService.updateRead(parseInt);
		
		Integer upIsReadNum = notificationService.upIsReadNum();
		
		response.getWriter().print(upIsReadNum);
		
		
		
	}
	 
	
	/**
	 * ajax 显示小圆点未读/数量
	 * @return
	 * @throws IOException 
	 */
	public void upIsReadNum() throws IOException{
		
		System.out.println("显示小圆点未读/数量action！");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		//未读数量upIsReadNum
		Integer upIsReadNum = notificationService.upIsReadNum();
		
		response.getWriter().print(upIsReadNum);
		
		
		
	}
	
	//邮件查看详情（ypf+）
	public String lookMore() {

		try {
		HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
		
			Email email= notificationService.findEmail(eid);
			
			
			
			String beginDate;
			String endDate;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date;

			date = sdf.parse(email.getDate());
			endDate = sdf.format(date.getTime() - 1 * 24 * 60 * 60 * 1000);
			
			beginDate = sdf.format(date.getTime() - email.getMark() * 24 * 60 * 60 * 1000);
			
			pieChartPie4  piechartPie4= notificationService.lookMore(beginDate,endDate,email.getTname());
			
			//转json
			String jsonString = JSON.toJSONString(piechartPie4);
			System.out.println("$$$$"+jsonString);
			response.getWriter().print(jsonString);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
	//发送邮件给药厂
	public String send() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String eidString = request.getParameter("eid");
		Integer eid =Integer.valueOf(eidString);
		System.out.println(eid+"[][][][][].....");
		
		Email email =notificationService.findEmail(eid);
		FactoryEmail factoryEmail =new FactoryEmail();
		String content ="理工大药房：【"+email.getTname()+"】药品销售近"+email.getMark()+"天数据增长异常！";
		factoryEmail.setName(content);
		factoryEmail.setContent(email.getContent());
		
		//设置发送时间为 今日
		Date date =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(date);
		factoryEmail.setDate(dateString);
		factoryEmail.setIsread("未读");
		factoryEmail.setMark(email.getMark());
		factoryEmail.setPercent(email.getPercent());
		factoryEmail.setSendName("理工大药房");
		factoryEmail.setTname(email.getTname());
		factoryEmail.setEid(eid);
	
		
		//增加邮件
		notificationService.sendFactoryEmail(factoryEmail);
		System.out.println("...send!!");
		
		
		/*
		 * HttpServletResponse response = ServletActionContext.getResponse();
		 * FactoryAction.writePop(response,"发送成功！已转发至药厂","history.back();");
		 */
		 
		 
		System.out.println("...send");
		return "send";
	}
}
