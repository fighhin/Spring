package com.somnus.executor;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class SpringTest extends AbstractTestSupport {
	
	@Test
	public void exe(){
		AsyncExecutor executor = ApplicationContextHolder.getBean(AsyncExecutor.class);
		executor.execute();
		System.out.println("我已经执行了！");
		
		try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
