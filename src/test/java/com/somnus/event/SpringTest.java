package com.somnus.event;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.event.demo.EmailEvent;
import com.somnus.event.demo.NotifyEvent;

public class SpringTest extends AbstractTestSupport {
	
	@Test
	public void event(){
		ApplicationContextHolder.getApplicationContext().publishEvent(
				new EmailEvent(this, "928200207@qq.com", "I love you"));
	}
	
	@Test
	public void reEvent(){
		ApplicationContextHolder.getApplicationContext().publishEvent(
				new NotifyEvent(this, "Somnus", "I love you"));
		
		try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
