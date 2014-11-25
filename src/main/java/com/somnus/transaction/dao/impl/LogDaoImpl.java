package com.somnus.transaction.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.somnus.transaction.dao.LogDao;
import com.somnus.transaction.domain.Log;

@Repository
public class LogDaoImpl implements LogDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(Log log) {
		Session s = sessionFactory.getCurrentSession();
		s.save(log);
//		throw new RuntimeException("error!");
	}

}
