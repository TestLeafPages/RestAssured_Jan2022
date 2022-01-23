package learnassert;

import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class updateIssueWithFile {

	@Test
	public void createIncident() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/23538/attachments";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "gaPUrnS7iDvEf3Wm3O4iF2D3");
		Response response = RestAssured 
				.given()
				.log().all()
				.header(new Header("Content-Type", "multipart/form-data"))
				.header(new Header("X-Atlassian-Token", "no-check"))
				.multiPart(new File("C:\\Users\\sarat\\Pictures\\Saved Pictures\\image5.jpg"))
				.post();
		System.out.println(response.statusCode());
		response.prettyPrint();
	}
	
}
