package com.somnus.annotation.aop;

/** 
 * @Title: Greeting.java 
 * @Package com.somnus.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月1日 下午12:38:30 
 * @version V1.0 
 */
public interface Greet {
    void sayHello(String name);

    /**
     * @param name
     */
    void goodMorning(String name);

    /**
     * @param name
     */
    void goodNight(String name);
}
