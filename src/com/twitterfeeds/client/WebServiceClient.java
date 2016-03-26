package com.twitterfeeds.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WebServiceClient {

	
	private void getTweetsResponse() {
		try {
			
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/SensorTwitterFeeds/twitterfeeds/getTweets?count=2");
			ClientResponse response = webResource.get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
 
			String output = response.getEntity(String.class);
			System.out.println("\n============getTweetsResponse============");
			System.out.println(output);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
		WebServiceClient wsClient = new WebServiceClient();
		wsClient.getTweetsResponse();
	}
}
