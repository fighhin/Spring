package com.somnus.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.somnus.activemq.message.Message;

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
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Resource
    private Destination jmsQueue;
    
    @Resource
    private Destination jms2Queue;
    
    public void sendMessage(String message) {
    	log.info("---------------生产者发了一个字符串消息：" + message);
        System.out.println();
        jmsTemplate.convertAndSend(jmsQueue, message);   
    }

	@Override
	public void sendMessage(Message message) {
		log.info("---------------生产者发了一个对象消息：" + message);
        jmsTemplate.convertAndSend(jms2Queue, message);  
	}
}
