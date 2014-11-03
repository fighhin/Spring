package com.somnus.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import com.somnus.annotation.dao.DAO;


@Scope("prototype")
public class UserService
{

	private DAO userDAO;

	public void add()
	{
		userDAO.save();
	}

	@Autowired
	public void setUserDAO(@Qualifier("userDAOImpl") DAO userDAO)
	{
		this.userDAO = userDAO;
	}

}
