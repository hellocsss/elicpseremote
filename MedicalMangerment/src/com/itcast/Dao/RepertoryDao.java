package com.itcast.Dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.jpa.criteria.OrderImpl;

import com.itcast.entity.Good;
import com.itcast.entity.OrderDetail;
import com.itcast.entity.Repertory;




public interface RepertoryDao {
//  查询 仓库所有信息
	public List<Good> findrepertoryall();
	//查询是否存在 订单编号
	public List<OrderDetail> selectorder2(String ordernumberr);
	//往仓库中加入数据
	public void increasedate2(Repertory repertory);
	public List<Repertory> repertoryall2();
	
	
	//public List<Repertory>  mohuselectDao(String begintime, String endtime);
	
	public void insertrepertory(Repertory repertory);
	
	/**
	 * 上架商品
	 * @return
	 * @throws IOException 
	 */
	public void onshowGoods(Repertory repertory,Integer num) throws IOException;
	
	/**
	 * 下架商品
	 * @return
	 */
	public Integer outshowGoods(Integer id,Integer num);
	
	
public List<Repertory>  mohuselectDao(String begintime2, String endtime2);
	
	
	//总记录数
	public int findCount();
	//根据 2个数据 来按 数据查询         开始到结束值
	public List<Repertory> findPage(int begin, int pagesize);
	
	
public Repertory findRepertoryById(Integer rid);
	
	/**
	 * 修改库存表库存数量
	 * @param rid
	 * @param count
	 * @return 
	 */
	public Integer udpateRepertorysNum(Integer rid, Integer count);
}
