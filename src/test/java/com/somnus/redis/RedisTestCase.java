package com.somnus.redis;

import java.util.HashMap;
import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.redis.dao.RedisDao;
import com.somnus.redis.dao.RedisDaoImpl;
import com.somnus.redis.model.User;
import com.somnus.redis.util.JedisUtil;

/**  
 * @Description: TODO
 * @author Somnus
 * @date 2015年11月28日 下午8:16:32 
 * @version 1.0 
 */
public class RedisTestCase extends AbstractTestSupport{
	
	@Test
	public void testInsert(){
		RedisDao redis = (RedisDao) ApplicationContextHolder.getBean(RedisDaoImpl.class);
		User user = new User();
        user.setId(1);
        user.setName("Somnus");
		redis.saveUser(user);
	}
	
	@Test
	public void testLoad(){
		RedisDao redis = (RedisDao) ApplicationContextHolder.getBean(RedisDaoImpl.class);
		User user = redis.getUser(1);
		System.out.println(user);
	}
	
	@Test
	public void stringset(){
		System.out.println(JedisUtil.Strings.set("username", "admin"));
		
		System.out.println(JedisUtil.Strings.get("username"));
	}
	
	@Test
	public void stringsetnx(){
		System.out.println(JedisUtil.Strings.setnx("username", "somnus"));
		
		System.out.println(JedisUtil.Strings.get("username"));
	}
	
	@Test
	public void stringsetex() throws InterruptedException{
		System.out.println(JedisUtil.Strings.setEx("password",10, "passw0rd"));
		
		Thread.sleep(15*1000);
		
		System.out.println(JedisUtil.Strings.get("password"));
	}
	
	@Test
	public void stringsetrange(){
		System.out.println(JedisUtil.Strings.set("email", "928200207@qqq.com"));
		System.out.println(JedisUtil.Strings.setRange("email",10, "163"));
		
		System.out.println(JedisUtil.Strings.get("email"));
		System.out.println(JedisUtil.Strings.getRange("email",0, 8));
	}
	
	@Test
	public void stringmset(){
		System.out.println(JedisUtil.Strings.mset("key1","1","key2","2","key3","3","key4","4"));
		
		System.out.println(JedisUtil.Strings.mget("key1","key2","key3","key4"));
	}
	
	@Test
	public void stringgetset(){
		System.out.println(JedisUtil.Strings.getSet("email", "love@qq.com"));
		
		System.out.println(JedisUtil.Strings.get("email"));
	}
	
	@Test
	public void stringincrBy(){
		System.out.println(JedisUtil.Strings.set("age", "25"));
		
		System.out.println(JedisUtil.Strings.incrBy("age", 2));
		
		System.out.println(JedisUtil.Strings.decrBy("age", 4));
	}
	
	@Test
	public void stringappend(){
		System.out.println(JedisUtil.Strings.append("email", ".cn"));
	}
	
	@Test
	public void stringstrlen(){
		System.out.println(JedisUtil.Strings.strlen("email"));
	}
	//////////////////////////////////////////////////////////////////
	
	@Test
	public void hashset(){
		System.out.println(JedisUtil.Hash.hset("user", "username", "admin"));
		System.out.println(JedisUtil.Hash.hset("user", "password", "123456"));
		System.out.println(JedisUtil.Hash.hset("user", "age", "25"));
		
		System.out.println(JedisUtil.Hash.hget("user", "username"));
		System.out.println(JedisUtil.Hash.hget("user", "password"));
		System.out.println(JedisUtil.Hash.hget("user", "age"));
	}
	
	@Test
	public void hashhsetnx(){
		System.out.println(JedisUtil.Hash.hsetnx("user", "username", "guest"));
		System.out.println(JedisUtil.Hash.hset("user", "password", "passw0rd"));
		
		System.out.println(JedisUtil.Hash.hget("user", "username"));
		System.out.println(JedisUtil.Hash.hget("user", "password"));
	}
	
	@Test
	public void hashhhmset(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", "admin");
		map.put("password", "passw0rd");
		System.out.println(JedisUtil.Hash.hmset("people", map));
		
		System.out.println(JedisUtil.Hash.hmget("people","username","password"));
	}
	
	@Test
	public void hashhincrBy(){
		System.out.println(JedisUtil.Hash.hincrBy("user","age", 2));
	}
	
	@Test
	public void hashhexists(){
		System.out.println(JedisUtil.Hash.hexists("user","age"));
		System.out.println(JedisUtil.Hash.hexists("people","age"));
	}
	
	@Test
	public void hashhlen(){
		System.out.println(JedisUtil.Hash.hlen("user"));
		System.out.println(JedisUtil.Hash.hlen("people"));
	}
	
	@Test
	public void hashhdel(){
		System.out.println(JedisUtil.Hash.hdel("user","age"));
		System.out.println(JedisUtil.Hash.hdel("people"));
	}
	
	@Test
	public void hashhkeys(){
		System.out.println(JedisUtil.Hash.hkeys("user"));
		System.out.println(JedisUtil.Hash.hvals("user"));
		System.out.println(JedisUtil.Hash.hgetAll("user"));
	}
}
