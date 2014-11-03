package com.somnus.transaction.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import com.somnus.transaction.dao.LogDAO;
import com.somnus.transaction.model.Log;

@Component("logDAO") 
public class LogDAOImpl implements LogDAO {

	private SessionFactory sessionFactory;

	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Log log) {
		
		Session s = sessionFactory.getCurrentSession();
		s.save(log);
//		throw new RuntimeException("error!");
	}

}
