package com.somnus.annotation.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/** 
 * @Title: Tag.java 
 * @Package com.somnus.annotation.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月3日 上午10:46:03 
 * @version V1.0 
 */
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)  
public @interface Tag {  
}  
