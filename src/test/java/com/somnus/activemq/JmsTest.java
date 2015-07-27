package com.somnus.activemq;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class JmsTest extends AbstractTestSupport {
    
    @Test
    public void testSend() {
        JmsService jms = (JmsService) ApplicationContextHolder.getBean(JmsServiceImpl.class);  
        jms.sendMessage("你好，生产者！这是消息" );
    }
}
