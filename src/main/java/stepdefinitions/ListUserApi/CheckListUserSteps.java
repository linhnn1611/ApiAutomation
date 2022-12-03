package stepdefinitions.ListUserApi;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckListUserSteps {
	String url, method, requestBody="";
	HttpResponse<String> response = null;
	ApiUtils apiUtils=new ApiUtils();
	
	@Given("I have URL and method")
	public void i_have_url_and_method(List<Map<String, String>> givenTable) {
		Map<String, String> row1= givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("method");
	  
	}

	@When("I will send a request")
	public void i_will_send_a_request() {
	   response= apiUtils.sendRequest(url, requestBody, method);
	}

	@Then("I need validate status code and data")
	public void i_need_validate_status_code_and_data() {
	    int actualStatusCode= response.statusCode();
	    Assert.assertEquals(actualStatusCode, 200);
	    String actualMessage = response.body();
	    Assert.assertEquals(actualMessage, "{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":"
	    		+ "[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},"
	    		+ "{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},"
	    		+ "{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},"
	    		+ "{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},"
	    		+ "{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},"
	    		+ "{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],"
	    		+ "\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}");
	}
}
