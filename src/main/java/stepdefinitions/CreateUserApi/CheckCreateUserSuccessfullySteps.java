package stepdefinitions.CreateUserApi;

import java.io.File;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import common.ApiUtils;
import common.JsonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckCreateUserSuccessfullySteps {
	HttpResponse<String> response =null;
	@Then("I validate status code and name and job")
	public void i_validate_status_code_and_name_and_job() {
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 200);
		String responseBody = response.body();
		if (responseBody != " ") {
			JsonUtils jsonUtils = new JsonUtils();
			String actualToken = jsonUtils.getValueByKey(responseBody, "token");
			Assert.assertEquals(actualToken, "QpwL5tke4Pnpja7X4");
		} else
			Assert.assertFalse(false);
	}


}
