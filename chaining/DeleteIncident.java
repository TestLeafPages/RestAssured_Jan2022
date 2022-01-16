package chaining;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequest{

	@Test(dependsOnMethods = {"chaining.UpdateIncident.updateIncident"})
	public void deleteIncident() {
		Response response = RestAssured 
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.pathParam("sysID", sysID)
//				.patch("2b38860e1b4901102bef0d41604bcb85");
				.delete("{sysID}");
		System.out.println(response.statusCode());
		response.prettyPrint();
		
		
		
		
		
		
		
		
		
	}
	
}
