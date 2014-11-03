package com.somnus.transaction.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.somnus.aop.dao.UserDAO;
import com.somnus.aop.model.User;
import com.somnus.transaction.dao.LogDAO;
import com.somnus.transaction.model.Log;

@Component("userServiceImpl")
public class UserServiceImpl {
	
	private UserDAO userDAO;
	private LogDAO logDAO;
	
	public void init() {
		System.out.println("init");
	}
	
	public User getUser(int id) {
		return null;
	}
	
//	@Transactional(readOnly=false)
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(User user) {
		userDAO.save(user);
		Log log = new Log();
		log.setMsg("a user saved!");
		logDAO.save(log);
	}
	
	@Resource(name="u")
	public void setUserDAO( UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Resource(name="logDAO")
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public void destroy() {
		System.out.println("destroy");
	}
}
