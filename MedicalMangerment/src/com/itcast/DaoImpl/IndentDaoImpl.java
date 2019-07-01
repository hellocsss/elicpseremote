package com.itcast.DaoImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.Dao.IndentDao;
import com.itcast.entity.Indent;
import com.itcast.entity.User;

public class IndentDaoImpl implements IndentDao {

	//在Dao中注入hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

		//生成订单
		@Override
		public void addIndent(Indent indent) {
			hibernateTemplate.save(indent);
		}

		//查询所有订单
		@Override
		public List<Indent> findList() {
			List<Indent> indentList = (List<Indent>) hibernateTemplate.find("from Indent i inner join fetch i.user order by iid desc");
			System.out.println(indentList);
			return indentList;
		}

		//通过手机号码查询其所有的订单
		@Override
		public List<Indent> SearchIndent(Integer uid) {
			System.out.println("进来了吗？SearchIndent");
			List<Indent> IndentList = (List<Indent>) hibernateTemplate.find("from Indent where uid=?",uid );
			
			System.out.println(IndentList);
			return IndentList;
		}

		//查询总记录数
		@Override
		public int findCount() {
			List<Object> total = (List<Object>) hibernateTemplate.find("select count(*) from Indent");
			if(total.size()>0) {
				int totalCount =((Long)total.get(0)).intValue();
				System.out.println(totalCount);
				return totalCount;
			}
			return 0;
		}

		//分页查询数据
		@Override
		public List<Indent> findPage(int begin, int pageSize) {
			//创建离线对象 对实体类进行操作
			DetachedCriteria criteria = DetachedCriteria.forClass(Indent.class);
			criteria.addOrder(Order.desc("iid"));
			List<Indent> list = (List<Indent>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
			System.out.println(list);
			return list;
		}

		//手机号查询总记录数
		@Override
		public int findIndentCount(User user) {
			int uid =user.getUid();
			List<Object> total = (List<Object>) hibernateTemplate.find("select count(*) from Indent where uid =?", uid);
			if(total.size()>0) {
				int totalCount =((Long)total.get(0)).intValue();
				System.out.println(totalCount);
				return totalCount;
			}
			return 0;
		}

		//手机号分页查询数据
		@Override
		public List<Indent> findIndentPage(int begin, int pageSize, User user) {
			//创建离线对象 对实体类进行操作
			DetachedCriteria criteria = DetachedCriteria.forClass(Indent.class);
			System.out.println("~"+user);
			System.out.println("~~"+user);
			criteria.addOrder(Order.desc("iid"));
			criteria.add(Restrictions.eq("user",user));
			List<Indent> list = (List<Indent>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
			System.out.println(list);
			return list;
		}
}
