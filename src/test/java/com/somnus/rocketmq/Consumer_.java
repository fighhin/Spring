package com.somnus.rocketmq;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * DefaultMQProducer、TransactionMQProducer、
 * DefaultMQPushConsumer、DefaultMQPullConsumer
 * 都继承于ClientConfig类，ClientConfig为客户端的公共配置类。
 *
 */
public class Consumer_ {
	
	public static void main(String[] args) throws MQClientException {
		
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");
        consumer.setNamesrvAddr("172.16.235.77:9876;172.16.235.78:9876");
        consumer.setInstanceName("Consumber");

        consumer.subscribe("OrderTopic", "TagA|| TagB || TagC");

        consumer.registerMessageListener(new MessageListenerOrderly() {

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
            	
            	MessageExt msg = msgs.get(0);
            	
                System.out.println(new String(msg.getBody())+"==>"+msg);

                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();

        System.out.println("Consumer Started.");
    }
}
