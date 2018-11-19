package com.tianbao.points.core.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HttpUtil {
	private static String ENCODING = "UTF-8";
	
	
	public static String sendGet(String url) throws HttpException, IOException{
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		HttpMethodParams param = method.getParams();
		param.setContentCharset(ENCODING);
		client.executeMethod(method);
		return method.getResponseBodyAsString();
	}
	
	public static String sendPost(String url,Map<String,String> map) throws IOException{
		HttpClient client = new HttpClient();
		NameValuePair[] nameValuePairs = new NameValuePair[map.size()];
		int i = 0;
		for (String key : map.keySet()) { 
			  String value = map.get(key);
			  nameValuePairs[i] = new NameValuePair(key, value);
			  i++;
		} 
		PostMethod method = new PostMethod(url);
		method.setRequestBody(nameValuePairs);
		HttpMethodParams param = method.getParams();
		param.setContentCharset(ENCODING);
		client.executeMethod(method);
		String result = method.getResponseBodyAsString();
		return result;
	}
	
	public static void main(String[] args) {
		Map<String,String> p = new HashMap<>();
		p.put("abc", "123");
		p.put("bdd", "ccc");
		String packUrlByParam = packUrlByParam("www.baidu.com", p);
		System.out.println(packUrlByParam);
	}
	
	public static String packUrlByParam(String url,Map<String,String> map){
		int i = 0;
		for (String key : map.keySet()) { 
			  String value = map.get(key);
			  url += i==0?"?":"&";
			  url += key+"="+value;
			  i++;
		} 
		return url;
	}
	

	
	
}                           