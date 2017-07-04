package com.client.utilities;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.client.main.ngoclient.NgoManagementSystem;
import com.client.main.tasks.NgoTaskExecutor;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class NgoProperty {
	private static Properties props;
	static{
		props = new Properties();
	}
	
	public static void loadNgoProperties(){
		Callable<String> propertyLoaderTask = new Callable<String>() {
			
			public String call() throws Exception {
				InputStream inputStream = NgoManagementSystem.class.getResourceAsStream("/ngoconfig.properties");
				props.load(inputStream);
				return null;
			}
		};
		Future future = NgoTaskExecutor.execute(propertyLoaderTask);
		try {
			if(future.get()!= null){
				return;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object getProperty(String key){
		return props.getProperty(key);
	}
	

}
