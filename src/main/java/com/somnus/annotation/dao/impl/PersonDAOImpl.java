package com.somnus.annotation.dao.impl;

import org.springframework.stereotype.Component;
import com.somnus.annotation.dao.DAO;

@Component("personDaoImpl") 
public class PersonDAOImpl implements DAO {

	public void save() 
	{
		System.out.println("person saved!");
	}

}
