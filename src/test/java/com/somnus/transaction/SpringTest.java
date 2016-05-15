package com.somnus.transaction;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.transaction.UserServiceImpl;

public class SpringTest extends AbstractTestSupport {
	@Test
	public void saveFailure(){
		UserServiceImpl service = ApplicationContextHolder.getBean(UserServiceImpl.class);
		System.out.println(service.getClass());
		service.B();
	}
	@Test
	public void saveSuccess(){
		UserServiceImpl service = ApplicationContextHolder.getBean(UserServiceImpl.class);
		System.out.println(service.getClass());
		service.B_();
	}
}
