package com.itcast.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.RepertoryDao;
import com.itcast.entity.Good;
import com.itcast.entity.OrderDetail;
import com.itcast.entity.PageBean;
import com.itcast.entity.Repertory;

//事务的注解记得一定不要忘了加！
@Transactional
public class RepertoryService {
//在service 注入 RepertoryDao
	private RepertoryDao repertoryDao;

	public RepertoryDao getRepertoryDao() {
		return repertoryDao;
	}

	public void setRepertoryDao(RepertoryDao repertoryDao) {
		this.repertoryDao = repertoryDao;
	}
	
	
	
	//查询仓库信息
	public List<Good> findrepertoryall(){
		
		System.out.println("Servoice ......");
		List<Good> findrepertoryall = repertoryDao.findrepertoryall();
		System.out.println("Servers.....");
		return findrepertoryall;
	}
	//查询是否存在 订单编号
	public List<OrderDetail> selectorder2(String ordernumberr) {
		// TODO Auto-generated method stub
		return (List<OrderDetail>) repertoryDao.selectorder2(ordernumberr);
		
	}
//往仓库中加入 商品 入库
	public void increasedate2(Repertory repertory) {
		// TODO Auto-generated method stub
		System.out.println("service.....");
		repertoryDao.increasedate2(repertory);
	}

	
	
	public List<Repertory> repertoryall2() {
		// TODO Auto-generated method stub
		
		
		return repertoryDao.repertoryall2();
	}
	
	
	
	
//
	/*
	 * public List<Repertory> mohuselectService(String begintime, String endtime) {
	 * // TODO Auto-generated method stub
	 * 
	 * List<Repertory> mohuselect=repertoryDao.mohuselectDao(begintime,endtime);
	 * 
	 * return mohuselect; }
	 */

	public void insertrepertory(Repertory repertory) {
		// TODO Auto-generated method stub
		repertoryDao.insertrepertory(repertory);
	}

	
	/**
	 * 上架商品
	 * @return
	 * @throws IOException 
	 */
	public void onshowGoods(Repertory repertory,Integer num) throws IOException {
		
		repertoryDao.onshowGoods(repertory,num);
	}
	
	/**
	 * 下架商品
	 * @return
	 */
	public Integer outshowGoods( Integer id, Integer num) {
		// TODO Auto-generated method stub
		Integer outshowGoods = repertoryDao.outshowGoods(id,num);
		
		return outshowGoods;
	}
	
	public List<Repertory> mohuselectService(String begintime2, String endtime2) {
		// TODO Auto-generated method stub
		
		 List<Repertory>  mohuselect=repertoryDao.mohuselectDao(begintime2,endtime2);
		
		return mohuselect;
	}

	

	
	
	public PageBean LsitPage(Integer currentPage) {
		
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		//总记录数
		
		int totalCount=repertoryDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		
		//每页显示的记录数
		int pagesize=6;
		pageBean.setPageSize(pagesize);
		//总数页
		//总页数=总记录数%每页显示记录数
		int totalPage=0;
		if(totalCount%pagesize==0) {
			totalPage=totalCount/pagesize;
		}else {
			totalPage=totalCount/pagesize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置      数据第几开始
		int begin=(currentPage-1)*pagesize;
		pageBean.setBegin(begin);
		
		List<Repertory>   list=repertoryDao.findPage(begin,pagesize);
		pageBean.setList(list);
		
		return pageBean;
	}

	
	public Repertory findRepertoryById(Integer rid) {
		// TODO Auto-generated method stub
		return repertoryDao.findRepertoryById(rid);
		
	}

	/**
	 * 修改库存表库存数量
	 * @param rid
	 * @param count
	 */
	public Integer udpateRepertorysNum(Integer rid, Integer count) {
		// TODO Auto-generated method stub
		return repertoryDao.udpateRepertorysNum(rid,count);
	}
	
}
