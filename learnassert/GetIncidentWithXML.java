package learnassert;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetIncidentWithXML {

	@Test
	public void getIncident() {
//		Step 1: Set EndPoint / URI for the server
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
//		Step 2: Set Authentication (Basic Auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		Step 3: Request type (Get) ctrl + 2, l
		Response response = RestAssured 
				.given()
				.accept(ContentType.XML)
				.queryParam("sysparm_fields", "sys_id,number, short_description, category")
//				.queryParam("sysparm_limit", "5")
				.get()
				.then()
				//.body("response.result.number[1]", equalTo("INC0000011"))
				.body("response.result.number", hasItem("INC0000011"))// array, list, set
				.extract().response();
	 
//		Step 4: Validate (Response -> Status code -> 200)
		System.out.println(response.statusCode());
//		Step 5: print Response
		response.prettyPrint();
		
		
		XmlPath xmlPath = response.xmlPath();
		
		List<String> list = xmlPath.getList("response.result.number");
		
		System.out.println(list.get(2));
		
		
		
		
		
		
		
		
		
	}
	
}
