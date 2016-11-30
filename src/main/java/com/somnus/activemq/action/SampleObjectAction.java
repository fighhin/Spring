package com.somnus.activemq.action;

import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.somnus.activemq.support.listener.AbstractJmsReceiveListener;

@Component
public class SampleObjectAction extends AbstractJmsReceiveListener{
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void execute(Message message) throws Exception {
		log.info("接收序列化的 Java对象消息：{}", ((ObjectMessage)message).getObject());
		//TODO
		//消费者拿到想要的Obejct,至于怎么处理就是你自己的事情了
	}
}
