package com.somnus.transaction.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.transaction.dao.LogDao;
import com.somnus.transaction.dao.UserDao;
import com.somnus.transaction.domain.Log;
import com.somnus.transaction.domain.User;

@Component
public class UserServiceImpl {
	@Resource
	private UserDao userDao;
	@Resource
	private LogDao logDao;
	
	public void init() {
		System.out.println("init");
	}
	
	public User getUser(int id) {
		return null;
	}
	
//	@Transactional(readOnly=false)
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(User user) {
		userDao.save(user);
		Log log = new Log();
		log.setMsg("a user saved!");
		logDao.save(log);
	}

	public void destroy() {
		System.out.println("destroy");
	}
}
