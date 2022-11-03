package stepdefinitions.LoginApi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import gherkin.deps.net.iharder.Base64.InputStream;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidMethodSteps {
	String url, method = " ";
	int code=0;
	String message = null; 
	HttpResponse<String> response = null;
	@Given("I have URL and method2")
	public void i_have_url_and_method2(List<Map<String, String>> givenTable) {
		Map<String, String> row1=givenTable.get(0);
		url=row1.get("URL");
		method=row1.get("method2");
	}

	@When("I send request and check status code and message in response2")
	public void i_send_request_and_check_status_code_and_message_in_response2() {
		ApiUtils apiUtils= new ApiUtils();
		response = apiUtils.sendRequest(url, message, method);
	}

	@Then("I validate status code and message2")
	public void i_validate_status_code_and_message2() {
		code = response.statusCode();
		message = response.toString();
		Assert.assertEquals(code, 405);
		Assert.assertEquals(message, "Invalid Method");
	}

}
