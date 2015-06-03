package com.somnus.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/** 
 * @Title: GreetingAspect.java 
 * @Package com.somnus.annotation.aop 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月3日 上午10:49:06 
 * @version V1.0 
 */
@Aspect  
@Component 
public class GreetAspector {
    
    @Before("@annotation(com.somnus.annotation.aop.Tag)")
    public void before2() {
        System.out.println("@Before>>>>method before");
    }
    
    @AfterReturning("@annotation(com.somnus.annotation.aop.Tag)")
    public void AfterReturning() {
        System.out.println("@AfterReturning>>>>method after returning");
    }
    
    @Around("@annotation(com.somnus.annotation.aop.Tag)")
    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@Around>>>>method around start");
        System.out.println("@Around---->>>>"+pjp.getTarget());
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println("@Around---->>>>"+signature.getMethod());
        for(Object obj:pjp.getArgs()){
            System.out.println("@Around---->>>>"+obj);
        }
        pjp.proceed();
        System.out.println("@Around>>>>method around end");
    }
    
    @DeclareParents(value = "com.somnus.annotation.aop.GreetImpl", defaultImpl = ApologyImpl.class)  
    private Apology apology;
}
