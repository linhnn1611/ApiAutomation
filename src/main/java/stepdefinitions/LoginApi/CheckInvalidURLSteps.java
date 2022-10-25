package stepdefinitions.LoginApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidURLSteps {
	String url, method, message = " ";
	int code = 0;
	HttpResponse<String> response = null;

	@Given("I have URL and method")
	public void i_have_url_and_method(List<Map<String, String>> givenTable) {
		Map<String, String> row1 = givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("method");
	}

	@When("I send request and check status code and message in response3")
	public void i_send_request_and_check_status_code_and_message_in_response3() {
		ApiUtils apiUtils = new ApiUtils();
		apiUtils.sendRequest(url, message, method);
	}

	@Then("I validate status code and message3")
	public void i_validate_status_code_and_message3() {
		code = response.statusCode();
		message = response.toString();
		Assert.assertEquals(code, 401);
		Assert.assertEquals(message, "Not found");
	}

}
