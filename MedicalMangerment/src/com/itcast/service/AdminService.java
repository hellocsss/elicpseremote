package com.itcast.service;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.AdminDao;
import com.itcast.entity.Admin;
import com.itcast.entity.FactoryManager;

//事务的注解记得一定不要忘了加！
@Transactional
public class AdminService {

	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	//判断经理登录
	public Admin findAdmin(Admin admin) {
		return adminDao.findAdmin(admin);
	}
	
	public FactoryManager factoryManager(FactoryManager fm) {
		// TODO Auto-generated method stub
		return adminDao.factoryManager(fm);
		
		
	}
}
