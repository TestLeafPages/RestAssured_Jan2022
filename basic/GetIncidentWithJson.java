package basic;

import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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
				.queryParam("sysparm_fields", "sys_id,number, short_description, category")
				.queryParam("sysparm_limit", "5")
				.get();
//		Step 4: Validate (Response -> Status code -> 200)
		System.out.println(response.statusCode());
//		Step 5: print Response
		response.prettyPrint();
		
		
		JsonPath jsonPath = response.jsonPath();
		//result.number
//		String number = jsonPath.get("result.number");
		
		List<String> list = jsonPath.getList("result.number");
		
		System.out.println(list.get(2));
		
		
		
		
		
		
		
		
	}
	
}
