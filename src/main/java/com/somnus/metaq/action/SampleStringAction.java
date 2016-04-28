package com.somnus.metaq.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.metaq.support.jms.AbstractJmsReceiveTemplate;

public class SampleStringAction extends AbstractJmsReceiveTemplate<String>{
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void execute(String message) throws Exception {
		log.info("接收消息：{}", message);
		//TODO
		//消费者拿到想要的Obejct,至于怎么处理就是你自己的事情了
	}

}
