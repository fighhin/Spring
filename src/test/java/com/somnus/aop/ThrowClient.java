package com.somnus.aop;

import org.springframework.aop.framework.ProxyFactory;

/** 
 * @Title: ThrowClient.java 
 * @Package com.somnus.aop 
 * @Description: TODO
 * @author yh.liu
 * @date 2015年6月1日 下午12:37:49 
 * @version V1.0 
 */
public class ThrowClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();     // 创建代理工厂
        proxyFactory.setTarget(new ThrowGreetingImpl());    // 射入目标类对象
        proxyFactory.addAdvice(new GreetingThrowAdvice());  // 添加抛出增强
 
        Greeting greeting = (Greeting) proxyFactory.getProxy(); // 从代理工厂中获取代理
        greeting.sayHello("Jack");                              // 调用代理的方法

    }

}
