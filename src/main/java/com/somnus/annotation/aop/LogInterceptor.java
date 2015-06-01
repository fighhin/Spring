package com.somnus.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	//定义一个方法作为切入点
	@Pointcut("execution(public * com.somnus.annotation.service..*.add(..))")
	public void myMethod(){};
	
	@Before("myMethod()")
//	@Before("execution(public * com.somnus.annotation.service..*.add(..))")
	public void before() 
	{
		System.out.println("@Before>>>>method before");
	}
	
	@AfterReturning("myMethod()")
//	@Before("execution(public * com.somnus.annotation.service..*.add(..))")
	public void AfterReturning() 
	{
		System.out.println("@AfterReturning>>>>method after returning");
	}
	
	@AfterThrowing("myMethod()")
//	@AfterThrowing("execution(public * com.somnus.annotation.service..*.add(..))")
	public void AfterThrowin() 
	{
		System.out.println("@AfterThrowing>>>>method after throwin");
	}
	
	
	@Around("myMethod()")
//	@Around("execution(public * com.somnus.annotation.service..*.add(..))")
	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable 
	{
		System.out.println("@Around>>>>method around start");
		System.out.println("@Around---->>>>"+pjp.getTarget());
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		System.out.println("@Around---->>>>"+signature.getMethod());
		for(Object obj:pjp.getArgs()){
			System.out.println("@Around---->>>>"+obj);
		}
		pjp.proceed(/*new String[]{"这里可以改变原来的参数值"}*/);
		System.out.println("@Around>>>>method around end");
	}
	
}
