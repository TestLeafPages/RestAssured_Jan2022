package learnassert;

import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetIncidentWithJson {

	@Test
	public void getIncident() {
//		Step 1: Set EndPoint / URI for the server
		RestAssured.baseURI = "https://dev79195.service-now.com/api/now/table/incident";
//		Step 2: Set Authentication (Basic Auth)
		RestAssured.authentication = RestAssured.basic("admin", "KqEbzmfZS81W");
//		Step 3: Request type (Get) ctrl + 2, l
		Response response = RestAssured 
				.given()
//				.contentType(contentType)
				.accept(ContentType.XML)
				.queryParam("sysparm_fields", "sys_id,number, short_description, category")
				.queryParam("sysparm_limit", "5")
				.get()
				.then()
//				.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract().response()
				;
		response.prettyPrint();
		
		
		JsonPath jsonPath = response.jsonPath();
		//result.number
//		String number = jsonPath.get("result.number");
		
		List<String> list = jsonPath.getList("result.number");
		
		System.out.println(list.get(2));
		
		
		
		
		
		
		
		
	}
	
}
