package com.somnus.rocketmq;

import com.alibaba.rocketmq.common.message.Message;

public interface RocketMqService {
	
    public void sendMessage(String message);
    
}
