package com.somnus.batchtask.model;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.time.StopWatch;

/**
 * 
 * @ClassName:     HlrBusinessEventAdvisor.java
 * @Description:   Hlr指令派发时长计算代理类
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 下午5:44:07
 */
public class HlrBusinessEventAdvisor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 调用之前
        StopWatch sw = new StopWatch();
        sw.start();
        // 调用原始对象的方法
        Object result = invocation.proceed();
        sw.stop();
        System.out.println(String.format("执行交换机指令工单耗时:[%d]毫秒",sw.getTime()));
        return result;
	}
	
}
