package com.client.main.ngoclient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.client.main.tasks.NgoTaskExecutor;
import com.client.main.tasks.PostRequestTask;
import com.client.pojos.Emp;
import com.client.utilities.NgoProperty;

/**
 * Hello world!
 *
 */
public class NgoManagementSystem 
{
	final static Logger logger = Logger.getLogger(NgoManagementSystem.class);
	
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {	
    	//Loading application properties once application loads.
    	logger.info("Ngo Managment System initializing...");
    	logger.info("Initializing ngoconfig.properties");
    	NgoProperty.loadNgoProperties();
    	Emp emp = new Emp();
    	emp.setId(1);
    	emp.setEmpName("Test");
    	PostRequestTask<String> task = new PostRequestTask<String>("", "", emp);
    	Future<String> futu = NgoTaskExecutor.execute(task);
    	logger.info("Response from server "+futu.get());
    }
    
   
}

