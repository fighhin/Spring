package com.somnus.event.ordered;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SmsEvent2Listener implements SmartApplicationListener {  
  
	/**
	 * 用于指定支持的事件类型，只有支持的才调用onApplicationEvent；
	 */
    @Override  
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {  
        return eventType == SmsEvent.class;  
    }  
  
    /**
     * 支持的目标类型，只有支持的才调用onApplicationEvent；
     */
    @Override  
    public boolean supportsSourceType(Class<?> sourceType) {  
        return sourceType == String.class;  
    }  
  
    @Override  
    public void onApplicationEvent(ApplicationEvent event) {
    	System.out.println("王五在孙六之前收到新的内容：" + event.getSource()); 
    }  
  
    /**
     * 即顺序，越小优先级越高
     */
    @Override  
    public int getOrder() {  
        return 2;  
    }  
}
