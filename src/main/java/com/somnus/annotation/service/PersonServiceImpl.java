package com.somnus.annotation.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.somnus.annotation.dao.PeopleDao;

@Component
public class PersonServiceImpl
{
	@Resource
	private PeopleDao personDAO;

	public void add()
	{
		personDAO.save();
	}


}
