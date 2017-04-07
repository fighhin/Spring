package com.somnus.spring.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somnus.ApplicationContextHolder;
import com.somnus.spring.xml.transaction.UserService;
import com.somnus.spring.xml.transaction.UserServiceNew;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-transaction.xml")
public class TransactionSpringTest {
	@Test
	public void test1(){
		UserService service = ApplicationContextHolder.getBean(UserService.class);
		System.out.println(service.getClass());
		service.A1();
	}
	@Test
	public void test2(){
		UserService service = ApplicationContextHolder.getBean(UserService.class);
		System.out.println(service.getClass());
		service.A11();
	}
	
	@Test
	public void test3(){
		UserService service = ApplicationContextHolder.getBean(UserService.class);
		System.out.println(service.getClass());
		service.A2();
	}
	@Test
	public void test4(){
		UserService service = ApplicationContextHolder.getBean(UserService.class);
		System.out.println(service.getClass());
		service.A22();
	}
	
	///////////////////////////////////////////////////////////////////
	
	@Test
	public void case1(){
		UserServiceNew service = ApplicationContextHolder.getBean(UserServiceNew.class);
		System.out.println(service.getClass());
		service.A1();
	}
	@Test
	public void case1_(){
		UserServiceNew service = ApplicationContextHolder.getBean(UserServiceNew.class);
		System.out.println(service.getClass());
		service.A1_();
	}
	@Test
	public void case2(){
		UserServiceNew service = ApplicationContextHolder.getBean(UserServiceNew.class);
		System.out.println(service.getClass());
		service.A11();
	}
	
	@Test
	public void case3(){
		UserServiceNew service = ApplicationContextHolder.getBean(UserServiceNew.class);
		System.out.println(service.getClass());
		service.A2();
	}
	@Test
	public void case4(){
		UserServiceNew service = ApplicationContextHolder.getBean(UserServiceNew.class);
		System.out.println(service.getClass());
		service.A22();
	}
	
}
