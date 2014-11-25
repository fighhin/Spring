package com.somnus.annotation.dao.impl;

import org.springframework.stereotype.Repository;
import com.somnus.annotation.dao.PersonDao;

@Repository
public class PersonDaoImpl implements PersonDao {

	public void save() 
	{
		System.out.println("person saved!");
	}

}
