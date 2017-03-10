package com.somnus.batchtask.parallel;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.functors.ForClosure;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
/**
 * 
 * @ClassName:     BatchQueryExecutor.java
 * @Description:   异步并行查询执行器
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 上午10:06:13
 */
public class BatchQueryExecutor {
	
	private final static int FUTUREQUERYNUMBER = 1;
	
	public BatchQueryExecutor(){}
	
	public <IN,OUT> List<OUT> executeQuery(final Collection<IN> inputs,final BatchQuery<IN,OUT> executeUnit){
		
		ListenableFuture<List<OUT>> futures = submitBatchTaskFutures(inputs,executeUnit);
		
		delegateAsynTask(futures);
		
		return getAsynResults(futures);
	}
	
	private <IN,OUT> ListenableFuture<List<OUT>> submitBatchTaskFutures(final Collection<IN> inputs,
			final BatchQuery<IN,OUT> executeUnit){
		
		final Set<ListenableFuture<OUT>> result = new HashSet<ListenableFuture<OUT>>(inputs.size());
		
		final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(inputs.size()));
		
		Closure futureQuery = new Closure(){
			@Override
			public void execute(Object input) {
				final IN p = (IN)input;
				result.add(service.submit(new Callable<OUT>(){
					@Override
					public OUT call() throws Exception {
						return executeUnit.query(p);
					}
				}));
			}
		};
		Closure parallelTask = new ForClosure(FUTUREQUERYNUMBER, futureQuery);
		
		CollectionUtils.forAllDo(inputs, parallelTask);
		
		service.shutdown();
		
		return Futures.allAsList(result);
	}
	
	private <OUT> OUT getAsynResults(final ListenableFuture<OUT> futures){
		try {
			return futures.get();
		} catch (InterruptedException e) {
			throw new BatchQueryInterruptedException(e);
		} catch(ExecutionException e){
			throw new BatchQueryExecutionException(e);
		}
	}
	
	private <TYPE> void delegateAsynTask(final ListenableFuture<TYPE> allFutures){
		Futures.addCallback(allFutures, new FutureCallback<TYPE>() {

			@Override
			public void onSuccess(final TYPE result) {
				System.out.println("并行加载查询执行成功");
			}
			
			@Override
			public void onFailure(final Throwable thrown) {
				System.out.println("并行加载查询执行失败");
			}
			
		});
	}
	
}
