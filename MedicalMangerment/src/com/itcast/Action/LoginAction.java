package com.itcast.Action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.Admin;
import com.itcast.entity.Clerk;
import com.itcast.entity.FactoryManager;
import com.itcast.service.AdminService;
import com.itcast.service.ClerkService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	//注入Service
	private ClerkService clerkService;
	
	private AdminService adminService;
	
	//设置属性驱动
	private String name;
	
	private String password;
	
	
	public void setName(String name) {
		this.name = name;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setClerkService(ClerkService clerkService) {
		this.clerkService = clerkService;
	}


	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	//店员登录
	public String checkLogin() throws IOException {
		Clerk clerk=new Clerk();
		clerk.setCname(name);
		clerk.setCpassword(password);
		Clerk clerklogin =clerkService.findClerk(clerk);
		System.out.println("lalal");
		ServletActionContext.getRequest().getSession().setAttribute("clerklogin", clerklogin);
		if(clerklogin!=null) {
			System.out.println(ServletActionContext.getRequest().getSession().getAttribute("clerklogin"));
		return "clerklogin";
		}else {
			HttpServletResponse response = ServletActionContext.getResponse();
			FactoryAction.writePop(response,"账号或密码错误","history.back();");
		}
		return null;
	}
	
	//店长登录
	public String adminLogin() throws IOException {
		ServletActionContext.getRequest().getSession().removeAttribute("clerklogin");

		Admin admin=new Admin();
		admin.setName(name);
		admin.setPassword(password);
		Admin adminlogin=adminService.findAdmin(admin);
		ServletActionContext.getRequest().getSession().setAttribute("adminlogin", adminlogin);
		if(adminlogin!=null) {
			
			return "adminlogin";
		}else {
			HttpServletResponse response = ServletActionContext.getResponse();
			FactoryAction.writePop(response,"账号或密码错误","history.back();");
		}
		return null;
	}
	

	//药厂管理员登录
	public String factoryManager() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
	
		FactoryManager fm=new FactoryManager();
		fm.setFmname(name);
		fm.setFmpassword(password);
		
		FactoryManager factoryManager = adminService.factoryManager(fm);
		if(factoryManager == null) {
			HttpServletResponse response = ServletActionContext.getResponse();
			FactoryAction.writePop(response,"账号或密码错误","history.back();");
			return null;
		}else {
			ServletActionContext.getRequest().getSession().setAttribute("factoryManager", factoryManager);
			return "factoryManager";
		}
		
		
		
	}
	
	//退出登录
	public  String loginOut() {
		ServletActionContext.getRequest().getSession().removeAttribute("clerklogin");
	    ServletActionContext.getRequest().getSession().removeAttribute("adminlogin");
		return "loginOut";
	}
	
	//药厂管理员退出登录
	public  String factoryManagerloginOut() {
		ServletActionContext.getRequest().getSession().removeAttribute("factoryManager");
		return "factoryManagerloginOut";
	}
}
