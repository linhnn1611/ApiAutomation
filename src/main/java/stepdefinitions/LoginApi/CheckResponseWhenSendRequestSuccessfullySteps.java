package stepdefinitions.LoginApi;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.w3c.dom.UserDataHandler;

import common.ApiUtils;
import common.JsonUtils;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseWhenSendRequestSuccessfullySteps {
	String requestBodyName, url, method = " ";
	HttpResponse<String> response = null;
	ApiUtils apiUtils = new ApiUtils();
	JsonUtils jsonUtils = new JsonUtils();
	@Given("I have login URL and method and Request body file name")
	public void i_have_login_url_and_method_and_request_body_file_name(List<Map<String, String>> givenTable) {
		// Lay dong du lieu dau tien, tuong ung dong thu 2 trong bang
		Map<String, String> row1 = givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("method");
		requestBodyName = row1.get("RequestBodyName");
		if (requestBodyName != " ") {
			requestBodyName = jsonUtils.getRequestBodyByName(requestBodyName);
		}
		// Doc file Json va chuyen noi dung file sang String
		// Buoc 1 lay duong dan thu muc file
//		String filePath = System.getProperty("user.dir") + "/src/main/resources/LoginApi/" + requestBodyName;
//		try {
//			File file = new File(filePath);
//			if (file.exists()) {
//				requestBody = new String(Files.readAllBytes(Paths.get(filePath)));
//			}
//		} catch (Exception e) {
//		}
//		System.out.println("file Path" + filePath);
//		System.out.println("requestBody" + requestBody);
		
	}

	@When("I send request")
	public void i_send_request() {
		response = apiUtils.sendRequest(url, requestBodyName, method);

	}

	@Then("I validate status code and token")
	public void i_validate_status_code_and_token() {
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 200);
		String responseBody = response.body();
		if (responseBody != " ") {
			JsonUtils jsonUtils = new JsonUtils();
			String actualToken = jsonUtils.getValueByKey(responseBody, "token");
		System.out.println(responseBody);
			Assert.assertEquals(actualToken, "QpwL5tke4Pnpja7X4");
		} else
			Assert.assertFalse(false);

	}

}
