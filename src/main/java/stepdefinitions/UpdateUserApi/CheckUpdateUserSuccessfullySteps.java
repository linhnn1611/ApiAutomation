package stepdefinitions.UpdateUserApi;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import common.JsonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckUpdateUserSuccessfullySteps {
	String url, method, requestBody = " ";
	HttpResponse<String> response=null;
	ApiUtils apiUtils = new ApiUtils();
	@Given("I have url and method and request body")
	public void i_have_url_and_method_and_request_body(List<Map<String, String>> givenTable) {
		Map<String, String> row1 = givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("Method");
		String requestBodyName = row1.get("RequestBody");
		if (requestBodyName != " ") {
			requestBody = apiUtils.getRequestBodyByName(requestBodyName);
		}
	}
	@When("I send request2")
	public void i_send_request2() {
		response = apiUtils.sendRequest(url, requestBody, method);
	}


	@Then("I validate status code and message")
	public void i_validate_status_code_and_message() {
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 200);
		String responseBody = response.body();
		if (responseBody != " ") {
			JsonUtils jsonUtils = new JsonUtils();
			String actualName = jsonUtils.getValueByKey(responseBody, "name");
			System.out.println(actualName);
			Assert.assertEquals(actualName, "morpheus");
			String actualJob = jsonUtils.getValueByKey(responseBody, "job");
			System.out.println(actualJob);
			Assert.assertEquals(actualJob, "zion resident");
			String actualTime = jsonUtils.getValueByKey(responseBody, "updatedAt");
			System.out.println(actualTime);
			Assert.assertEquals(actualTime, actualTime);
		} else
			Assert.assertFalse(false);
	}

}
