package com.somnus.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/somnus/constructor/beans.xml");
	
		Employee ee=(Employee) ac.getBean("employee");
		System.out.println(ee.name);
	
	}

}
