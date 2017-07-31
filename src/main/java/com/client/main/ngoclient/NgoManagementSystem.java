package com.client.main.ngoclient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.client.main.tasks.NgoTaskExecutor;
import com.client.main.tasks.PostRequestTask;
import com.client.main.ui.AdminLogin;
import com.client.main.ui.MainFrame;
import com.client.pojos.Member;
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
    	SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new AdminLogin();
			}
		});
    	/*Below code is for testing the flow purpose it can be followed in some 
    	other user case as well*/
    	/*Member member = new Member();
        member.setName("Vishwas Pratap");
        member.setUpdatedBy("V3");
        member.setEmail("vp.msdos@gmail.com");
        member.setAddress("lucknow");
        member.setMemberType("Permanent");
        String[] objectPathArray = member.getClass().getName().split("\\.");
        String objectName = objectPathArray[objectPathArray.length-1];
    	PostRequestTask<String> task = new PostRequestTask<String>("INSERT", objectName, member);
    	Future<String> futu = NgoTaskExecutor.execute(task);
    	logger.info("Response from server "+futu.get());*/
    }
    
   
}

