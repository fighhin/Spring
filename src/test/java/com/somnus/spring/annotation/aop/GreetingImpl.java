package com.somnus.spring.annotation.aop;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/** 
 * @Title: GreetingImpl.java 
 * @Package com.somnus.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月1日 下午12:39:06 
 * @version V1.0 
 */
@Validated
@Component
public class GreetingImpl implements GreetingInterface {
    
    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }
    
    @Tag
    @Override
    public String goodMorning(String name) {  
        System.out.println("Good Morning! " + name);  
        return name.concat(" Good Morning! ");
    }
    
    @Tag
    @Override
    public void goodNight(String name) {  
        System.out.println("Good Night! " + name);  
    }
}
