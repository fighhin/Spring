package com.somnus.metaq.support.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.somnus.activemq.support.common.Constants;
import com.somnus.activemq.support.util.SessionUtil;
import com.taobao.metamorphosis.client.extension.spring.DefaultMessageListener;
import com.taobao.metamorphosis.client.extension.spring.MetaqMessage;

public abstract class AbstractJmsReceiveTemplate<T> extends DefaultMessageListener<T> {

    protected transient Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onReceiveMessages(MetaqMessage<T> message) {
    	try {
            MDC.put(Constants.SESSION_ID, SessionUtil.getSessionId());
            T t = message.getBody();
            execute(t);
        } catch (Throwable e) {
            logger.error("MQ消息处理异常{},：{}", message.toString(), e);
        } finally {
            MDC.remove(Constants.SESSION_ID);
        }
    }

    protected abstract void execute(T t) throws Exception;
}
