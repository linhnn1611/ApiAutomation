package common;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiUtils {
	public HttpResponse<String> sendRequest(String url, String requestBody, String method) {
		HttpResponse<String> response = null;
		if (method.equals("POST")) {
			response=sendPostRequest(url, requestBody);
		} else if (method.equals("GET")) {
			response= sendGetRequest(url);
		} else if (method.equals("PUT")) {
			response= sendPutRequest(url, requestBody);
		} else if (method.equals("DELETE")) {
			response= sendDeleteRequest(url);
		}
		return response;
	}

	private HttpResponse<String> sendGetRequest(String url) {
		HttpResponse <String> response = null;
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return response;

	}

	private HttpResponse<String> sendPostRequest(String url, String requestBody) {
		HttpResponse <String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBody)).uri(new URI(url)).build();

			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			System.out.println("Request is invalid");
			e.printStackTrace();
		}
		return response;

	}
	private HttpResponse<String> sendPutRequest(String url, String requestBody) {
		HttpResponse <String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().header("Content-Type", "application/json")
					.PUT(HttpRequest.BodyPublishers.ofString(requestBody)).uri(new URI(url)).build();

			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			System.out.println("Request is invalid");
			e.printStackTrace();
		}
		return response;

	}
	private HttpResponse<String> sendDeleteRequest(String url) {
		HttpResponse <String> response = null;
		HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create(url)).build();
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return response;

	}
	
	public String getRequestBodyByName(String requestBodyName) {
		String requestBody=" ";
		String filePath = System.getProperty("user.dir") + "/src/main/resources/" + requestBodyName;
		try {
			File file = new File(filePath);
			if (file.exists()) {
				requestBody = new String(Files.readAllBytes(Paths.get(filePath)));
			}
		} catch (Exception e) {
		}
		System.out.println("file Path" + filePath);
		System.out.println("requestBody" + requestBody);
		return requestBody;
	}
		
}
