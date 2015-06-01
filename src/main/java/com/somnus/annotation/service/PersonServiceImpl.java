package com.somnus.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somnus.annotation.dao.PersonDao;

@Service
public class PersonServiceImpl{
	@Autowired
	private PersonDao personDAO;

	public void add(String dialogue){
		personDAO.save(dialogue);
	}

}
