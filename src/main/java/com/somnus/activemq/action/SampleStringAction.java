package com.somnus.activemq.action;

import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.somnus.activemq.support.listener.AbstractJmsReceiveListener;

@Component
public class SampleStringAction extends AbstractJmsReceiveListener{
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void execute(Object message) throws Exception {
		log.info("接收消息：{}", ((TextMessage)message).getText());
		//TODO
		//消费者拿到想要的Obejct,至于怎么处理就是你自己的事情了
	}
}
