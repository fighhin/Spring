package com.somnus.annotation.dao.impl;

import org.springframework.stereotype.Component;
import com.somnus.annotation.dao.UserDao;

@Component
public class UserDaoImpl implements UserDao {

	public void save() 
	{
		System.out.println("user saved!");
	}
	

}
