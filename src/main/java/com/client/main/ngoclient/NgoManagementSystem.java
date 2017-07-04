package com.client.main.ngoclient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.client.main.tasks.NgoTaskExecutor;
import com.client.main.tasks.PostRequestTask;
import com.client.pojos.Emp;

/**
 * Hello world!
 *
 */
public class NgoManagementSystem 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
    	Emp emp = new Emp();
    	emp.setId(1);
    	emp.setEmpName("Test");
    	PostRequestTask<String> task = new PostRequestTask<String>("", "", emp);
    	Future<String> futu = NgoTaskExecutor.execute(task);
    	System.out.println(futu.get());
    }
    
   
}

