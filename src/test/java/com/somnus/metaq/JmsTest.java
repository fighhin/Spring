package com.somnus.metaq;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class JmsTest extends AbstractTestSupport {
    
    @Test
    public void testSend() {
        JmsMetaqService jms = (JmsMetaqService) ApplicationContextHolder.getBean(JmsMetaqServiceImpl.class);  
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
