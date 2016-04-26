package com.somnus.event.ordered;

import org.springframework.context.ApplicationEvent;

public class SmsEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param source
	 */
	public SmsEvent(Object source) {
		super(source);
	}
	
}
