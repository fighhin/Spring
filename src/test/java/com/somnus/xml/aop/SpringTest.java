package com.somnus.xml.aop;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

/**
 * 
 * @Title: SpringTest.java 
 * @Package com.somnus.xml.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月1日 下午2:17:07 
 * @version V1.0
 */
public class SpringTest extends AbstractTestSupport {
	@Test
	public void save(){
	    /**从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）*/
	    GreetingInterface greeting = (GreetingInterface) ApplicationContextHolder.getBean("greetingProxy"); 
	    greeting.sayHello("Jack"); 
	}
	
	@Test
    public void save2(){
        /**从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）*/
        /**注意：转型为目标类，而并非它的 Greeting 接口*/
        GreetingImpl greetingImpl = (GreetingImpl) ApplicationContextHolder.getBean("greetingProxy2"); 
        greetingImpl.sayHello("Jack");
        /**将目标类强制向上转型为 Apology 接口（这是引入增强给我们带来的特性，也就是“接口动态实现”功能）*/
        Apology apology = (Apology) greetingImpl;
        apology.saySorry("Jack");
        System.out.println(apology);
    }
	
	@Test
    public void save3(){
        /**从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）*/
	    GreetingInterface greeting = (GreetingInterface) ApplicationContextHolder.getBean("greetingProxy3");
        greeting.sayHello("Jack");
        greeting.goodMorning("Jack");
    }
}
