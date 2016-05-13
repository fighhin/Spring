package com.somnus.transaction;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.transaction.UserServiceImpl;

public class SpringTest extends AbstractTestSupport {
	/******************************REQUIRED**************************************/
	@Test
	public void save12(){
		UserServiceImpl service = (UserServiceImpl)ApplicationContextHolder.getBean(UserServiceImpl.class);
		System.out.println(service.getClass());
		service.b12();
	}
	/**************************REQUIRES_NEW******************************************/
	@Test
	public void save22(){
		UserServiceImpl service = (UserServiceImpl)ApplicationContextHolder.getBean(UserServiceImpl.class);
		System.out.println(service.getClass());
		service.b22();
	}
	/**************************NESTED******************************************/
	@Test
	public void save32(){
		UserServiceImpl service = (UserServiceImpl)ApplicationContextHolder.getBean(UserServiceImpl.class);
		System.out.println(service.getClass());
		service.b32();
	}
	/**************************SUPPORTS******************************************/
	@Test
	public void save42(){
		UserServiceImpl service = (UserServiceImpl)ApplicationContextHolder.getBean(UserServiceImpl.class);
		System.out.println(service.getClass());
		service.b42();
	}
}
