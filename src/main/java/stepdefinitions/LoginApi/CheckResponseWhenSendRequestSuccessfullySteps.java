package stepdefinitions.LoginApi;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseWhenSendRequestSuccessfullySteps {
	String requestBody = null;
	String url = null;
	HttpResponse <String> reponse = null;
	@Given("I have URL and method and Request body file name")
	public void i_have_url_and_method_and_request_body_file_name() {
		url = "https://reqres.in/api/login";
		String method = "POST";
		requestBody = "{\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\n"
				+ "    \"password\": \"cityslicka\"\n"
				+ "}";
		
	}

	@When("I send request")
	public void i_send_request() {
		HttpRequest request;
		try {
			request = HttpRequest.newBuilder()
					.POST(HttpRequest.BodyPublishers.ofString(requestBody))
					.uri(new URI(url))
					.build();
			
				HttpResponse <String> reponse = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			} catch (Exception e) {
			
			System.out.println("Request is invalid");
			e.printStackTrace();
		}
		
	}

	@Then("I validate status code and token")
	public void i_validate_status_code_and_token() {
		int actualStatusCode = reponse.statusCode();
		Assert.assertEquals(actualStatusCode, 200);
	}
}
