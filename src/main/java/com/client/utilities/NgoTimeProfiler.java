package com.client.utilities;

import org.apache.log4j.Logger;

import com.client.main.ngoclient.NgoManagementSystem;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class NgoTimeProfiler {
	
	private static long startTime;
	private static long endTime;
	final static Logger logger = Logger.getLogger(NgoTimeProfiler.class);
	
	/**
	 * This methods should be called where we want to start the timer to
	 * check total time taken by any service.
	 */
	public static void startTime(){
		startTime = System.currentTimeMillis();
	}
	
	public static void endTime(String msg){
		endTime = System.currentTimeMillis();
		long timeConsumed = endTime-startTime;
		logger.debug(msg+" "+timeConsumed+" ms.");
	}

}
