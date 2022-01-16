package chaining;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody extends BaseRequest{
	
	@Test
	public void createIncident() {
		Response response = RestAssured 
				.given()
				.contentType(ContentType.JSON)
				.post();
		System.out.println(response.statusCode());
		response.prettyPrint();
		
		
		sysID = response.jsonPath().get("result.sys_id");
		
		
		
		
		
		
		
		
	}
	
}
