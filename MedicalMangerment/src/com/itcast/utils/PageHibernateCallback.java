package com.itcast.utils;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

/**
 * 实现数据库分页查询工具
 * 参考网址：https://www.cnblogs.com/fingerboy/p/5313725.html
 * @author zby
 *
 * @param <T>
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
    
    private String hql;
    private Object[] params;
    private int startIndex;
    private int pageSize;
    

    public PageHibernateCallback(String hql, Object[] params,
            int startIndex, int pageSize) {
        super();
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }



    public List<T> doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(hql);
        
        if(params != null){
            for(int i = 0 ; i < params.length ; i ++){
                query.setParameter(i, params[i]);
            }
        }
        
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        
        return query.list();
    }

}
