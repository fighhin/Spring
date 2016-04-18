package com.somnus.activemq;

import com.somnus.activemq.message.Message;

/** 
 * @Title: ProducerService.java 
 * @Package com.somnus.activemq 
 * @Description: TODO
 * @author Somnus
 * @date 2015年7月27日 上午10:44:45 
 * @version V1.0 
 */
public interface JmsService {
	
    public void sendMessage(String message);
    
    public void sendMessage(Message message);
}
