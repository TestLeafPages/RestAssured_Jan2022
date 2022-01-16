package learnassert;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsString {

	@Test
	public void createIncident() {
//		Step 1: Set EndPoint / URI for the server
		RestAssured.baseURI = "https://dev79195.service-now.com/api/now/table/incident";
//		Step 2: Set Authentication (Basic Auth)
		RestAssured.authentication = RestAssured.basic("admin", "KqEbzmfZS81W");
//		Step 3: Request type (post) ctrl + 2, l
		Response response = RestAssured 
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\"Create Inccident with body as string\",\"category\":\"software\"}")
				.post()
				.then()
				.statusCode(201)
				//path of the field, value for the field
				// will work for 1st match
				.body("result.short_description", containsString("Create Inccident with body"))
				.body("result.category", equalTo("software"))
				.extract().response();
//		Step 4: Validate (Response -> Status code -> 201)
		System.out.println(response.statusCode());
//		Step 5: print Response
		response.prettyPrint();
		
		/*String asString = response.asString();
		if(asString.equals(""))*/
		
		
		
		
		
		
	}
	
}
