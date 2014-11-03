package com.somnus.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.somnus.aop.model.User;
import com.somnus.aop.service.UserServiceImpl;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/somnus/aop/beans.xml");
		//拿到的是代理对象
		UserServiceImpl service = (UserServiceImpl)ac.getBean("userService");
		System.out.println(service.getClass());
		service.add(new User());
		
	}

}
