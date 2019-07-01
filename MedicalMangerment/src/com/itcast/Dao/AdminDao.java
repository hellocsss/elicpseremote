package com.itcast.Dao;

import com.itcast.entity.Admin;
import com.itcast.entity.FactoryManager;

public interface AdminDao {


	Admin findAdmin(Admin admin);
	FactoryManager factoryManager(FactoryManager fm);
}
