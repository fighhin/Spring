package com.somnus.factory;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.factory.BeanFactory.User;
import com.somnus.factory.BeanFactory2.Info;

public class SpringTest extends AbstractTestSupport {
	@Test
	public void load(){
		User user = (User)ApplicationContextHolder.getBean("user");
		System.out.println(user);
		User user2 = (User)ApplicationContextHolder.getBean("user");
		System.out.println(user2);
	}
	
	@Test
	public void load2(){
		Info user = (Info)ApplicationContextHolder.getBean("info");
		System.out.println(user);
	}
}
