package com.somnus.rocketmq;

import java.util.List;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * Producer，发送顺序消息
 */
public class Producer_ {

	public static void main(String[] args) {
        try {
        	DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
    		producer.setNamesrvAddr("172.16.235.77:9876;172.16.235.78:9876");
    		producer.setInstanceName("Producer");

            producer.start();

            String[] tags = new String[] { "TagA", "TagB", "TagC"};

            for (int i = 0; i < 3; i++) {
                // 订单ID相同的消息要有序
                Message msg = new Message("OrderTopic", tags[i], "10001",
                            ("Hello RocketMQ 10001").getBytes());

                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 10001);

                System.out.println(sendResult);
            }
            
            for (int i = 0; i < 3; i++) {
                // 订单ID相同的消息要有序
                Message msg = new Message("OrderTopic", tags[i], "10002",
                            ("Hello RocketMQ 10002").getBytes());

                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 10002);

                System.out.println(sendResult);
            }
            
            for (int i = 0; i < 3; i++) {
                // 订单ID相同的消息要有序
                Message msg = new Message("OrderTopic", tags[i], "10003",
                            ("Hello RocketMQ 10003").getBytes());

                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 10003);

                System.out.println(sendResult);
            }
            
            for (int i = 0; i < 3; i++) {
                // 订单ID相同的消息要有序
                Message msg = new Message("OrderTopic", tags[i], "10004",
                            ("Hello RocketMQ 10004").getBytes());

                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 10004);

                System.out.println(sendResult);
            }

            producer.shutdown();
        }
        catch (MQClientException e) {
            e.printStackTrace();
        }
        catch (RemotingException e) {
            e.printStackTrace();
        }
        catch (MQBrokerException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
