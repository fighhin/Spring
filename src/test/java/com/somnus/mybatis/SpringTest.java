package com.somnus.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
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
		
		UserInfo userparam = new UserInfo();
		userparam.setUsername("admin%");
		Map<String,Object> mapparam= new HashMap<String,Object>();
		mapparam.put("page", 1);
		mapparam.put("limit", 4);
		mapparam.put("sortString", "password.asc,username.desc");
		
		PageList<UserInfo> pagelist = service.selectByParams(userparam,mapparam);
		
		Paginator p= pagelist.getPaginator();
		System.out.println("总记录条数"+p.getTotalCount());
		System.out.println("总页数"+p.getTotalPages());
		
		for(UserInfo data:pagelist){
			System.out.println(data.getUsername());
			System.out.println(data.getPassword());
		}
	}
}
