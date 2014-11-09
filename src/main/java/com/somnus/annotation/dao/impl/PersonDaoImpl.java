package com.somnus.annotation.dao.impl;

import org.springframework.stereotype.Component;
import com.somnus.annotation.dao.PersonDao;

@Component
public class PersonDaoImpl implements PersonDao {

	public void save() 
	{
		System.out.println("person saved!");
	}

}
