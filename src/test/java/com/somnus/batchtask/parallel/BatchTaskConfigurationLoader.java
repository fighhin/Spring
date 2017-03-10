package com.somnus.batchtask.parallel;

import java.io.InputStream;

import org.apache.commons.digester.Digester;

/**
 * 
 * @ClassName:     BatchTaskConfigurationLoader.java
 * @Description:   线程池参数配置加载
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 上午11:29:40
 */
public class BatchTaskConfigurationLoader {
	private static final String BATCHTASK_THREADPOOL_CONFIG = "./batchtask-configuration.xml";
	
	private static BatchTaskThreadFactoryConfiguration config = null;
	
	private BatchTaskConfigurationLoader(){
		
	}
	
	/** 单例模式为了控制并发要进行同步控制*/
	public static BatchTaskThreadFactoryConfiguration getConfig(){
		if(config == null){
			synchronized (BATCHTASK_THREADPOOL_CONFIG) {
				if(config == null){
					try{
						InputStream is = getInputStream();
						config = (BatchTaskThreadFactoryConfiguration) getDigester().parse(is);
					} catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		return config;
	}
	
	private static InputStream getInputStream(){
		return BatchTaskConfigurationLoader.class.getClassLoader().
				getResourceAsStream(BATCHTASK_THREADPOOL_CONFIG);
	}
	
	private static Digester getDigester(){
		Digester digester = new Digester();
		digester.setValidating(false);
		digester.addObjectCreate("batchtask", BatchTaskThreadFactoryConfiguration.class);
		//加载批处理异步批处理线程池参数配置
		digester.addObjectCreate("*/jobpool", BatchTaskConfigurationLoader.class);
		digester.addSetProperties("*/jobpool");
		digester.addSetProperties("*/jobpool/attribute","name","value");
		digester.addSetNext("*/jobpool", "joinBatchConfiguration");
		return digester;
	}
			
}
