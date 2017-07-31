package com.client.main.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.apache.http.HttpResponse;

import com.client.constant.NgoMConstant;
import com.client.main.ngoclient.NgoClient;
import com.client.main.tasks.NgoTaskExecutor;
import com.client.main.tasks.PostSessionRequestTask;
import com.client.session.Session;

public class MainFrame extends JFrame {
	Session session = null;
	public MainFrame(){
		init();
	}
	
	private void init(){
		this.setSize(600, 600);
		this.setTitle("Test");
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		JButton b = new JButton("SUBMIT");
		JTextField tx = new JTextField(20);
		this.setLayout(new FlowLayout());
		this.add(tx);
		this.add(b);
		this.setVisible(true);
		session = Session.getInstance();
		session.setUserName("Vishwas");
		session.startSession();
		System.out.println("HashCode "+session.hashCode());
		NgoTaskExecutor.execute(new Callable() {

			public Object call() throws Exception {
				HttpResponse response = NgoClient.getInstance(NgoMConstant.POST).pushPostRequestForSessionInitial(session);
				BufferedReader rd = new BufferedReader(
		    	        new InputStreamReader(response.getEntity().getContent()));

		    	StringBuffer result = new StringBuffer();
		    	String line = "";
		    	while ((line = rd.readLine()) != null) {
		    		result.append(line);
		    	}
				return  result.toString();
			}
		});
		b.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				performAction();
				
			}
		});
	}
	
	private void performAction(){
		session.stopSession();
		NgoTaskExecutor.execute(new PostSessionRequestTask(session));
	}

}
