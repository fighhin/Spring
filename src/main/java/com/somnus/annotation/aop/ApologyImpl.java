package com.somnus.annotation.aop;

/** 
 * @Title: ApologyImpl.java 
 * @Package com.somnus.annotation.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月3日 下午12:57:50 
 * @version V1.0 
 */
public class ApologyImpl  implements Apology {  
   
    @Override  
    public void saySorry(String name) {  
        System.out.println("Sorry! " + name);  
    }  
}  
