package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentSteps {
	
	public Response response;
	
	/*@Given("Set EndPoint for the server")
	public void setEndpoint() {
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
	}
	
	@And("Set up the Authentication as {string} and {string}")
	public void setAuthInfo(String uName,String pwd) {
		RestAssured.authentication = RestAssured.basic(uName, pwd);
	}
	*/
	@When("place the post request")
	public void createIncident() {
		response = RestAssured 
				.given()
				.contentType(ContentType.JSON)
				.when()
				.post()
				;
	}
	
	@When("place the post request with body as {string} and {string}")
	public void createIncidentWithBody(String shortDesc,String category) {
		response = RestAssured 
				.given()
				.contentType(ContentType.JSON)
				.when()
				.body("{\"short_description\":\""+shortDesc+"\",\"category\":\""+category+"\"}")
				.post()
				;
	}
	
	/*@Then("Verify the status code as (.*)$")
	public void verifyStatusCode(String code) {
		response
		.then()
		.statusCode(new Integer(code))
		;		
	}*/

	@Then("Verify the status code as {int}")
	public void verifyStatusCode(int code) {
		response
		.then()
		.statusCode(code)
		;		
	}
	
	@And("Print the Response body")
	public void printResponse() {
		response.prettyPrint();
	}
	
	@And("Print the Response ContentType")
	public void print_the_response_content_type() {
		System.out.println(response.contentType());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
