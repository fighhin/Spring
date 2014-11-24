package com.somnus.mybatis;

import org.junit.Test;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.mybatis.domain.UserInfo;
import com.somnus.mybatis.service.UserInfoServiceImpl;

public class SpringTest extends AbstractTestSupport {
	@Test
	public void save(){
		UserInfoServiceImpl service = (UserInfoServiceImpl)ApplicationContextHolder.getBean(UserInfoServiceImpl.class);
		UserInfo  user = service.selectByKey(1);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		PageList<UserInfo> pagelist = service.selectByParams("admin");
		for(UserInfo data:pagelist){
			System.out.println(data.getUsername());
			System.out.println(data.getPassword());
		}
	}
}
