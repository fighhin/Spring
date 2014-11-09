package com.somnus.annotation.dao.impl;

import org.springframework.stereotype.Component;

import com.somnus.annotation.dao.PeopleDao;

@Component
public class PeopleDaoImpl implements PeopleDao {

	public void save() 
	{
		System.out.println("people saved!");
	}

}
