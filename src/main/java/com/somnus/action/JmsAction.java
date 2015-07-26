package com.somnus.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.support.jms.AbstractJmsReceiveTemplate;

/** 
 * @Title: JmsAction.java 
 * @Package com.somnus.action 
 * @Description: TODO
 * @author Somnus
 * @date 2015年7月26日 下午5:57:02 
 * @version V1.0 
 */
public class JmsAction extends AbstractJmsReceiveTemplate{
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void execute(Object message) throws Exception {
		log.info("接收消息：{}", message);
	}

}
