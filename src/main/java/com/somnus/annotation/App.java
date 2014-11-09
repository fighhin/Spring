package com.somnus.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.somnus.annotation.service.PeopleServiceImpl;
import com.somnus.annotation.service.PersonServiceImpl;
import com.somnus.annotation.service.UserServiceImpl;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/somnus/annotation/beans.xml");
		
		UserServiceImpl service = (UserServiceImpl)ctx.getBean("userServiceImpl");
		service.add();
		
		PeopleServiceImpl people = (PeopleServiceImpl)ctx.getBean("peopleServiceImpl");
		people.add();
		
		PersonServiceImpl person = (PersonServiceImpl)ctx.getBean("personServiceImpl");
		person.add();
		
		ctx.destroy();
	
	}

}
