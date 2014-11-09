package com.somnus.annotation.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.somnus.annotation.dao.PeopleDao;

@Component
public class UserServiceImpl
{
	@Resource
	private PeopleDao userDAO;

	public void add()
	{
		userDAO.save();
	}

}
