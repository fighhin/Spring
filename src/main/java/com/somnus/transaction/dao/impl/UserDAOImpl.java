package com.somnus.transaction.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import com.somnus.aop.dao.UserDAO;
import com.somnus.aop.model.User;

@Component("u") 
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User user) {
		
			Session s = sessionFactory.getCurrentSession();
			
			s.save(user);
			
//		throw new RuntimeException("exeption!");
	}

}
