package common;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiUtils {
	HttpResponse response = null;
	HttpRequest request = null;

	public HttpResponse<String> sendRequest(String url, String requestBody, String method) {
		HttpResponse<String> response = null;
		if (method.equals("POST")) {
			sendPostRequest(url, requestBody);
		} else if (method.equals("GET")) {
			sendGetRequest(url);
		}
		return response;
	}

	private void sendGetRequest(String url) {
		request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private HttpResponse<String> sendPostRequest(String url, String requestBody) {
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
