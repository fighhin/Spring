package com.somnus.batchtask.model;

/**
 * 
 * @ClassName:     BusinessEvent.java
 * @Description:   业务事件任务接口定义
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 下午5:23:06
 */
public interface BusinessEvent {
	
	/** 执行具体批处理的任务*/
	public int execute(Integer userId);
}
