package com.somnus.transaction;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.transaction.domain.User;
import com.somnus.transaction.service.UserServiceImpl;

public class SpringTest extends AbstractTestSupport {
	@Test
	public void save(){
		UserServiceImpl service = (UserServiceImpl)ApplicationContextHolder.getBean(UserServiceImpl.class);
		System.out.println(service.getClass());
		User user = new User();
		user.setUsername("somnus");
		user.setPassword("123456");
		service.add2(user);
	}
}
