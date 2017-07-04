package com.client.main.tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.client.utilities.NgoTimeProfiler;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class NgoTaskExecutor{
	
	private static ThreadPoolExecutor taskExecutor;
	static{
		taskExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public static <T> Future execute(PostRequestTask<T> postRequestTask ){
		Future futureObject = taskExecutor.submit(postRequestTask);
		return futureObject;
		
	}
	
	public static <V> Future execute(Callable<V> task){
		Future<V> future = taskExecutor.submit(task);
		return future;
	}
	
	public static void shutdownNgoTaskEexecutor(){
		taskExecutor.shutdown();
	}

}
