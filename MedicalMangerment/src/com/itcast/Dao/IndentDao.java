package com.itcast.Dao;

import java.text.SimpleDateFormat;
import java.util.List;

import com.itcast.entity.Indent;
import com.itcast.entity.User;

public interface IndentDao {

	//生成订单
	void addIndent(Indent indent);

	//查询所有的订单
	List<Indent> findList();

	//通过手机号码查询其所有的订单
	List<Indent> SearchIndent(Integer uid);

	//查询总记录数
	int findCount();

	//分页查询数据
	List<Indent> findPage(int begin, int pageSize);

	
	//手机号查询总记录数
	int findIndentCount(User user);

	//手机号分页查询数据
	List<Indent> findIndentPage(int begin, int pageSize, User user);

}
