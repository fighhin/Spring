package com.somnus.beanlife;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("com/somnus/beanlife/beans.xml");
		
//		BeanFactory factory = new XmlBeanFactory(
//				new ClassPathResource("com/spring/beanlife/beans.xml"));
		
		PersonService ps=(PersonService) ac.getBean("personService");
		
		ac.destroy();
	}

}
