package com.somnus.activemq;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.activemq.message.Message;

public class JmsTest extends AbstractTestSupport {
    
    @Test
    public void testSend() {
        JmsService jms = (JmsService) ApplicationContextHolder.getBean(JmsServiceImpl.class);  
        jms.sendMessage("你好，生产者！这是消息");
        try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void testSend2() {
        JmsService jms = (JmsService) ApplicationContextHolder.getBean(JmsServiceImpl.class);  
        jms.sendMessage(new Message("你学会了ActiveMQ吗","It's too diffcult to study ActiveMQ"));
        try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
