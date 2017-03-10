package com.somnus.batchtask.jmx;

import java.lang.management.ManagementFactory;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.management.AttributeChangeNotification;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;

/**
 * 
 * @ClassName:     BatchTaskMonitor.java
 * @Description:   JMX批处理任务监控模块
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月2日 上午9:57:19
 */
public class BatchTaskMonitor extends NotificationBroadcasterSupport implements BatchTaskMonitorBean{

	private static final String TASKMONITOR_NAME = "somnus.batchtask.jmx.{0}:type=BatchTaskMonitor";
	
	private Map<String,AtomicInteger> batchTaskCounter;
	
	private int sequenceTaskNumber = 0;
	
	public BatchTaskMonitor(String taskName){
		batchTaskCounter = new HashMap<String, AtomicInteger>();
		try {
			registerMBean(taskName);
		} catch (InstanceAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MBeanRegistrationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotCompliantMBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void registerMBean(String taskName) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException{
		String strObjectName = MessageFormat.format(TASKMONITOR_NAME, taskName);
		ManagementFactory.getPlatformMBeanServer().registerMBean(this, new ObjectName(strObjectName));
	}
	
	//批处理任务计数器递增
	public void increaseBatchTaskCounter(String taskName){
		if(batchTaskCounter.containsKey(taskName)){
			notifyMessage(taskName,batchTaskCounter.get(taskName).incrementAndGet());
		} else{
			batchTaskCounter.put(taskName, new AtomicInteger(1));
		}
	}
	
	private void notifyMessage(String taskName, int batchNewTaskCounter){
		sendNotification(new AttributeChangeNotification(this, 
				sequenceTaskNumber++, System.currentTimeMillis(), 
				"batchTaskCounter \"" + taskName + "\" incremented", 
				"batchTaskCounter", "int", 
				batchNewTaskCounter-1, 
				batchNewTaskCounter));
	}
	
	@Override
	public int getBatchTaskCounter(String taskName) {
		if(batchTaskCounter.containsKey(taskName)){
			return batchTaskCounter.get(taskName).intValue();
		} else{
			return 0;
		}
	}
	
}
