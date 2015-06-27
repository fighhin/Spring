package com.somnus.factory;

/** 
 * @Title: BeanFactory.java 
 * @Package com.somnus.factory 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月27日 下午9:16:41 
 * @version V1.0 
 */
public class BeanFactory {
	
	public static User getInstance(Somnus somnus){
		somnus.say();
		return new User();
	}
	
	public static class User{
		private String username;
		private String password;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
}