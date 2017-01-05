package com.somnus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somnus.cache.Account;
import com.somnus.cache.AccountCache;
import com.somnus.memcached.MemCachedUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-memcached.xml")
public class MemcachedTest extends AbstractTestSupport {
	
	@Test
	public void cache(){
		AccountCache cache = ApplicationContextHolder.getApplicationContext().getBean(AccountCache.class);
		System.out.println(cache.getAccount("somnus"));
		System.out.println(cache.getAccount("somnus"));
		System.out.println(cache.getAccount("smile"));
		System.out.println(cache.getAccount("smile"));
	}
	
	@Test
	public void cache2(){
		Account account = (Account) MemCachedUtil.get("cache.somnus.account_somnus");
		System.out.println(account);
	}
}
