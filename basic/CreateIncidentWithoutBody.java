package basic;

import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody {

	@Test
	public void cerateIncident() {
//		Step 1: Set EndPoint / URI for the server
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
//		Step 2: Set Authentication (Basic Auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		Step 3: Request type (post) ctrl + 2, l
		Response response = RestAssured 
				.given()
				.contentType(ContentType.JSON)
				.post();
//		Step 4: Validate (Response -> Status code -> 201)
		System.out.println(response.statusCode());
//		Step 5: print Response
		response.prettyPrint();
		
		
		
		
		
		
		
		
		
	}
	
}
