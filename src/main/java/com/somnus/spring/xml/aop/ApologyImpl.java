package com.somnus.spring.xml.aop;

public class ApologyImpl implements Apology {  
   
    @Override  
    public void saySorry(String name) {  
        System.out.println("Sorry! " + name);  
    }  
}  
