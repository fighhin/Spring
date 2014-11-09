package com.somnus.transaction.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import com.somnus.transaction.dao.UserDao;
import com.somnus.transaction.model.User;

@Component
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	public void save(User user) {
			Session s = sessionFactory.getCurrentSession();
			s.save(user);
			throw new RuntimeException("exeption!");
	}

}
