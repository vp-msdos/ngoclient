package com.client.main.tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

import org.apache.http.HttpResponse;

import com.client.constant.NgoMConstant;
import com.client.main.ngoclient.NgoClient;
import com.client.session.Session;

/**
 * 
 * @author VISHWAS SINGH
 * @param <V>
 *
 */
public class PostSessionRequestTask<V> implements Callable<V>{
	private Session session = null;
	public PostSessionRequestTask(Session session){
		this.session = session;
	}

	public V call() throws Exception {
		NgoClient ngoClient = NgoClient.getInstance(NgoMConstant.POST);
		HttpResponse response = ngoClient.pushPostRequestForSession(session);
		BufferedReader rd = new BufferedReader(
    	        new InputStreamReader(response.getEntity().getContent()));

    	StringBuffer result = new StringBuffer();
    	String line = "";
    	while ((line = rd.readLine()) != null) {
    		result.append(line);
    	}
		return (V) result.toString();
	}

}
