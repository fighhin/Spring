/**
 * 
 */
package com.somnus.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description: 
 * Copyright 2011-2016 B5M.COM. All rights reserved
 * @author:  Somnus
 * @version: 1.0
 * @createDate: 2016年3月22日 下午5:51:32 
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2016年3月22日       Somnus       1.0            
 */
@Component
public class Animal implements ApplicationContextAware {
	private ApplicationContext ac;
	
	private String name = "dudu";
	
	private int age = 10;
	
	public String speak(){
		ac.publishEvent(new AnimalSpeakEvent(this,this.name));
		return " 我的名字是;"+this.name+",我的年龄是:"+this.age;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.ac = arg0;
	}

}
