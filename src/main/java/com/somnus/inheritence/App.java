package com.somnus.inheritence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/somnus/inheritence/beans.xml");
	
		Dog dog = (Dog) ac.getBean("dog");
		System.out.println(dog.getType()+"  "+dog.getName());
	}

}
