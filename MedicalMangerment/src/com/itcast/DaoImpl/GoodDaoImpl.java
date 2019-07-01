package com.itcast.DaoImpl;

import java.io.Serializable;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.itcast.Dao.GoodDao;
import com.itcast.entity.Good;
import com.itcast.entity.Repertory;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;
import com.itcast.service.GoodService;

public class GoodDaoImpl implements GoodDao {

	//在Dao中注入hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
	/**
	 * 查找所有药品列表
	 * @author 
	 * @return
	 */	
	@Override
	public List<Good> findAllGoods(){
		
		System.out.println("查找所有药品列表....");
		
		List<Good> goodlist = (List<Good>) hibernateTemplate.find("from Good");
		
		
		return goodlist;
	}
	
	
	
	/**
	 * 增加药品
	 */
	@Override
	public void goodsAdd(Good good,Type type,Supplier supplier) {

		System.out.println("添加impl...");
		
		hibernateTemplate.saveOrUpdate(type);
		hibernateTemplate.saveOrUpdate(supplier);
		hibernateTemplate.saveOrUpdate(good);
		
		
	}
	/**
	 * 更新药品信息
	 */
	@Override
	public void updateGoods(Integer id,Double price) {
		//查询出要修改的药品
//		hibernateTemplate.update(good);
//		
		Good good2 = hibernateTemplate.get(Good.class, id);
		good2.setPrice(price);
		
		hibernateTemplate.saveOrUpdate(good2);

		System.out.println("更新药品信息impl。。。");

		
	}
	/**
	 * 删除商品方法
	 */
	@Override
	public void deleteGoods(Integer gid) {
		
		Good good = hibernateTemplate.get(Good.class, gid);
		hibernateTemplate.delete(good);
		System.out.println("删除成功！");
	}

	
	
	/**
	 * 模糊查找商品
	 * @return
	 */
	@Override
	public List<Good> findSomeGood(String gname) {
		System.out.println("模糊查找商品Impl....");
		System.out.println(gname);
		List<Good> findgoods = (List<Good>) hibernateTemplate.find("from Good g where g.gname like ?", "%"+gname+"%");
		for (Good good2 : findgoods) {
			System.out.println(good2.getGname());
			System.out.println("找到了");
		}
		
		return findgoods;
	}
	/**
	 * 根据id查询商品（ypf+）
	 */
	@Override
	public Good findById(Integer gid) {
		Good good=hibernateTemplate.get(Good.class, gid);
		return good;
	}
	
	/**
	 * 分页
	 */
	
	@Override
	public List<Good> pagingGoods(Integer pageNum, Integer pagecount) {
		// TODO Auto-generated method stub
		//
		
		Session openSession = hibernateTemplate.getSessionFactory().openSession();
		Query createQuery = openSession.createQuery("from Good");
		
		createQuery.setFirstResult(pageNum);
		createQuery.setMaxResults(pagecount);
		
		System.out.println("分页impl....................................");
		List<Good> list = createQuery.list();
		for (Good good : list) {
			System.out.println(good.getGname());
		}
		
		return list;
	}

	//查询总记录数
	@Override
	public int findCount() {
		List<Object> total = (List<Object>) hibernateTemplate.find("select count(*) from Good");
		if(total.size()>0) {
			int totalCount =((Long)total.get(0)).intValue();
			System.out.println(totalCount);
			return totalCount;
		}
		return 0;
	}

	//分页查询
	@Override
	public List<Good> findPage(int begin, int pageSize) {
		//创建离线对象 对实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Good.class);
		List<Good> list = (List<Good>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
		return list;
	}

	
	//加入购物车后库存减少
	@Override
	public void update(Good good) {

		hibernateTemplate.update(good);
	}

	
	//查询总记录数（前台商品查询）
	@Override
	public int findGoodCount(String gname) {
		List<Object> total = (List<Object>) hibernateTemplate.find("select count(*) from Good  where gname like ?", "%"+gname+"%");
		if(total.size()>0) {
			int totalCount =((Long)total.get(0)).intValue();
			System.out.println(totalCount);
			return totalCount;
		}
		return 0;
	}

	
	//分页查询（前台商品查询）
	@Override
	public List<Good> findGoodPage(int begin, int pageSize,String gname) {
		//创建离线对象 对实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Good.class);
		criteria.add(Restrictions.like("gname","%"+gname+"%"));
		List<Good> list = (List<Good>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
		return list;
	
	}

	/**
	  * 按药品名查询
	  */
	 @Override
	 public List<Good> findByName(String name) {
	  // TODO Auto-generated method stub
	  
	  List<Good> findOfName = (List<Good>) hibernateTemplate.find("from Good where gname = ?", name);
	  
	  return findOfName;
	 }

	 
	 /**
	  * 上架设置库存
	  */
	 @Override
	 public void udpateGoodsNum(Integer id, Integer count) {
	  // TODO Auto-generated method stub
	  Good onegood = hibernateTemplate.get(Good.class, id);
	  
	  Integer newStock = onegood.getStock() + count;
	  onegood.setStock(newStock);
	  
	  
	 }

	 /**
	  * 添加新药品
	  */
	 @Override
	 public void addNewGoods(Good good) {
	  // TODO Auto-generated method stub
	  hibernateTemplate.save(good);
	  
	 }

	@Override
	public void updateGoods(Integer id, String tid, String sid, Good good) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
