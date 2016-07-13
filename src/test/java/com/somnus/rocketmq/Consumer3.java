package com.somnus.rocketmq;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;  
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;  
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;  
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;  
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;  

public class Consumer3 {

    public static void main(String[] args){
    	
    	new Thread(new Runnable() {
            @Override
            public void run() {
            	DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");
                consumer.setNamesrvAddr("172.16.235.77:9876;172.16.235.78:9876");
                consumer.setInstanceName("Consumber33");

                try {
        			consumer.subscribe("TopicTest11", "TagA || TagB || TagC");
        		} catch (MQClientException e) {
        			e.printStackTrace();
        		}

                consumer.registerMessageListener(new MessageListenerConcurrently() {

                    @Override
                    public ConsumeConcurrentlyStatus consumeMessage(
                            List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                        MessageExt msg = msgs.get(0);
                        if (msg.getTopic().equals("TopicTest11")) {
                            // 执行TopicTest1的消费逻辑
                            if (msg.getTags() != null 
                            		&& msg.getTags().equals("TagA")) {
                                // 执行TagA的消费
                                System.out.println(Thread.currentThread().getName() + "==>TopicTest11=>" + msg.getStoreHost()+ "=>" + msg.getTags() + "=>" + new String(msg.getBody()));
                            } else if (msg.getTags() != null 
                            		&& msg.getTags().equals("TagB")) {
                                // 执行TagB的消费
                            	System.out.println(Thread.currentThread().getName() + "==>TopicTest11=>" + msg.getStoreHost()+ "=>" + msg.getTags() + "=>" + new String(msg.getBody()));
                            }
                        }
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                });

                try {
        			consumer.start();
        		} catch (MQClientException e) {
        			e.printStackTrace();
        		}

                System.out.println("Consumer Started 3.");
            }
        }).start();
    	
    }
}

