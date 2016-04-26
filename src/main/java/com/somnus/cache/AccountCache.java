package com.somnus.cache;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class AccountCache {
	
	@Cacheable(value = "cache.somnus.account", key = "#p0")
	public Account getAccount(String username){
		Account account = new Account();
		System.out.println("缓存里没有拿到值，需要从数据库中查，这里我们模仿自己设置出一个值来");
		account.setUsername(username);
		account.setPassword(username+"123456");
		return account;
	}
}
class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {  
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);   
    }  
}