package com.somnus.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.somnus.annotation.service.PeopleService;
import com.somnus.annotation.service.PersonService;
import com.somnus.annotation.service.UserService;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/somnus/annotation/beans.xml");
		
		UserService service = (UserService)ctx.getBean("userService");
		service.add();
		
		PeopleService people = (PeopleService)ctx.getBean("peopleService");
		people.add();
		
		PersonService person = (PersonService)ctx.getBean("personService");
		person.add();
		
		ctx.destroy();
	
	}

}
