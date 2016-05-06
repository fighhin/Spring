package com.somnus.redis;

import java.util.HashMap;
import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.redis.util.JedisUtil;

/**  
 * @Description: TODO
 * @author Somnus
 * @date 2015年11月28日 下午8:16:32 
 * @version 1.0 
 */
public class JedisTest extends AbstractTestSupport{
	
	@Test
	public void stringSet(){
		System.out.println(JedisUtil.Strings.set("username", "admin"));
		
		System.out.println(JedisUtil.Strings.get("username"));
	}
	
	@Test
	public void stringSetnx(){
		System.out.println(JedisUtil.Strings.setnx("username", "somnus"));
		
		System.out.println(JedisUtil.Strings.get("username"));
	}
	
	@Test
	public void stringSetex() throws InterruptedException{
		System.out.println(JedisUtil.Strings.setex("password", 10, "passw0rd"));
		
		Thread.sleep(15*1000);
		
		System.out.println(JedisUtil.Strings.get("password"));
	}
	
	@Test
	public void stringSetrange(){
		System.out.println(JedisUtil.Strings.set("email", "928200207@qqq.com"));
		System.out.println(JedisUtil.Strings.setrange("email", 10, "163"));
		
		System.out.println(JedisUtil.Strings.get("email"));
		System.out.println(JedisUtil.Strings.getrange("email", 0, 8));
	}
	
	@Test
	public void stringMset(){
		System.out.println(JedisUtil.Strings.mset("key1","1","key2","2","key3","3","key4","4"));
		
		System.out.println(JedisUtil.Strings.mget("key1","key2","key3","key4"));
	}
	
	@Test
	public void stringMsetnx(){
		System.out.println(JedisUtil.Strings.msetnx("key1","1","key2","2","key3","3","key5","5"));
		
		System.out.println(JedisUtil.Strings.mget("key1","key2","key3","key4"));
	}
	
	@Test
	public void stringGetset(){
		System.out.println(JedisUtil.Strings.getSet("email", "love@qq.com"));
		
		System.out.println(JedisUtil.Strings.get("email"));
	}
	
	@Test
	public void stringIncrBy(){
		System.out.println(JedisUtil.Strings.set("age", "25"));
		
		System.out.println(JedisUtil.Strings.incrBy("age", 2));
		
		System.out.println(JedisUtil.Strings.decrBy("age", 4));
	}
	
	@Test
	public void stringAppend(){
		System.out.println(JedisUtil.Strings.append("email", ".cn"));
	}
	
	@Test
	public void stringStrlen(){
		System.out.println(JedisUtil.Strings.strlen("email"));
	}
	// ******************对存储结构为String类型的操作结束*********************************************//
	@Test
	public void hashSet(){
		System.out.println(JedisUtil.Hash.hset("user", "username", "admin"));
		System.out.println(JedisUtil.Hash.hset("user", "password", "123456"));
		System.out.println(JedisUtil.Hash.hset("user", "age", "25"));
		
		System.out.println(JedisUtil.Hash.hget("user", "username"));
		System.out.println(JedisUtil.Hash.hget("user", "password"));
		System.out.println(JedisUtil.Hash.hget("user", "age"));
	}
	
	@Test
	public void hashHsetnx(){
		System.out.println(JedisUtil.Hash.hsetnx("user", "username", "guest"));
		System.out.println(JedisUtil.Hash.hset("user", "password", "passw0rd"));
		
		System.out.println(JedisUtil.Hash.hget("user", "username"));
		System.out.println(JedisUtil.Hash.hget("user", "password"));
	}
	
	@Test
	public void hashHmset(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", "admin");
		map.put("password", "passw0rd");
		System.out.println(JedisUtil.Hash.hmset("people", map));
		
		System.out.println(JedisUtil.Hash.hmget("people", "username", "password"));
	}
	
	@Test
	public void hashHincrBy(){
		System.out.println(JedisUtil.Hash.hincrBy("user", "age", 2));
	}
	
	@Test
	public void hashHexists(){
		System.out.println(JedisUtil.Hash.hexists("user", "age"));
		System.out.println(JedisUtil.Hash.hexists("people", "age"));
	}
	
	@Test
	public void hashHlen(){
		System.out.println(JedisUtil.Hash.hlen("user"));
		System.out.println(JedisUtil.Hash.hlen("people"));
	}
	
	@Test
	public void hashHdel(){
		System.out.println(JedisUtil.Hash.hdel("user", "age"));
		System.out.println(JedisUtil.Hash.hdel("people"));
	}
	
	@Test
	public void hashHkeys(){
		System.out.println(JedisUtil.Hash.hkeys("user"));
		System.out.println(JedisUtil.Hash.hvals("user"));
		System.out.println(JedisUtil.Hash.hgetAll("user"));
	}
}
