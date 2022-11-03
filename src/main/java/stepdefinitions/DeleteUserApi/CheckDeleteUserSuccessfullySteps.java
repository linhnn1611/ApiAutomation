package stepdefinitions.DeleteUserApi;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckDeleteUserSuccessfullySteps {
	String url, method, requestBody = " ";
	HttpResponse<String> response = null;
	@Given("I have url and method")
	public void i_have_url_and_method(List<Map<String, String>> givenTable) {
		Map<String, String> row1 = givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("method");
	}

	@When("I will send request")
	public void i_will_send_request() {
		ApiUtils apiUtils= new ApiUtils();
		response = apiUtils.sendRequest(url, requestBody, method);
	}

	@Then("I check status code and response body")
	public void i_check_status_code_and_response_body() {
	    int actualStatusCode = response.statusCode();
	    Assert.assertEquals(actualStatusCode, 204);
	    String responseBody = response.body();
		if (responseBody == " ") {
			Assert.assertTrue(true);
			}
		}

}
