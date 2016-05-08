package com.somnus.redis;

import java.util.HashMap;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.redis.dao.RedisDao;
import com.somnus.redis.dao.UserDao;
import com.somnus.redis.dao.impl.RedisDaoImpl;
import com.somnus.redis.model.User;

public class SpringTest extends AbstractTestSupport{
	
	@Test
	public void testObject(){
		RedisDao redis = (RedisDao) ApplicationContextHolder.getBean(RedisDaoImpl.class);
		User user = new User();
        user.setUsername("Somnus");
        user.setPassword("passw0rd");
		redis.save("user:1", user);
		
		User quser = redis.get("user:1",User.class);
		System.out.println(quser);
	}
	
	@Test
	public void testMap(){
		RedisDao redis = (RedisDao) ApplicationContextHolder.getBean(RedisDaoImpl.class);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", "Somnus");
		map.put("password", "123456");
		redis.save("map:1", map);
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> qmap = redis.get("map:1",HashMap.class);
		System.out.println(qmap);
	}
	
	@Test
	public void testObject2(){
		UserDao redis = (UserDao) ApplicationContextHolder.getBean("redisUserDaoImpl");
		User user = new User();
        user.setUsername("Somnus");
        user.setPassword("passw0rd");
		redis.save("user:2", user);
		
		User quser = redis.get("user:2");
		System.out.println(quser);
	}
}
