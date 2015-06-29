package com.somnus.annotation.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
    /**@前置通知
     * 方法开始之前执行一段代码
     * @param joinPoint
     */
    @Before("@annotation(com.somnus.annotation.aop.Tag)")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method 【" + methodName + "】 begins with " + Arrays.asList(args));
    }
    
    /**@后置最终通知
     * 方法执行之后执行一段代码
     * 无论该方法是否出现异常
     * @param joinPoint
     */
    @After("@annotation(com.somnus.annotation.aop.Tag)")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method 【" + methodName + "】 ends with " + Arrays.asList(args));
    }
    
    /**@后置返回通知
     * 方法正常结束后执行的代码，不包括抛出异常的情况
     * 返回通知是可以访问到方法的返回值的
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value="@annotation(com.somnus.annotation.aop.Tag)",returning="result")
    public void AfterReturning(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method 【" + methodName + "】 return with " + result);
    }
    
    /**@后置异常通知
     * 在方法出现异常时会执行的代码
     * 可以访问到异常对象，可以指定在出现特定异常时在执行通知代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value="@annotation(com.somnus.annotation.aop.Tag)", throwing="ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception: " + ex);
    }
    
    /**@环绕通知
     * 环绕通知需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
     * 而且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(public * *(..)) && @within(org.springframework.validation.annotation.Validated)")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        System.out.println("target:"+pjp.getTarget());
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getName();
        //执行目标方法
        try {
            //前置通知
            System.out.println("ARROUND-->The method 【" + methodName + "】 begins with 【" + Arrays.asList(pjp.getArgs()) +"】");
            result = pjp.proceed();
            //后置最终通知【方法执行之后执行一段代码，无论该方法是否出现异常】
            System.out.println("ARROUND-->The method 【" + methodName + "】 ends with 【" + signature.getReturnType() +"】");
        } catch (Throwable e) {
            //后置异常通知【在方法出现异常时会执行的代码】
            System.out.println("ARROUND-->The method 【" + methodName + "】 occurs expection : 【" + e +"】");
            throw new RuntimeException(e);
        }
        //后置返回通知【方法正常结束后执行的代码，不包括抛出异常的情况】
        System.out.println("ARROUND-->The method 【" + methodName + "】 return with 【" + result +"】");
        return result;
    }
    
    /**
     * 用 AOP 的行话来讲，对方法的增强叫做 Weaving（织入），
     * 而对类的增强叫做 Introduction（引入）。
     * 而 Introduction Advice（引入增强）就是对类的功能增强，
     * 它也是 Spring AOP 提供的最后一种增强
     */
    @DeclareParents(value = "com.somnus.annotation.aop.GreetImpl", defaultImpl = ApologyImpl.class)  
    private Apology apology;
}
