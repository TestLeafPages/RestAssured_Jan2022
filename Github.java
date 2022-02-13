package basic;

import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Github {
	
	String body = "{\r\n" + 
			"  repository(name: \"Leaftaps\", owner: \"SarathTL\") {\r\n" + 
			"    createdAt\r\n" + 
			"    id\r\n" + 
			"    url\r\n" + 
			"  }\r\n" + 
			"}"; 

	@Test
	public void createIncident() {
		RestAssured.baseURI = "https://api.github.com/graphql";
		
		Response response = RestAssured 
				.given()
				.header("Authorization","Bearer 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")
				.contentType(ContentType.JSON)
				.body(getQuery(body))
				.post();
		System.out.println(response.statusCode());
		response.prettyPrint();
		}
	
	private String getQuery(String query) {
		JSONObject obj = new JSONObject();
		// key = value
		obj.put("query", query);
		return obj.toString();
	}
}
