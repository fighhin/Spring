package com.somnus.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/** 
 * @Title: GreetingBeforeAdvice.java 
 * @Package com.somnus.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月1日 下午12:33:22 
 * @version V1.0 
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{

    /* (non-Javadoc)
     * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
     */
    @Override
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println(">>>>>>Before");
    }

}
