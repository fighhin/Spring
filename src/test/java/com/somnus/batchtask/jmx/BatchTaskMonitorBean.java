package com.somnus.batchtask.jmx;

/**
 * 
 * @ClassName:     BatchTaskMonitorBean.java
 * @Description:   JMX批处理任务监控接口
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月2日 上午9:59:46
 */
public interface BatchTaskMonitorBean {
	public int getBatchTaskCounter(String taskName);
}
