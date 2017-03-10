package com.somnus.batchtask.parallel;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * @ClassName:     BatchTaskReactor.java
 * @Description:   批处理并行异步线程池处理模块
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 下午4:39:29
 */
public class BatchTaskReactor {
	
	private Map<String,ExecutorService> threadPools = new ConcurrentHashMap<String,ExecutorService>();
	
	private static BatchTaskReactor context;
	
	private static Lock REACTORLOCK = new ReentrantLock();
	
	public static final String BATCHTASK_THREADPOOL_NAME = "somnus_batchtask";
	
	private BatchTaskReactor(){
		initialize();
	}
	
	/** 防止并发重复创建批处理反应器对象*/
	public static BatchTaskReactor getReactor(){
		if(context == null){
			try{
				REACTORLOCK.lock();
				if(context == null){
					context = new BatchTaskReactor();
				}
			} finally{
				REACTORLOCK.unlock();
			}
		}
		return context;
	}
	
	public ExecutorService getBatchTaskThreadPoolName(){
		return getBatchTaskThreadPool(BATCHTASK_THREADPOOL_NAME);
	}
	
	public ExecutorService getBatchTaskThreadPool(String poolName){
		if(!threadPools.containsKey(poolName)){
			throw new IllegalArgumentException(String.format("批处理线程池名称：[%s]参数配置不存在", poolName));
		}
		return threadPools.get(poolName);
	}
	
	public Set<String> getBatchTaskThreadPoolNames(){
		return threadPools.keySet();
	}
	
	/** 关闭线程池，同时等待异步执行的任务返回执行结果*/
	public void close(){
		for(Entry<String,ExecutorService> entry : threadPools.entrySet()){
			entry.getValue().shutdown();
			System.out.println(String.format("关闭批处理线程池：[%s]成功", entry.getKey()));
		}
		threadPools.clear();
	}
	
	public void initialize(){
		BatchTaskThreadFactoryConfiguration poolFactoryConfig = BatchTaskConfigurationLoader.getConfig();
		if(poolFactoryConfig != null){
			initThreadPool(poolFactoryConfig);
		}
	}
	
	private void initThreadPool(BatchTaskThreadFactoryConfiguration poolFactoryConfig){
		for(Entry<String,BatchTaskConfiguration> entry:poolFactoryConfig.getBatchTaskMap().entrySet()){
			
			BatchTaskConfiguration config = entry.getValue();
			
			//使用有界的阻塞队列，考虑为了防止生产者无休止的请求服务器，导致内存崩溃，最终做到内存使用可控
			BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(config.getWorkQueueSize());
			
			ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
					config.getCorePoolSize(),config.getMaxPoolSize(),
					config.getKeepAliveTime(),TimeUnit.SECONDS,queue,
					new BatchTaskThreadFactory(entry.getKey()),
					new ThreadPoolExecutor.CallerRunsPolicy());
			
			threadPools.put(entry.getKey(), threadPool);
			
			System.out.println(String.format("批处理线程池:[%s]创建成功", config.toString()));
		}
	}
}
