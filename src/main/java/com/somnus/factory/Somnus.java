package com.somnus.factory;

import org.springframework.stereotype.Component;

/** 
 * @Title: Somnus.java 
 * @Package com.somnus.factory 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月27日 下午9:44:27 
 * @version V1.0 
 */
@Component
public class Somnus{
	public String say(){
		return "静态工厂中的方法被执行！！!";
	}
}