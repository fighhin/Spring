package com.somnus.event;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.event.demo.EmailEvent;
import com.somnus.event.demo.NotifyEvent;
import com.somnus.event.ordered.SmsEvent;

public class SpringTest extends AbstractTestSupport {
	
	@Test
	public void event(){
		ApplicationContextHolder.getApplicationContext().publishEvent(
				new EmailEvent(this, "928200207@qq.com", "I love you"));
	}
	
	@Test
	public void ordered(){
		ApplicationContextHolder.getApplicationContext().publishEvent(
				new SmsEvent("你的队友被围攻啦"));
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
