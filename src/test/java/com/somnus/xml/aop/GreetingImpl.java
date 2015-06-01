package com.somnus.xml.aop;

import org.springframework.stereotype.Component;

/** 
 * @Title: GreetingImpl.java 
 * @Package com.somnus.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月1日 下午12:39:06 
 * @version V1.0 
 */
@Component
public class GreetingImpl implements Greeting {
    
    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }
}
