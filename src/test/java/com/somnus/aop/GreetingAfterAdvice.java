package com.somnus.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/** 
 * @Title: GreetingAfterAdvice.java 
 * @Package com.somnus.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月1日 下午12:36:05 
 * @version V1.0 
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    /* (non-Javadoc)
     * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(">>>>>>After");
    }

}
