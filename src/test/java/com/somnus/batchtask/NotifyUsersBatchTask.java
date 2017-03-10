package com.somnus.batchtask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.sql.DataSource;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.lang3.StringUtils;

import com.somnus.batchtask.jmx.BatchTaskMonitor;
import com.somnus.batchtask.model.NotifyUsers;
import com.somnus.batchtask.parallel.BatchQueryLoader;
import com.somnus.batchtask.parallel.BatchTaskReactor;

/**
 * 
 * @ClassName:     NotifyUsersBatchTask.java
 * @Description:   通知用户批处理任务管理类
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 下午6:20:46
 */
public class NotifyUsersBatchTask {
	private ArrayList<DataSource> dataSource;
	//基于JMX的任务完成情况监控计数器
	private BatchTaskMonitor monitor = new BatchTaskMonitor(BatchTaskReactor.BATCHTASK_THREADPOOL_NAME);
	
	public NotifyUsersBatchTask(){
		
	}
	//支持同时加载多个数据源
	public NotifyUsersBatchTask(ArrayList<DataSource> dataSource){
		this.dataSource = dataSource;
	}
	
	//批处理任务执行成功计数器
	class NotifyTaskSuccCounter implements Closure<Object>{
		public static final String NOTIFYTASKSUCCCOUNTER = "TASKSUCCCOUNTER";
		
		private int numberSucc = 0;
		
		@Override
		public void execute(Object input) {
			monitor.increaseBatchTaskCounter(NOTIFYTASKSUCCCOUNTER);
			numberSucc++;
		}
		
		public int getSuccNumber(){
			return numberSucc;
		}
	}
	
	//批处理任务执行成功计数器
	class NotifyTaskFailCounter implements Closure<Object>{
		public static final String NOTIFYTASKFAILCOUNTER = "TASKFAILCOUNTER";
			
		private int numberFail = 0;
			
		@Override
		public void execute(Object input) {
			monitor.increaseBatchTaskCounter(NOTIFYTASKFAILCOUNTER);
			numberFail++;
		}
			
		public int getFailNumber(){
			return numberFail;
		}
	}
	
	public List<NotifyUsers> query() throws SQLException{
		BatchQueryLoader loader = new BatchQueryLoader();
		String srqSQL = "select home_city,msisdn,user_id from notify_users";
		for(int i = 0; i<dataSource.size();i++){
			Connection con = dataSource.get(i).getConnection();
			Statement st = con.createStatement();
			loader.attachLoadEnv(srqSQL, st, con);
		}
		List<ResultSet> list = loader.executeQuery();
		
		System.out.println("查询出记录总数为："+ list.size());
		
		final List<NotifyUsers> listNotifyUsers = new ArrayList<NotifyUsers>();
		for(int i = 0; i<list.size();i++){
			ResultSet rs = list.get(i);
			while(rs.next()){
				NotifyUsers users = new NotifyUsers();
				users.setHomeCity(rs.getInt(1));
				users.setMsisdn(rs.getInt(2));
				users.setUserId(rs.getInt(3));
			}
		}
		//释放资源
		loader.close();
		return listNotifyUsers;
	}
	
	public void batchNotify(List<NotifyUsers> list,final ExecutorService executor){
		System.out.println("批处理记录总数为："+list.size());
		System.out.println(StringUtils.center("记录明细如下", 40,"-"));
		
		NotifyTaskSuccCounter cntSucc = new NotifyTaskSuccCounter();
		NotifyTaskFailCounter cntFail = new NotifyTaskFailCounter();
		
		BatchTaskPredicate predicate = new BatchTaskPredicate(executor);
		Closure<Object> batchAction = new IfClosure<>(predicate, cntSucc,cntFail);
		IterableUtils.forEach(list, batchAction);
		System.out.println(String.format("批处理一共处理:[%s]记录，处理成功[%s]条记录，处理失败[%s]条记录", list.size(),cntSucc.getSuccNumber(),cntFail.getFailNumber()));
	}
}
