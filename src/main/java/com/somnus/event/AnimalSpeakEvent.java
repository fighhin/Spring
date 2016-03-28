/**
 * 
 */
package com.somnus.event;

import org.springframework.context.ApplicationEvent;

/**
 * @description: 
 * Copyright 2011-2016 B5M.COM. All rights reserved
 * @author:  Somnus
 * @version: 1.0
 * @createDate: 2016年3月22日 下午5:48:49 
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2016年3月22日       somnus        1.0            
 */
public class AnimalSpeakEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	
	private String animalName;

	/**
	 * @param source
	 */
	public AnimalSpeakEvent(Object source) {
		super(source);
	}
	
	public AnimalSpeakEvent(Object source,String animalName) {
		super(source);
		this.animalName = animalName;
	}

	public String getAnimalName() {
		return animalName;
	}

}
