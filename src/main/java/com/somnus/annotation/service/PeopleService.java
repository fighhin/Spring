package com.somnus.annotation.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import com.somnus.annotation.dao.DAO;

@Scope("prototype")
public class PeopleService
{
	private DAO peopleDAO;

	public void add()
	{
		peopleDAO.save();
	}

	@Resource(name = "peopleDaoImpl")
	public void setPersonDAO(DAO peopleDAO)
	{
		this.peopleDAO = peopleDAO;
	}

}
