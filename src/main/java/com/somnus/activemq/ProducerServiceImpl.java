package com.somnus.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
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
public class ProducerServiceImpl implements ProducerService{
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    public void sendMessage(Destination destination, final String message) {
        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });   
    }
}
