package com.somnus.batchtask.parallel;

/**
 * 
 * @ClassName:     BatchQuery.java
 * @Description:   异步查询接口定义
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年2月28日 下午6:56:15
 */
public interface BatchQuery<IN,OUT>{
	OUT query(IN input) throws Exception;
}
