package com.somnus.redis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.redis.dao.RedisDao;
import com.somnus.redis.dao.RedisDaoImpl;
import com.somnus.redis.model.User;

public class RedisTemplateTest extends AbstractTestSupport{
	
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
	public void stringSet(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		
		template.opsForValue().set("username", "Somnus");
		
		System.out.println(template.opsForValue().get("username"));
	}
	
	@Test
	public void stringSetNx(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		
		System.out.println(template.opsForValue().setIfAbsent("username", "somnus"));
		
		System.out.println(template.opsForValue().get("username"));
	}
	
	@Test
	public void stringSetEx() throws InterruptedException{
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		template.opsForValue().set("password", "passw0rd", 10, TimeUnit.SECONDS);
		
		Thread.sleep(15*1000);
		
		System.out.println(template.opsForValue().get("password"));
	}
	
	@Test
	public void stringSetrange(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		template.opsForValue().set("email", "928200207@qqq.com");
		template.opsForValue().set("email", "163", 10);
		
		System.out.println(template.opsForValue().get("email"));
		System.out.println(template.opsForValue().get("email",0, 8));
	}
	
	@Test
	public void stringMset(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key1", "1");
		map.put("key2", "2");
		map.put("key3", "3");
		map.put("key4", "4");
		template.opsForValue().multiSet(map);
		
		System.out.println(template.opsForValue().multiGet(
				Arrays.asList(new String[]{"key1","key2","key3","key4"})));
	}
	
	@Test
	public void stringMsetnx(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key1", "1");
		map.put("key2", "2");
		map.put("key3", "3");
		map.put("key5", "5");
		System.out.println(template.opsForValue().multiSetIfAbsent(map));
		
		System.out.println(template.opsForValue().multiGet(
				Arrays.asList(new String[]{"key1","key2","key3","key5"})));
	}
	
	@Test
	public void stringGetset(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		System.out.println(template.opsForValue().getAndSet("email", "love@qq.com"));
		
		System.out.println(template.opsForValue().get("email"));
	}
	
	@Test
	public void stringIncrBy(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		template.opsForValue().set("age", "25");
		
		System.out.println(template.opsForValue().increment("age", 2));
		
		System.out.println(template.opsForValue().increment("age", -4));
	}
	
	@Test
	public void stringAppend(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		
		System.out.println(template.opsForValue().append("email", ".cn"));
	}
	
	@Test
	public void stringStrlen(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		
		System.out.println(template.opsForValue().size("email"));
	}
	// ******************对存储结构为String类型的操作结束*********************************************//
	@Test
	public void hashSet(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		template.opsForHash().put("user", "username", "admin");
		template.opsForHash().put("user", "password", "123456");
		template.opsForHash().put("user", "age", "25");
		
		System.out.println(template.opsForHash().get("user", "username"));
		System.out.println(template.opsForHash().get("user", "password"));
		System.out.println(template.opsForHash().get("user", "age"));
	}
	
	@Test
	public void hashHsetnx(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		System.out.println(template.opsForHash().putIfAbsent("user", "username", "guest"));
		System.out.println(template.opsForHash().putIfAbsent("user", "password", "passw0rd"));
		
		System.out.println(template.opsForHash().get("user", "username"));
		System.out.println(template.opsForHash().get("user", "password"));
	}
	
	@Test
	public void hashHmset(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", "admin");
		map.put("password", "passw0rd");
		template.opsForHash().putAll("people", map);
		
		System.out.println(template.opsForHash().multiGet(
				"people", Arrays.asList(new Object[]{"username","password"})));
	}
	
	@Test
	public void hashHincrBy(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		System.out.println(template.opsForHash().increment("user", "age", 2));
	}
	
	@Test
	public void hashHexists(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		System.out.println(template.opsForHash().hasKey("user", "age"));
		System.out.println(template.opsForHash().hasKey("people", "age"));
	}
	
	@Test
	public void hashHlen(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		System.out.println(template.opsForHash().size("user"));
		System.out.println(template.opsForHash().size("people"));
	}
	
	@Test
	public void hashHdel(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		template.opsForHash().delete("user", "username", "age");
		System.out.println(template.opsForHash().hasKey("user", "username"));
		System.out.println(template.opsForHash().hasKey("user", "password"));
		System.out.println(template.opsForHash().hasKey("user", "age"));
	}
	
	@Test
	public void hashHkeys(){
		StringRedisTemplate template = (StringRedisTemplate) ApplicationContextHolder.getBean(StringRedisTemplate.class);
		System.out.println(template.opsForHash().keys("user"));
		System.out.println(template.opsForHash().values("user"));
		System.out.println(template.opsForHash().entries("user"));
	}
	// *****************对存储结构为HashMap类型的操作结束*********************************************//
	
	
}
