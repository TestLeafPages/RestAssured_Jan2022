package learnassert;

import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateIncidentWithBodySchemaCheck {

	@Test
	public void createIncident() {
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured 
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\"Create Inccident with body as string\",\"category\":\"software\"}")
				.post()
				.then()
				.body(JsonSchemaValidator.matchesJsonSchema(new File("./data/CreateIncidentSchema.json")))
				.extract().response();
		System.out.println(response.statusCode());
		response.prettyPrint();
		
	}
	
}
