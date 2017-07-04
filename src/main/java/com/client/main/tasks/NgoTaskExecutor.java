package com.client.main.tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

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
	
	public static void shutdownNgoTaskEexecutor(){
		taskExecutor.shutdown();
	}

}
