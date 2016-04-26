package com.somnus.event.ordered;

import org.springframework.context.ApplicationEvent;

public class SmsEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 1L;
	
	private String content;

	/**
	 * @param source
	 */
	public SmsEvent(Object source, String content) {
		super(source);
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
