package com.somnus.event.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @description: 
 * Copyright 2011-2016 B5M.COM. All rights reserved
 * @author:  Somnus
 * @version: 1.0
 * @createDate: 2016年3月22日 下午5:54:48 
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2016年3月22日       Somnus       1.0            
 */
@Component
public class ContextClosedListener implements ApplicationListener<ContextClosedEvent>{

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		ApplicationContext context = event.getApplicationContext();
		if(context.getParent() == null){
			System.out.println("Spring容器关闭================================================");
			System.out.println("ContextClosedListener is invoked");
		}
		
	}

}
