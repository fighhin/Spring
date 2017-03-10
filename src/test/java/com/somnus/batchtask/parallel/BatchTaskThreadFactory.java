package com.somnus.batchtask.parallel;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @ClassName:     BatchTaskThreadFactory.java
 * @Description:   线程池工厂
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 下午1:51:07
 */
public class BatchTaskThreadFactory implements ThreadFactory{
	
	private final static String BATCHTASKFACTORYNAME = "batchtask-pool";
	private final String name;
	private final ThreadGroup threadGroup;
	private AtomicInteger threadNumber = new AtomicInteger(0);
	
	public BatchTaskThreadFactory(){
		this(BATCHTASKFACTORYNAME);
	}
	
	public BatchTaskThreadFactory(String name){
		this.name = name;
		SecurityManager security = System.getSecurityManager();
		threadGroup = (security != null)?security.getThreadGroup():Thread.currentThread().getThreadGroup();
	}

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(threadGroup,runnable);
		thread.setName(String.format("BatchTask[%s-%d]", threadGroup.getName(),threadNumber.incrementAndGet()));
		System.out.println(String.format("BatchTask[%s-%d]", threadGroup.getName(),threadNumber.incrementAndGet()));
		if(thread.isDaemon()){
			thread.setDaemon(false);
		}
		if(thread.getPriority() != Thread.NORM_PRIORITY){
			thread.setPriority(Thread.NORM_PRIORITY);
		}
		return thread;
	}
	
}
