package com.somnus.annotation;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.annotation.aop.Apology;
import com.somnus.annotation.aop.Greet;
import com.somnus.annotation.aop.GreetImpl;

public class AspectTest extends AbstractTestSupport {
	@Test
	public void test1(){
		Greet greet = (Greet)ApplicationContextHolder.getBean(GreetImpl.class);
		greet.goodMorning("Jack");
	}
	
	@Test
    public void test2(){
	    Greet greet = (Greet) ApplicationContextHolder.getBean(GreetImpl.class);  
	    greet.sayHello("Jack");  
   
        Apology apology = (Apology) greet; // 强制转型为 Apology 接口  
        apology.saySorry("Jack");
    }
}
