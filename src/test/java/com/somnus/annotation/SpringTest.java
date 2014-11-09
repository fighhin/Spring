package com.somnus.annotation;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.annotation.service.PeopleServiceImpl;
import com.somnus.annotation.service.PersonServiceImpl;

public class SpringTest extends AbstractTestSupport {
	@Test
	public void save(){
		PersonServiceImpl person = (PersonServiceImpl)ApplicationContextHolder.getBean(PersonServiceImpl.class);
		person.add();
		PeopleServiceImpl people = (PeopleServiceImpl)ApplicationContextHolder.getBean(PeopleServiceImpl.class);
		people.add();
	}
}
