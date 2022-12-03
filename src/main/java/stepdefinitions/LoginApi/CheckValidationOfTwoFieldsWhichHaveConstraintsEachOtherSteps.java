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
import common.JsonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckValidationOfTwoFieldsWhichHaveConstraintsEachOtherSteps {
	String url, method, requestBodyName = null;
	HttpResponse<String> response=null;
	JsonUtils jsonUtils = new JsonUtils(); 

	@Given("I have URL and method4 and RequestBodyName")
	public void i_have_url_and_method4_and_request_body_name(List<Map<String, String>> givenTable) {
		Map<String, String> row1=givenTable.get(0);
		url= row1.get("URL");
		method= row1.get("method4");
		requestBodyName = row1.get("RequestBodyName");
		if (requestBodyName != " ") {
			requestBodyName = jsonUtils.getRequestBodyByName(requestBodyName);
		}
	}

	@When("I send valid login request with {string} and {string} and {string} and {string}")
	public void i_send_valid_login_request_with_and_and_and(String string, String string2, String string3, String string4) {
	   
	}

	@Then("Check response return {string} and {string}")
	public void check_response_return_and(String string, String string2) {
	   
	}

}
