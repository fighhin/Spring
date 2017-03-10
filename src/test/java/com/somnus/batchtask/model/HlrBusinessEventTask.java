package com.somnus.batchtask.model;

import java.util.concurrent.Callable;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * 
 * @ClassName:     HlrBusinessEventTask.java
 * @Description:   Hlr指令派发任务执行类
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 下午5:52:00
 */
public class HlrBusinessEventTask implements Callable<Integer>{

	private NotifyUsers user = null;
	
	private final static String MAPPERMETHODNAME = "execute";
	
	public HlrBusinessEventTask(NotifyUsers user) {
		super();
		this.user = user;
	}

	@Override
	public Integer call() throws Exception {
		synchronized (this) {
			ProxyFactory weave = new ProxyFactory(new HlrBusinessEvent());
			NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
			advisor.setMappedName(MAPPERMETHODNAME);
			advisor.setAdvice(new HlrBusinessEventAdvisor());
			weave.addAdvisor(advisor);
			
			BusinessEvent proxyObject = (BusinessEvent)weave.getProxy();
			Integer result = new Integer(proxyObject.execute(user.getUserId()));
			//返回执行结果
			return result;
		}
	}
	
	
}
