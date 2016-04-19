package com.somnus.event.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
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
public class ContextRefreshedListener implements InitializingBean, ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext context = event.getApplicationContext();
		if(context.getParent() == null){
			System.out.println("Spring容器初始化完毕================================================");
			System.out.println("ContextRefreshedListener is invoked");
		}
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet is invoked================================================");
		
	}

}
