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

public class CheckValidationOfSingleFieldSteps {
	String url, method = null;
	int code=0;
	String message = null;
	HttpResponse<String> response=null;
	@Given("I have URL and method4")
	public void i_have_url_and_method4(List<Map<String, String>> givenTable) {
		Map<String, String> row1=givenTable.get(0);
		url= row1.get("URL");
		method= row1.get("method4");
	}

	@When("I send request and check status code and message in response4")
	public void i_send_request_and_check_status_code_and_message_in_response4() {
		ApiUtils apiUtil= new ApiUtils();
		response = apiUtil.sendRequest(url, message, method);		
		code = response.statusCode();
		message = response.toString();
	}

	@Then("I validate status code and message4")
	public void i_validate_status_code_and_message4() {
		Assert.assertEquals(code, 200);
		Assert.assertEquals(message, "{\n"
				+ "    \"data\": {\n"
				+ "        \"id\": 2,\n"
				+ "        \"name\": \"fuchsia rose\",\n"
				+ "        \"year\": 2001,\n"
				+ "        \"color\": \"#C74375\",\n"
				+ "        \"pantone_value\": \"17-2031\"\n"
				+ "    },\n"
				+ "    \"support\": {\n"
				+ "        \"url\": \"https://reqres.in/#support-heading\",\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n"
				+ "    }\n"
				+ "}");
	}

}
