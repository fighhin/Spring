package com.somnus.redis;

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
	public void testUtil(){
		JedisUtil.Strings.set("username", "admin");
		System.out.println(JedisUtil.Strings.get("username"));
	}
}
