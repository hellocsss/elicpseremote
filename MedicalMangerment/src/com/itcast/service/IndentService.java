package com.itcast.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.IndentDao;
import com.itcast.entity.Good;
import com.itcast.entity.Indent;
import com.itcast.entity.User;
import com.itcast.utils.PageBeanPublic;

//事务的注解记得一定不要忘了加！
@Transactional
public class IndentService {

	private IndentDao indentDao;

	public void setIndentDao(IndentDao indentDao) {
		this.indentDao = indentDao;
	}


	//生成订单
	public void addIndent(Indent indent) {

		indentDao.addIndent(indent);
	}

	//查询所有的订单
	public List<Indent> findList() {
		return indentDao.findList();
	}

	//通过手机号码查询相对应的所有订单
	public List<Indent> SearchIndent(Integer uid) {
		return indentDao.SearchIndent(uid);
	}


	//订单列表分页
	public PageBeanPublic ListPage(Integer currentPage) {
		PageBeanPublic pageBeanPublic =new PageBeanPublic();
		
		//设置当前页
		pageBeanPublic.setCurrentPage(currentPage);
		
		//设置总记录数
		int total =indentDao.findCount();
		pageBeanPublic.setTotalCount(total);
		
		//每页显示的记录数
		int pageSize=8;
		pageBeanPublic.setPageSize(pageSize);
		
		//总数页
		//总页数=总记录数%每页显示记录数
		int totalPage=0;
		if(total%pageSize==0) {
			totalPage=total/pageSize;
		}else {
			totalPage=total/pageSize+1;
		}
		pageBeanPublic.setTotalPage(totalPage);
		
		//开始位置
		int begin=(currentPage-1)*pageSize;
		pageBeanPublic.setBegin(begin);
		
		List<Indent> list=indentDao.findPage(begin,pageSize);
		pageBeanPublic.setList(list);
		
		return pageBeanPublic;
	}


	//分页
	public PageBeanPublic SearchIndentPage(Integer currentPage, User user) {
		PageBeanPublic pageBeanPublic =new PageBeanPublic();
		
		//设置当前页
		pageBeanPublic.setCurrentPage(currentPage);
		
		
		//设置总记录数
		int total =indentDao.findIndentCount(user);
		pageBeanPublic.setTotalCount(total);
		
		//每页显示的记录数
		int pageSize=8;
		pageBeanPublic.setPageSize(pageSize);
		
		//总数页
		//总页数=总记录数%每页显示记录数
		int totalPage=0;
		if(total%pageSize==0) {
			totalPage=total/pageSize;
		}else {
			totalPage=total/pageSize+1;
		}
		pageBeanPublic.setTotalPage(totalPage);
		
		//开始位置
		int begin=(currentPage-1)*pageSize;
		pageBeanPublic.setBegin(begin);
		
		List<Indent> list=indentDao.findIndentPage(begin,pageSize,user);
		pageBeanPublic.setList(list);
		
		return pageBeanPublic;
	}
	
}
