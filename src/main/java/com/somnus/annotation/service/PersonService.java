package com.somnus.annotation.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.somnus.annotation.dao.DAO;

@Component("personService")
public class PersonService
{

	private DAO personDAO;

	public void add()
	{
		personDAO.save();
	}

	@Resource(name = "personDaoImpl")
	public void setPersonDAO(DAO personDAO)
	{
		this.personDAO = personDAO;
	}

}
