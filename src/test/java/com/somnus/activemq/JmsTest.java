package com.somnus.activemq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class JmsTest extends AbstractTestSupport {
	
	@Value("${jms.topic.somnus.sample}")
	private String topic;
    
    @Test
    public void testSend() {
        JmsService jms = (JmsService) ApplicationContextHolder.getBean(JmsServiceImpl.class);  
        jms.send(topic,"你好，生产者！这是消息");
        try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
