package chaining;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateIncident extends BaseRequest{
//packagename.Classname.methodname
	@Test(dependsOnMethods = {"chaining.CreateIncidentWithoutBody.createIncident"})
	public void updateIncident() {
		Response response = RestAssured 
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\"Update Incident with body as string\",\"category\":\"hardware\"}")
				.pathParam("sysID", sysID)
//				.patch("2b38860e1b4901102bef0d41604bcb85");
				.patch("{sysID}");
		System.out.println(response.statusCode());
		response.prettyPrint();		
	}
	
}
