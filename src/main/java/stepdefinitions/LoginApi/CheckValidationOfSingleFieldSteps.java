package stepdefinitions.LoginApi;

import java.io.File;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import common.JsonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckValidationOfSingleFieldSteps {
	String url, method, requestBodyName = null;
	HttpResponse<String> response=null;
	JsonUtils jsonUtils = new JsonUtils(); 
	@Given("I have login URL and method4 and RequestBodyName")
	public void i_have_url_and_method4_and_request_body_name(List<Map<String, String>> givenTable) {
		Map<String, String> row1=givenTable.get(0);
		url= row1.get("URL");
		method= row1.get("method4");
		requestBodyName = row1.get("RequestBodyName");
//		if (requestBodyName != "") {
//			requestBodyName = jsonUtils.getRequestBodyByName(requestBodyName);
//		}
	}  

	@When("I send login valid login request with {string} and {string}")
	public void i_send_valid_login_request_with_and(String givenFieldName, String givenValue) {
		File sourceFile = new File(jsonUtils.getFilePath(requestBodyName));
		File destinationFile = new File(jsonUtils.getFilePath( requestBodyName.replace("/", "/Copy_")));
		System.out.println("DesFile" +destinationFile);
		jsonUtils.copyJsonFile(sourceFile, destinationFile);
		String requestBody=  jsonUtils.changeValueByFieldName(destinationFile, givenFieldName, givenValue);
		ApiUtils apiUtil= new ApiUtils();
		response = apiUtil.sendRequest(url, requestBody, method);
		
	}

	@Then("Response return {string} and {string}")
	public void response_return_and(String expectedStatusCode, String expectedErrorMessage){
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(String.valueOf(actualStatusCode), expectedStatusCode);
		String body = response.body();
//		System.out.println("Body" +body);
		if(actualStatusCode != 200) {
		String actualErrorMessage = jsonUtils.getValueByKey(body, "error");
//		System.out.println("Linh" +actualErrorMessage);
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		}
		
	}


}
