package com.somnus.batchtask;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somnus.ApplicationContextHolder;
import com.somnus.batchtask.model.NotifyUsers;
import com.somnus.batchtask.parallel.BatchTaskReactor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
public class BatchTaskTest{
	
	@Test
	public void execute(){
		try {
			//初始化并行异步任务执行反应器
			BatchTaskReactor reactor = BatchTaskReactor.getReactor();
			final ExecutorService executor = reactor.getBatchTaskThreadPool(BatchTaskReactor.BATCHTASK_THREADPOOL_NAME);
			List<NotifyUsers> listNotifyUsers = null;
			
			NotifyUsersBatchTask notifyTask = (NotifyUsersBatchTask) ApplicationContextHolder.getBean("notifyUsers");
			//并行查询水平分裤的结果
			listNotifyUsers = notifyTask.query();
			
			StopWatch sw = new StopWatch();
			sw.start();
			//并行异步批处理查询结果集合
			notifyTask.batchNotify(listNotifyUsers, executor);
			sw.stop();
			reactor.close();
			System.out.println(String.format("========批处理并行任务结束，耗时[%d]毫秒========", sw.getTime()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
