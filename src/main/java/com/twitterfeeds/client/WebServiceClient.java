package com.twitterfeeds.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Properties;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WebServiceClient {
	
	@SuppressWarnings("serial")
	public Client getClientWithAuthenticationKeys() {
		Properties properties = new Properties();
		String propertiesFile = "AuthenticationKeys.properties";
		InputStream inputStream = WebServiceClient.class.
				getClassLoader().getResourceAsStream(propertiesFile);
		Client client = Client.create();
		try {
			properties.load(inputStream);
			HashMap<String,String> hm = new HashMap<String,String>(){
				{
				put("consumerKey", properties.getProperty("consumerKey"));
				put("consumerSecretKey", properties.getProperty("consumerSecretKey"));
				put("accessTokenKey", properties.getProperty("accessTokenKey"));
				put("accessTokenSecretKey", properties.getProperty("accessTokenSecretKey"));
			}
		};
			client.getProperties().putAll(hm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return client;
	}
	
	//Get Tweets
	private void getTweetsResponse(int count) {
		try {
			Client client = getClientWithAuthenticationKeys();
			MultivaluedMap<String, String> keys = new MultivaluedHashMap<String, String>();
			keys.add("consumerKey", client.getProperties().get("consumerKey").toString());
			keys.add("consumerSecretKey", client.getProperties().get("consumerSecretKey").toString());
			keys.add("accessTokenKey", client.getProperties().get("accessTokenKey").toString());
			keys.add("accessTokenSecretKey", client.getProperties().get("accessTokenSecretKey").toString());
			
			WebResource webResource = client.resource("http://localhost:8080/SensorTwitterFeeds/twitterfeeds/getTweets?count=2").queryParams(keys);
			ClientResponse response = webResource.get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
 
			String output = response.getEntity(String.class);
			System.out.println("\n============Get Tweets Response============");
			System.out.println(output);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Search Tweets
	private void searchTweetsResponse(String searchText, int count) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/SensorTwitterFeeds/twitterfeeds/searchTweets?query=" + searchText + "&count=" + count);
			ClientResponse response = webResource.get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("\n============Saerch Tweets Response============");
			System.out.println(output);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Post Tweet
	private void postTweetResponse(String status) {
			try {
				Client client = Client.create();
				WebResource webResource = client.resource("http://localhost:8080/SensorTwitterFeeds/twitterfeeds/postTweet?text="+ URLEncoder.encode(status, "UTF-8"));
				ClientResponse response = webResource.get(ClientResponse.class);
				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
				}
				String output = response.getEntity(String.class);
				System.out.println("\n============Post Tweets Response============");
				System.out.println(output);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	public static void main(String[] args) {
		WebServiceClient wsClient = new WebServiceClient();
		wsClient.getTweetsResponse(5);
		wsClient.searchTweetsResponse("FAN", 10);
		wsClient.postTweetResponse("Test tweet from client project");
	}
}
