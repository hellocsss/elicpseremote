package com.itcast.DaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.FactoryDao;
import com.itcast.entity.Email;
import com.itcast.entity.Factory;
import com.itcast.entity.FactoryEmail;
import com.itcast.entity.FactoryPageCondition;
import com.itcast.entity.Good;
import com.itcast.entity.Indent;
import com.itcast.entity.OrderDetail;
import com.itcast.entity.Orders;
import com.itcast.entity.Repertory;
import com.itcast.utils.Page;
import com.itcast.utils.PageHibernateCallback;

public class FactoryImpl  implements FactoryDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	//分页查询
	@Override
	public List<Factory> factoryall(int result, int limit) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//创建离线对象 对实体类进行操作
				System.out.println("进入分页查询");
				DetachedCriteria criteria=DetachedCriteria.forClass(Factory.class);
				List<Factory> 	list=(List<Factory>) hibernateTemplate.findByCriteria(criteria,result,limit);
				System.out.println(list);
				System.out.println("进入查询分页查询");
				return list;
	}
//查询总数
	@Override
	public int count() {
		// TODO Auto-generated method stub
		System.out.println("进入总数查询");
		List<Object> list=(List<Object>) hibernateTemplate.find("select count(*) from Factory ");
		//从list中得到数据
	
		if(list!=null&&list.size()>0) {
			Object object = list.get(0);
			Long obj=(long)object;
			int count=obj.intValue();
			
			System.out.println("进出总数查询count="+count);
				return count;

		}
		return 0;
	}
//删除
@Override
public void delect(Factory factory) {
	// TODO Auto-generated method stub
	hibernateTemplate.delete(factory);
}
/**
 * 删除商品方法
 */
@Override
public void deleteFactory(Integer fid) {
	
	Factory factory = hibernateTemplate.get(Factory.class, fid);
	//hibernateTemplate删除方法
	hibernateTemplate.delete(factory);
}


//在购物车通过iD查找 商品
@Override
public Factory shopping(Integer fid) {
	// TODO Auto-generated method stub
	Factory factory=hibernateTemplate.get(Factory.class,fid);
	return  factory;
}
//查询Factory表中总记录数
public int findTotalCount(FactoryPageCondition factoryPageCondition) {
    String hql="select count(*) from Factory where 1=1";
    if(factoryPageCondition.getFname()!=null && factoryPageCondition.getFname()!=""){
    	hql+="and fname like "+"'%"+factoryPageCondition.getFname()+"%'";
	}
	if(factoryPageCondition.getFgongying()!=null && factoryPageCondition.getFgongying()!=""){
		hql+="and fgongying like "+"'%"+factoryPageCondition.getFgongying()+"%'";
	}
	if(factoryPageCondition.getFchufang()!=null && factoryPageCondition.getFchufang()!=""){
		hql+="and fchufang like "+"'%"+factoryPageCondition.getFchufang()+"%'";
	}
    List<Long> list=(List<Long>)this.getHibernateTemplate().find(hql);
    if(list!=null&&list.size()>0){
        return list.get(0).intValue();
    }
    return 0;
}
//获取商品列表
@Override
public List<Factory> getFactoryList(FactoryPageCondition factoryPageCondition,Page page) {
	// TODO Auto-generated method stub
	String sql="from Factory where 1=1";
	if(factoryPageCondition.getFname()!=null && factoryPageCondition.getFname()!=""){
		sql+="and fname like "+"'%"+factoryPageCondition.getFname()+"%'";
	}
	if(factoryPageCondition.getFgongying()!=null && factoryPageCondition.getFgongying()!=""){
		sql+="and fgongying like "+"'%"+factoryPageCondition.getFgongying()+"%'";
	}
	if(factoryPageCondition.getFchufang()!=null && factoryPageCondition.getFchufang()!=""){
		sql+="and fchufang like "+"'%"+factoryPageCondition.getFchufang()+"%'";
	}
	System.out.println(page.getShowCount()+"1111111111111111111111111111111111111111111111111111");
	List<Factory> factoryList = (List<Factory>) hibernateTemplate.execute((HibernateCallback<Factory>) new PageHibernateCallback(sql, new Object[]{}, page.getCurrentResult(), page.getShowCount()));
	
	return factoryList;
}
/**
 * 更新
 * @author zby
 */
