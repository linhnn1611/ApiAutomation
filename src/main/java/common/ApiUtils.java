package common;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiUtils {
	
	public HttpResponse<String> sendRequest(String url, String requestBody, String method){
		HttpResponse<String> response= null;
		if(method.equals("POST")) {
			sendPostRequest(url, requestBody);
		}
		return response;
	}
	
	private HttpResponse<String> sendPostRequest(String url, String requestBody){
		HttpResponse response= null;
		HttpRequest request= null;
		try {
			request = HttpRequest.newBuilder().header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBody)).uri(new URI(url)).build();

			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			System.out.println("Request is invalid");
			e.printStackTrace();
		}
		return response;
		
	}

}
