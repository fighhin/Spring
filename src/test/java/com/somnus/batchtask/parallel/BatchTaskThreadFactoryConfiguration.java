package com.somnus.batchtask.parallel;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName:     BatchTaskThreadFactoryConfiguration.java
 * @Description:   线程池参数配置工厂
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 上午11:13:34
 */
public class BatchTaskThreadFactoryConfiguration {
	private Map<String,BatchTaskConfiguration> batchTaskMap = new HashMap<String,BatchTaskConfiguration>();
	
	public void joinBatchTaskConfiguration(BatchTaskConfiguration batchTaskConfiguration){
		if(batchTaskMap.containsKey(batchTaskConfiguration.getName())){
			return;
		}else{
			batchTaskMap.put(batchTaskConfiguration.getName(),batchTaskConfiguration);
		}
	}

	public Map<String, BatchTaskConfiguration> getBatchTaskMap() {
		return batchTaskMap;
	}
	
}
