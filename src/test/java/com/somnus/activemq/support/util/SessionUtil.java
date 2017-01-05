package com.somnus.activemq.support.util;

/**
 * 
 * @Title: SessionUtil.java 
 * @Package com.somnus.support.util 
 * @Description: TODO
 * @author Somnus
 * @date 2015年7月26日 下午5:32:30 
 * @version V1.0
 */
public class SessionUtil {

	/**
	 * @Description: 为每个线程生成唯一的sessionId
	 * @return String sessionId
	 * @throws
	 */
	public static String getSessionId() {
		String sessionId = System.currentTimeMillis() + "-"
				+ (int) ((Math.random() * 10000));
		return sessionId;
	}
}
