package com.somnus.batchtask.parallel;

/**
 * 
 * @ClassName:     BatchTaskRunner.java
 * @Description:   批处理资源管理定义接口
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 下午1:48:34
 */
public interface BatchTaskRunner {
	
	public void initialize();
	
	public void close();
}
