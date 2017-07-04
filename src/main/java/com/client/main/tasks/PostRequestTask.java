package com.client.main.tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

import org.apache.http.HttpResponse;

import com.client.constant.NgoMConstant;
import com.client.main.ngoclient.NgoClient;
/**
 * 
 * @author VISHWAS SINGH
 * @param <T>
 *
 */
public class PostRequestTask<T> implements Callable<T> {
	
	private String actionType;
	private String handlerName;
	private Object serilizedObject;
	
	public PostRequestTask(String actionType, String handlerName,Object serilizedObject){
		this.actionType = actionType;
		this.handlerName = handlerName;
		this.serilizedObject = serilizedObject;
	}
	
	public T call() throws Exception {
		NgoClient ngoClient = NgoClient.getInstance(NgoMConstant.POST);
		HttpResponse response = ngoClient.pushPostRequest(actionType, handlerName, serilizedObject);
		BufferedReader rd = new BufferedReader(
    	        new InputStreamReader(response.getEntity().getContent()));

    	StringBuffer result = new StringBuffer();
    	String line = "";
    	while ((line = rd.readLine()) != null) {
    		result.append(line);
    	}
		return (T) result.toString();
	}

}
