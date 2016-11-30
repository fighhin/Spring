package com.somnus.activemq.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.somnus.activemq.support.listener.AbstractJmsReceiveListener2;

@Component
public class SampleObjectAction extends AbstractJmsReceiveListener2{
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void execute(Object message) throws Exception {
		log.info("接收序列化的 Java对象消息：{}", message);
		//TODO
		//消费者拿到想要的Obejct,至于怎么处理就是你自己的事情了
	}
}
