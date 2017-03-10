package com.somnus.batchtask.parallel;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @ClassName:     BatchTaskConfiguration.java
 * @Description:   批处理线程池参数配置
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 上午11:04:07
 */
public class BatchTaskConfiguration {
	private String name;
	
	private int corePoolSize;
	
	private int maxPoolSize;
	
	private int keepAliveTime;
	
	private int workQueueSize;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public int getKeepAliveTime() {
		return keepAliveTime;
	}

	public void setKeepAliveTime(int keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	public int getWorkQueueSize() {
		return workQueueSize;
	}

	public void setWorkQueueSize(int workQueueSize) {
		this.workQueueSize = workQueueSize;
	}
	
	@Override
	public int hashCode(){
		return new HashCodeBuilder(1,31).append(name).toHashCode();
	}
	
	@Override
	public boolean equals(Object o){
		boolean res = false;
		if(o!=null && BatchTaskConfiguration.class.isAssignableFrom(o.getClass())){
			BatchTaskConfiguration s = (BatchTaskConfiguration)o;
			res = new EqualsBuilder().append(name, s.getName()).isEquals();
		}
		return res;
	}
	
	@Override
	public String toString() {  
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);   
    }
}
