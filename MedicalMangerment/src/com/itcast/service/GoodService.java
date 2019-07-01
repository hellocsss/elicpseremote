package com.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.GoodDao;
import com.itcast.entity.Good;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;
import com.itcast.utils.PageBeanPublic;

//事务的注解记得一定不要忘了加！
@Transactional
public class GoodService {
	
	
	private GoodDao goodDao;

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}
	
	/**
	 * 查询显示所有商品
	 */
	public List<Good> findAllGoods() {
		System.out.println("GoodService....");
		return goodDao.findAllGoods();
	}
	
	/**
	 * 增加商品
	 */
	public void goodsAdd(Good good,Type type,Supplier supplier) {
		// TODO Auto-generated method stub
		goodDao.goodsAdd(good,type,supplier);
	}
	
	
	/**
	 * 修改商品信息
	 * @param good
	 */
	public void updateGoods(Integer gid,Double gprice) {
		// TODO Auto-generated method stub
		goodDao.updateGoods(gid,gprice);
	}
	
	/**
	 * 删除商品信息
	 * @param good
	 */
	
	public void deleteGoods(Integer id) {
		goodDao.deleteGoods(id);
	}
	
	
	/**
	 * 模糊查找商品
	 * @return
	 */
	public List<Good> findSomeGood(String goodsname) {
		List<Good> SomeGoodlist = goodDao.findSomeGood(goodsname);
		
		return SomeGoodlist;
	}
	/**
	 * 根据id查询商品（ypf+）
	 * @param gid
	 * @return 
	 */
	public Good findById(Integer gid) {
		return goodDao.findById(gid);
		
	}
	
	/**
	 * 分页
	 */
	public List<Good> pagingGoods(Integer pageNum, Integer pagecount) {
		
		List<Good> pagingGoods = goodDao.pagingGoods(pageNum, pagecount);
		
		return pagingGoods;
	}

	/**
	 * 前台结算分页查询方法
	 * @param currentPage
	 * @return
	 */
	public PageBeanPublic ListPage(Integer currentPage) {
		PageBeanPublic pageBeanPublic =new PageBeanPublic();
		
		//设置当前页
		pageBeanPublic.setCurrentPage(currentPage);
		
		//设置总记录数
		int total =goodDao.findCount();
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
		
		List<Good> list=goodDao.findPage(begin,pageSize);
		pageBeanPublic.setList(list);
		return pageBeanPublic;
	}
	
	//加入购物车后库存减少
	public void update(Good good) {
		System.out.println("~~"+good.getStock());
		goodDao.update(good);
	}

	//查询分页
	public PageBeanPublic findSomeGoodPage(Integer currentPage, String gname) {
		PageBeanPublic pageBeanPublic =new PageBeanPublic();
		
		//设置当前页
		pageBeanPublic.setCurrentPage(currentPage);
		
		//设置总记录数
		int total =goodDao.findGoodCount(gname);
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
		
		List<Good> list=goodDao.findGoodPage(begin,pageSize,gname);
		pageBeanPublic.setList(list);
		return pageBeanPublic;
	}
	
	public List<Good> findByName(String name) {
		  // TODO Auto-generated method stub
		  return goodDao.findByName(name);
		  
		 }

		 
		 public void udpateGoodsNum(Integer id,Integer count) {
		  // TODO Auto-generated method stub
		  goodDao.udpateGoodsNum(id,count);
		  
		 }

		 public void addNewGoods(Good good) {
		  // TODO Auto-generated method stub
		  goodDao.addNewGoods(good);
		 }
	
}
