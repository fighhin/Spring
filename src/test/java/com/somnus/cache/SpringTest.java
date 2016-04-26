package com.somnus.cache;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.memcached.MemCachedUtil;

public class SpringTest extends AbstractTestSupport {
	
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
