package stepdefinitions.LoginApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidURLSteps {
	String url = null;
	int code=0;
	String message = null; 
	@Given("I have URL and method3")
	public void i_have_url_and_method3() {
		url = "https://reqres.in/api111/login1";
		String method = "GET";
	}

	@When("I send request and check status code and message in response3")
	public void i_send_request_and_check_status_code_and_message_in_response3() {
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

	@Then("I validate status code and message3")
	public void i_validate_status_code_and_message3() {
		Assert.assertEquals(code, 401);
		Assert.assertEquals(message, "Not found");
	}

}
