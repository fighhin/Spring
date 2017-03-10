package com.somnus.batchtask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.Predicate;

import com.somnus.batchtask.model.HlrBusinessEvent;
import com.somnus.batchtask.model.HlrBusinessEventTask;
import com.somnus.batchtask.model.NotifyUsers;

/**
 * 
 * @ClassName:     BatchTaskPredicate.java
 * @Description:   批处理异步任务提交执行任务模块
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月2日 上午10:40:30
 */
public class BatchTaskPredicate implements Predicate<Object>{
	private ExecutorService excutor = null;

	public BatchTaskPredicate(ExecutorService excutor) {
		super();
		this.excutor = excutor;
	}

	@Override
	public boolean evaluate(Object object) {
		if(object instanceof NotifyUsers){
			NotifyUsers users = (NotifyUsers)object;
			Future<Integer> future = excutor.submit(new HlrBusinessEventTask(users));
			
			try {
				Integer result = future.get(5, TimeUnit.SECONDS);
				return result.intValue() == HlrBusinessEvent.TASKSUCC;
			} catch (Exception e) {
				//如果失败试图取消对此任务的执行
				future.cancel(true);
				e.printStackTrace();
				return false;
			}
		} else{
			return false;
		}
	}
	
	
}
