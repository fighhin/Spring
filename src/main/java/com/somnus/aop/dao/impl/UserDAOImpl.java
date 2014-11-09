package com.somnus.aop.dao.impl;

import org.springframework.stereotype.Component;
import com.somnus.aop.dao.UserDAO;
import com.somnus.aop.model.User;

@Component
public class UserDAOImpl implements UserDAO {

	public void save(User user) {
		//Hibernate
		//JDBC
		//XML
		//NetWork
		System.out.println("user saved!");
		//throw new RuntimeException("exeption!");
	}

}
