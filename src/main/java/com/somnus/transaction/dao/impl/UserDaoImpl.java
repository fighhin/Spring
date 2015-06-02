package com.somnus.transaction.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.somnus.transaction.dao.UserDao;
import com.somnus.transaction.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	public void save(User user) {
	    Session s = sessionFactory.getCurrentSession();
	    s.save(user);
	}

}
