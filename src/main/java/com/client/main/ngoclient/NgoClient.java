package com.client.main.ngoclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.client.constant.NgoMConstant;
import com.google.gson.Gson;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class NgoClient {
	private static NgoClient ngoClient;
	private HttpClient httpclient;
	private HttpPost post;
	private HttpGet get;
	private final String ngoServerServletUrl = "http://localhost:8080/ngo/NgoMainController";
	
	private NgoClient(){}
	private NgoClient(String requestMethodType) {
		httpclient = HttpClientBuilder.create().build();
		if(requestMethodType.equals("POST")){
		post = new HttpPost(ngoServerServletUrl);
		}else{
		get = new HttpGet(ngoServerServletUrl);	
		}
	}
	/**
	 * This method returns single instance of NgoClient class
	 * @param requestMethodType
	 * @return NgoClient
	 */
	public static NgoClient getInstance(NgoMConstant requestMethodType) {
		if (ngoClient == null) {
			synchronized (NgoClient.class) {
				if (ngoClient == null) {
					ngoClient = new NgoClient(requestMethodType.toString());
				}
			}
		}
		return ngoClient;
	}

	/**
	 * This method pushPost request to NgoMainController servlet on server
	 * with actionType (eg."Select","Insert") handlerName (eg. which handler to send request)
	 * Object (eg. Member, Emp obj which needs to be travelling on server side)
	 * @param actionType,hanlerName,Object
	 * @param handlerName
	 * @param serilizedObject
	 * @return HttpResponse
	 */
	public HttpResponse pushPostRequest(String actionType, String handlerName, Object serilizedObject) {
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		String convertedString = convertObjectToString(serilizedObject);
		urlParameters.add(new BasicNameValuePair("Obj", convertedString));
		HttpResponse response = null;
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			response = httpclient.execute(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * 
	 * @return HttpResponse
	 */
	public HttpResponse pushGetRequest(){
		// TODO To be implemented need basis.
		return null;
		
	}

	private String convertObjectToString(Object serilizedObject) {
		Gson gson = new Gson();
		String json = gson.toJson(serilizedObject);
		return json;
	}

}
