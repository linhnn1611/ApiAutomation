package stepdefinitions.LoginApi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.testng.Assert;

import gherkin.deps.net.iharder.Base64.InputStream;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidMethodSteps {
	String url = null;
	int code=0;
	String message = null; 
	@Given("I have URL and method2")
	public void i_have_url_and_method2() {
		url = "https://reqres.in/api/login";
		String method = "GET";
	}

	@When("I send request and check status code and message in response2")
	public void i_send_request_and_check_status_code_and_message_in_response2() {
		HttpRequest request = HttpRequest.newBuilder()
				.GET().uri(URI.create(url))
				.build();
		HttpResponse<String> response = null;
		try {
		response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		code = response.statusCode();
		message = response.toString();
	}

	@Then("I validate status code and message2")
	public void i_validate_status_code_and_message2() {
		Assert.assertEquals(code, 405);
		Assert.assertEquals(message, "Invalid Method");
	}

}
