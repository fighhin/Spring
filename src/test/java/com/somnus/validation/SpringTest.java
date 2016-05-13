package com.somnus.validation;

import java.util.Set;

import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.validation.model.User;
import com.somnus.validation.service.ValidationServiceImpl;

public class SpringTest extends AbstractTestSupport {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPreCondtionFail(){
		try {
			ValidationServiceImpl service = ApplicationContextHolder.getBean(ValidationServiceImpl.class);
			System.out.println(service.guess(new User("ad#min", "123456")));//不对的用户名，即前置条件不满足
		} catch (RuntimeException e) {
			System.out.println(e.getClass());
			Throwable throwable = e.getCause();
			if(throwable instanceof MethodConstraintViolationException){
				Set<MethodConstraintViolation<?>> constraintViolations = ((MethodConstraintViolationException)throwable).getConstraintViolations();
				for(MethodConstraintViolation constraint:constraintViolations){
					System.out.println(constraint.getPropertyPath().toString());
					System.out.println(constraint.getMessage());
					System.out.println(constraint.getMessageTemplate());
				}
			}
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConditionSuccess(){
		ValidationServiceImpl service = ApplicationContextHolder.getBean(ValidationServiceImpl.class);
		System.out.println(service.guess(new User("admin", "123456")));//正常流程    
	}
	
	@Test
	public void testPostCondtionFail(){
		ValidationServiceImpl service = ApplicationContextHolder.getBean(ValidationServiceImpl.class);
		System.out.println(service.guess(new User("somnus", "123456")));//不满足后置条件的返回值  
	}
	
}
