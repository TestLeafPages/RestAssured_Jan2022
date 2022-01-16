package basic;

import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateIncident {

	@Test
	public void updateIncident() {
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured 
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\"Update Incident with body as string\",\"category\":\"hardware\"}")
				.pathParam("sysID", "2b38860e1b4901102bef0d41604bcb85")
//				.patch("2b38860e1b4901102bef0d41604bcb85");
				.patch("{sysID}");
		System.out.println(response.statusCode());
		response.prettyPrint();
		
		
		
		
		
		
		
		
		
	}
	
}
