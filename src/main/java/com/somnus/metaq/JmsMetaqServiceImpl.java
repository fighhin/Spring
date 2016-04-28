package com.somnus.metaq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.taobao.metamorphosis.client.extension.spring.MessageBuilder;
import com.taobao.metamorphosis.client.extension.spring.MetaqTemplate;
import com.taobao.metamorphosis.client.producer.SendResult;

@Component
public class JmsMetaqServiceImpl implements JmsMetaqService{
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private MetaqTemplate metaqTemplate;
    
    @Value("${jms.topic.somnus.sample}")
    private String metaqTopic;
    
	@Override
	public void sendMessage(String message) {
		log.info("---------------生产者发了一个字符串消息：" + message);
        SendResult sendResult = null;
		try {
			sendResult = metaqTemplate.send(MessageBuilder.withTopic(metaqTopic).withBody(message));
		} catch (InterruptedException e) {
			log.error(e.getMessage(),e);
		}
        // check result
        if (sendResult.isSuccess()) {
        	log.info("Send message successfully,sent to {}",sendResult.getPartition());
        } else {
        	log.warn("Send message failed,error message:{}",sendResult.getErrorMessage());
        }
	}
	
}
