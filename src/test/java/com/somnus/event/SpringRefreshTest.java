package com.somnus.event;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringRefreshTest {
	
	@Test
	public void refresh(){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-basic.xml");
		Animal animal = context.getBean(Animal.class);
		System.out.println(animal.speak());
		context.refresh();
		context.close();
	}
}
