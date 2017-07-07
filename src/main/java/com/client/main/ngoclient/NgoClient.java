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
import com.client.session.Session;
import com.client.utilities.NgoProperty;
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
	
	private NgoClient(){}
	private NgoClient(String requestMethodType) {
		httpclient = HttpClientBuilder.create().build();
		if(requestMethodType.equals("POST")){
		post = new HttpPost(NgoProperty.getProperty("ngoMainControllerServletUrl").toString());
		}else{
		get = new HttpGet(NgoProperty.getProperty("ngoMainControllerServletUrl").toString());	
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
		urlParameters.add(new BasicNameValuePair(NgoMConstant.ACTION_TYPE.toString(), actionType));
		urlParameters.add(new BasicNameValuePair(NgoMConstant.OBJECT_NAME.toString(), handlerName));
		urlParameters.add(new BasicNameValuePair(NgoMConstant.OBJ.toString(), convertedString));
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
		
		return null;
		
	}
	
	public HttpResponse pushPostRequestForSession(Session session){
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		HttpResponse response = null;
		urlParameters.add(new BasicNameValuePair(NgoMConstant.STOP.toString(), NgoMConstant.STOP.toString()));
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			response = httpclient.execute(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public HttpResponse pushPostRequestForSessionInitial(Session session){
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		HttpResponse response = null;
		String convertedString = convertObjectToString(session);
		urlParameters.add(new BasicNameValuePair(NgoMConstant.SESSION.toString(), convertedString));
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			response = httpclient.execute(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	private String convertObjectToString(Object serilizedObject) {
		Gson gson = new Gson();
		String json = gson.toJson(serilizedObject);
		return json;
	}

}
