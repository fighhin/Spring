package com.somnus.activemq.message;

import java.io.Serializable;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String topic;
	
	private String content;
	
	/**
	 * @param topic
	 * @param content
	 */
	public Message(String topic, String content) {
		super();
		this.topic = topic;
		this.content = content;
	}
	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
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
