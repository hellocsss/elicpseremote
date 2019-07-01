package com.itcast.Dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import com.itcast.entity.Factory;
import com.itcast.entity.FactoryEmail;
import com.itcast.entity.FactoryPageCondition;
import com.itcast.entity.Indent;
import com.itcast.entity.OrderDetail;
import com.itcast.entity.Orders;
import com.itcast.utils.Page;

public interface FactoryDao {

//分页查询
public List<Factory> factoryall(int result, int limit);
//查询总数
public int count();
//删除数据 根据id
public void delect(Factory factory);
//通过ID查询
public Factory shopping(Integer fid);
/**
 * @author zby
 */
public List<Factory> getFactoryList(FactoryPageCondition factoryPageCondition,Page page);
/**
 * @author zby
 * @param factoryid
 */
public void deleteFactory(Integer factoryid);
/**
 * @author zby
 * @param factory
 */
public void updateFactory(Factory factory);
/**
 * 添加药厂
 * @param factory
 * @throws DataIntegrityViolationException
 */
public void addFactory(Factory factory)throws DataIntegrityViolationException;
/**
 * 获取药厂首页当天订单信息
 * @return
 */
public List<Orders> getFactoryIndex_indent();
public int findTotalCount(FactoryPageCondition factoryPageCondition);





//订单信息
public void addorders(Orders orders);
//添加订单详情
public void addOrderDetail(OrderDetail orderDetail);


public Factory select(int num);

public void updatenum(Factory factory);
public List<FactoryEmail> getFactoryEmail();
public List<FactoryEmail> showAllNotification();
public List<FactoryEmail> showYesterday();
public List<FactoryEmail> showOld();
public void updateRead(int parseInt);
public Integer upIsReadNum();


}