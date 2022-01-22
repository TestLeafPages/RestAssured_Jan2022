package basic;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class LearnCookies {

	@Test
	public void getIncident() {
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured 
				.given()
				.cookie("JSESSIONID","D4B36F9D2757C7378905194BF1661CD3")
				.queryParam("sysparm_fields", "sys_id,number, short_description, category")
				.queryParam("sysparm_limit", "5")
				.get();
		System.out.println(response.statusCode());
		response.prettyPrint();
		
		Map<String, String> allCookies = response.getCookies();
		Set<Entry<String, String>> setOfCookies = allCookies.entrySet();
		
		for (Entry<String, String> temp : setOfCookies) {
			System.out.println(temp);
		}
		
	}
	
}










