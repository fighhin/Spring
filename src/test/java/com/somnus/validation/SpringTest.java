package com.somnus.validation;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.validation.model.User;
import com.somnus.validation.service.ValidationServiceImpl;

public class SpringTest extends AbstractTestSupport {
	
	@Test
	public void testPreCondtionFail(){
		ValidationServiceImpl service = ApplicationContextHolder.getBean(ValidationServiceImpl.class);
		System.out.println(service.guess(new User("ad#min", "123456")));//不对的用户名，即前置条件不满足
	}
	
	@Test
	public void testConditionSuccess(){
		ValidationServiceImpl service = ApplicationContextHolder.getBean(ValidationServiceImpl.class);
		System.out.println(service.guess(new User("ad#min", "123456")));//正常流程    
	}
	
	@Test
	public void testPostCondtionFail(){
		ValidationServiceImpl service = ApplicationContextHolder.getBean(ValidationServiceImpl.class);
		System.out.println(service.guess(new User("somnus", "123456")));//不满足后置条件的返回值  
	}
	
}
