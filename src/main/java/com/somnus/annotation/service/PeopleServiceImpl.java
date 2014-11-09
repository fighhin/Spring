package com.somnus.annotation.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.somnus.annotation.dao.PeopleDao;

@Component
public class PeopleServiceImpl
{
	@Resource
	private PeopleDao peopleDAO;

	public void add()
	{
		peopleDAO.save();
	}

}
