package com.somnus.batchtask.parallel;

/**
 * 
 * @ClassName:     BatchQueryInterruptedException.java
 * @Description:   并行查询加载InterruptedException异常类
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年2月28日 下午5:49:36
 */
public class BatchQueryExecutionException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BatchQueryExecutionException(final String errorMessage, final Object... args){
		super(String.format(errorMessage, args));
	}
	
	public BatchQueryExecutionException(Exception cause){
		super(cause);
	}
}
