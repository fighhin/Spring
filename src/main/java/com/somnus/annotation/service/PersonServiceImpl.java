package com.somnus.annotation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.somnus.annotation.dao.PersonDao;

@Component
public class PersonServiceImpl
{
	@Autowired
	private PersonDao personDAO;

	public void add()
	{
		personDAO.save();
	}


}
