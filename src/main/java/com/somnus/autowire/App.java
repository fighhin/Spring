package com.somnus.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/somnus/autowire/beans.xml");
		//获取
		Master master=(Master) ac.getBean("master");
		System.out.println(master.getName()+" 养 "+master.getDog().getAge()+"岁的"+master.getDog().getName());
	}

}
