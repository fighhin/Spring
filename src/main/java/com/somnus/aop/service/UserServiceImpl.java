package com.somnus.aop.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.somnus.aop.dao.UserDAO;
import com.somnus.aop.model.User;

@Component("userService")
public class UserServiceImpl {
	
	private UserDAO userDAO;  
	
	public void init() {
		System.out.println("init");
	}
	
	public void add(User user) 
	{
		userDAO.save(user);
	}

	
	@Resource(name="u")
	public void setUserDAO( UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	

	
	public void destroy() {
		System.out.println("destroy");
	}
}
