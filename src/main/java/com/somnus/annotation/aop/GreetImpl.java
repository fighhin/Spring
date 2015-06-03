package com.somnus.annotation.aop;

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
public class GreetImpl implements Greet {
    
    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }
    @Tag
    @Override
    public void goodMorning(String name) {  
        System.out.println("Good Morning! " + name);  
    }
    @Tag
    @Override
    public void goodNight(String name) {  
        System.out.println("Good Night! " + name);  
    }
}
