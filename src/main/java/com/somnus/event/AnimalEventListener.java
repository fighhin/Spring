/**
 * 
 */
package com.somnus.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
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
public class AnimalEventListener implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof AnimalSpeakEvent) {
			 AnimalSpeakEvent a = (AnimalSpeakEvent) event;
			 System.out.println("事件监听器" + this.getClass().getSimpleName()+
					 ":有一个动物在讲话！它的名字是:"+ a.getAnimalName());
		}
		
	}

}
