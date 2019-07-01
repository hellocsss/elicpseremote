package com.itcast.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.FactoryDao;
import com.itcast.entity.Email;
import com.itcast.entity.Factory;
import com.itcast.entity.FactoryEmail;
import com.itcast.entity.FactoryPageCondition;
import com.itcast.entity.Good;
import com.itcast.entity.Indent;
import com.itcast.entity.OrderDetail;
import com.itcast.entity.Orders;
import com.itcast.utils.Page;
//事务的注解记得一定不要忘了加！
@Transactional
public class FactoryService {
private FactoryDao factoryDao;

public FactoryDao getFactoryDao() {
	return factoryDao;
}

public void setFactoryDao(FactoryDao factoryDao) {
	this.factoryDao = factoryDao;
}
/**
 * 查询显示所有商品
 * @author zby
 */
public List<Factory> getFactoryList(FactoryPageCondition factoryPageCondition,Page page) {
	System.out.println("FactoryService....");
	return factoryDao.getFactoryList(factoryPageCondition,page);
}
//分页
public List<Factory> factoryall(int result, int limit) {
	// TODO Auto-generated method stub
	//List<Factory> ss=factoryDao.factoryall(result,limit);
	return factoryDao.factoryall(result,limit);
}
//查询药厂list总数
public int count() {
	// TODO Auto-generated method stub
	return factoryDao.count();
}
//删除数据
public void delect(Factory factory) {
	// TODO Auto-generated method stub
	factoryDao.delect(factory);
}

/**
 * 删除商品方法
 * @author zby
 */
public void deleteFactory(Integer fid) {
	
	factoryDao.deleteFactory(fid);
}

//通过ID查询 
public Factory shopping(Integer fid) {
	// TODO Auto-generated method stub
	return factoryDao.shopping(fid);
}

/**
 * 更新药厂数据
 * @author zby
 * @param factory
 */
public void updateFactory(Factory factory) {
	// TODO Auto-generated method stub
	factoryDao.updateFactory(factory);
	
}

/**
 * 添加药品信息
 * @author zby
 * @param factory
 * @throws DataIntegrityViolationException
 */
public void addFactory(Factory factory)throws DataIntegrityViolationException {
	// TODO Auto-generated method stub
	factoryDao.addFactory(factory);
	
}

/**
 * 获取药店通知
 */

public List<FactoryEmail> getFactoryEmail() {
		// TODO Auto-generated method stub
		return factoryDao.getFactoryEmail();
		
	}



/**
 * 更新最新一条数据
 * @author zby
 */

public List<Orders> getFactoryIndex_indent() {
	// TODO Auto-generated method stub
	return factoryDao.getFactoryIndex_indent();
}

public int findTotalCount(FactoryPageCondition factoryPageCondition) {
	return factoryDao.findTotalCount(factoryPageCondition);
}

public void addorders(Orders orders) {
	
	// TODO Auto-generated method stub
	factoryDao.addorders(orders);
}

public void addOrderDetail(OrderDetail orderDetail) {
	// TODO Auto-generated method stub
	factoryDao.addOrderDetail(orderDetail);
}

public Factory select(int num) {
	// TODO Auto-generated method stub
	return factoryDao.select(num);
}

public void updatenum(Factory factory) {
	
	// TODO Auto-generated method stub
	factoryDao.updatenum(factory);
	
}

public List<FactoryEmail> showAllNotification() {
	// TODO Auto-generated method stub
	return factoryDao.showAllNotification();
}

public List<FactoryEmail> showYesterday() {
	// TODO Auto-generated method stub
	return factoryDao.showYesterday();
}

public List<FactoryEmail> showOld() {
	// TODO Auto-generated method stub
	return factoryDao.showOld();
}

public void updateRead(int parseInt) {
	// TODO Auto-generated method stub
	factoryDao.updateRead(parseInt);
}

public Integer upIsReadNum() {
	// TODO Auto-generated method stub
	return factoryDao.upIsReadNum();
}


	
}
