package com.somnus.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.somnus.AbstractTestSupport;

public class JmsTest extends AbstractTestSupport {
    @Autowired
    private ProducerService producerService;
    
    @Resource(name="jmsQueue")
    private Destination destination;

    @Test
    public void testSend() {
        for (int i = 0; i < 5; i++) {
            producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i + 1));
        }
    }
}
