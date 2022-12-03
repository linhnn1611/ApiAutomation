package stepdefinitions.CreateUserApi;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import common.JsonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckCreateUserSuccessfullySteps {
	HttpResponse<String> response =null;
	String url, method, requestBodyName="";
	ApiUtils apiUtils = new ApiUtils();
	JsonUtils jsonUtils = new JsonUtils();

	@Given("I have login with URL and method and RequestBodyName")
	public void i_have_login_with_url_and_method_and_request_body_name(List<Map<String, String>> givenTable) {
		Map<String, String> row1 = givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("method");
		requestBodyName=row1.get("RequestBodyName");
		if (requestBodyName != " ") {
			requestBodyName = jsonUtils.getRequestBodyByName(requestBodyName);
		}
	}

	@When("I send with request")
	public void i_send_with_request() {
		response = apiUtils.sendRequest(url, requestBodyName, method);
	}

	@Then("I need validate status code and name and job")
	public void i_need_validate_status_code_and_name_and_job() {
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 201);
		String responseBody = response.body();
		if (responseBody != "") {
			JsonUtils jsonUtils = new JsonUtils();
			String actualName = jsonUtils.getValueByKey(responseBody, "name");
			Assert.assertEquals(actualName, "morpheus");
			String actualJob = jsonUtils.getValueByKey(responseBody, "job");
			Assert.assertEquals(actualJob, "leader");
		} else
			Assert.assertFalse(false);
	}
}
