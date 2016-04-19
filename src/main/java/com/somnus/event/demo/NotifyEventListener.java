package com.somnus.event.demo;

import org.springframework.stereotype.Component;

import com.somnus.event.AsyncEventListener;

@Component
public class NotifyEventListener extends AsyncEventListener<NotifyEvent>{

	@Override
	protected void handle(NotifyEvent event) {
        System.out.println("通知到的接收人为:"+event.getReceiver());  
        
        System.out.println("通知的内容是:"+event.getContent());
        
        ohshit();
	}
	
	/** 为了抛异常,从而可以看到失败轮询*/
	private void ohshit(){
		System.out.println(1/0);
	}
	
}
