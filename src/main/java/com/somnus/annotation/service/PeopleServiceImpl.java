package com.somnus.annotation.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.somnus.annotation.dao.PeopleDao;

@Service
public class PeopleServiceImpl
{
	@Resource
	private PeopleDao peopleDAO;

	public void add()
	{
		peopleDAO.save();
	}

}
