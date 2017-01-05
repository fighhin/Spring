package com.somnus.activemq.action;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.somnus.activemq.support.listener.AbstractJmsReceiveListener;

@Component
public class SampleStringAction extends AbstractJmsReceiveListener{
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void execute(Message message) throws Exception {
		log.info("接收字符串消息：{}", ((TextMessage)message).getText());
		//TODO
		//消费者拿到想要的字符串,至于怎么处理就是你自己的事情了
	}
}
