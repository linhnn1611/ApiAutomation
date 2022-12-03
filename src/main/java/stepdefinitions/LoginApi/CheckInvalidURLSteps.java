package stepdefinitions.LoginApi;


import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidURLSteps {
	String url, method, message, requestBody = " ";
	int code = 0;
	HttpResponse<String> response = null;
	ApiUtils apiUtils = new ApiUtils();

	@Given("I have URL and method and Request Body")
	public void i_have_url_and_method_and_request_body(List<Map<String, String>> givenTable) {
		Map<String, String> row1 = givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("method");
		String requestBodyName = row1.get("RequestBodyName");
		if (requestBodyName != " ") {
			requestBody = apiUtils.getRequestBodyByName(requestBodyName);
		} 	else requestBody.isBlank();
		}

	@When("I send request and check status code and message in response3")
	public void i_send_request_and_check_status_code_and_message_in_response3() {
		response = apiUtils.sendRequest(url, requestBody, method);
		System.out.println("Linh"+response);
	}

	@Then("I validate status code and message3")
	public void i_validate_status_code_and_message3() {
		code = response.statusCode();
		message = response.toString();
		Assert.assertEquals(code, 404);
		Assert.assertEquals(message, "Not found"); 
	}

}
