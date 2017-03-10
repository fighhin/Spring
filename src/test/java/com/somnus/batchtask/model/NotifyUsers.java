package com.somnus.batchtask.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @ClassName:     NotifyUsers.java
 * @Description:   要进行批处理通知的用户对象
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年2月28日 下午5:33:56
 */
public class NotifyUsers {
	/** 用户归属地市编码*/
	private Integer homeCity;
	
	/** 用户的手机号*/
	private Integer msisdn;
	
	/** 用户标识*/
	private Integer userId;

	public Integer getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(Integer homeCity) {
		this.homeCity = homeCity;
	}

	public Integer getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(Integer msisdn) {
		this.msisdn = msisdn;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {  
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);   
    }
}
