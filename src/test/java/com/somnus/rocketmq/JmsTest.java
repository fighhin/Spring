package com.somnus.rocketmq;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class JmsTest extends AbstractTestSupport {
    
    @Test
    public void testSend() {
    	RocketMqService jms = (RocketMqService) ApplicationContextHolder.getBean(RocketMqServiceImpl.class);  
        jms.sendMessage("{\"username\":\"admin\"}");
        jms.sendMessage("{\"username\":\"admin\"}");
        jms.sendMessage("{\"username\":\"admin\"}");
        jms.sendMessage("{\"username\":\"admin\"}");
        try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