@Override
public void updateFactory(Factory factory) {
	// TODO Auto-generated method stub
	hibernateTemplate.update(factory);
}

/**
 * 添加药品
 * @author zby
 */
@Override
public void addFactory(Factory factory) throws DataIntegrityViolationException{
	// TODO Auto-generated method stub
	hibernateTemplate.save(factory);
}

@Override
public List<Orders> getFactoryIndex_indent() {
	List<Orders> orderList = (List<Orders>) hibernateTemplate.find("from Orders where orderDate like CONCAT(curdate(),'%')");
	return orderList;
}
@Override
public void addorders(Orders orders) {
	// TODO Auto-generated method stub
	hibernateTemplate.save(orders);
}

@Override
public void addOrderDetail(OrderDetail orderDetail) {
	// TODO Auto-generated method stub
	hibernateTemplate.save(orderDetail);
}

@Override
public Factory select(int num) {
	// TODO Auto-generated method stub
	Factory fac=hibernateTemplate.get(Factory.class , num);
	
	
	return fac;
}



@Override
public void updatenum(Factory factory) {
	// TODO Auto-generated method stub
	hibernateTemplate.saveOrUpdate(factory);
	
}
/**
 * 获取药店通知
 * @return 
 */
@Override
public List<FactoryEmail> getFactoryEmail() {
	// TODO Auto-generated method stub
	List<FactoryEmail> factoryEmailList = (List<FactoryEmail>) hibernateTemplate.find("from FactoryEmail where Date like CONCAT(curdate(),'%') order by Date,feid desc");
	return factoryEmailList;
}

@Override
public List<FactoryEmail> showAllNotification() {
	// TODO Auto-generated method stub
	List<FactoryEmail> factoryEmailList = (List<FactoryEmail>) hibernateTemplate.find("from FactoryEmail where Date like CONCAT(curdate(),'%') order by Date,feid desc");
	return factoryEmailList;
}

@Override
public List<FactoryEmail> showYesterday() {
	// TODO Auto-generated method stub
	/**
	 * 得到昨天的日期
	 */
	String yesterdayString;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date yesterday = new Date();
	yesterdayString = sdf.format(yesterday.getTime()-1*24*60*60*1000);
	
	List<FactoryEmail> factoryEmailList = (List<FactoryEmail>) hibernateTemplate.find("from FactoryEmail where Date = ? order by Date,feid desc",yesterdayString);
	return factoryEmailList;
}

@Override
public List<FactoryEmail> showOld() {
	// TODO Auto-generated method stub
	/**
	 * 得到昨天的日期
	 */
	String yesterdayString;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date yesterday = new Date();
	yesterdayString = sdf.format(yesterday.getTime()-1*24*60*60*1000);
	List<FactoryEmail> factoryEmailList = (List<FactoryEmail>) hibernateTemplate.find("from FactoryEmail where Date < ? order by Date,feid desc",yesterdayString);
	return factoryEmailList;
}

@Override
public void updateRead(int parseInt) {
	// TODO Auto-generated method stub
	FactoryEmail findemail = hibernateTemplate.get(FactoryEmail.class, parseInt);
	findemail.setIsread("已读");
	hibernateTemplate.update(findemail);
}

@Override
public Integer upIsReadNum() {
	// TODO Auto-generated method stub
	List<FactoryEmail> unRead = (List<FactoryEmail>) hibernateTemplate.find("from FactoryEmail where isread = '未读' ");
	
	//如果未读数量大于0
	if(unRead.size()>0) {
		return unRead.size();
	}
	
	return 0;
}


	
	
	
}
