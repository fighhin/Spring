package com.somnus.event.demo;

import org.springframework.stereotype.Component;

import com.somnus.event.AsyncEventListener;

@Component
public class EmailEventListener extends AsyncEventListener<EmailEvent>{

	@Override
	protected void handle(EmailEvent event) {
        System.out.println("需要发送邮件的接收地址为:"+event.getAddress());  
          
        System.out.println("需要发送邮件的邮件正文是:"+event.getText());  
	}
	
}
