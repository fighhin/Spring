package com.somnus.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/** 
 * @Title: ProducerServiceImpl.java 
 * @Package com.somnus.activemq 
 * @Description: TODO
 * @author Somnus
 * @date 2015年7月27日 上午10:45:38 
 * @version V1.0 
 */
@Component
public class JmsServiceImpl implements JmsService{
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Resource
    private Destination jmsQueue;
    
    public void sendMessage(String message) {
        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);
        jmsTemplate.convertAndSend(jmsQueue, message);   
    }
}
