package basic;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFile {
	
	@DataProvider(name = "Fetchdata")
	public String[] setData() {
		// row -> No of data set
		// column -> No of data in each data set
		String[] data = new String[2];
		data[0] = "./data/CreateIncident1.json";
		data[1] = "./data/CreateIncident2.json";
		return data;
	}
	
	@Test(dataProvider = "Fetchdata")
	public void cerateIncident(String filePath) {
		RestAssured.baseURI = "https://dev79195.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "KqEbzmfZS81W");
//		File file = new File("./data/CreateIncident.json");
		Response response = RestAssured 
				.given()
//				.log().all()
				.contentType(ContentType.JSON)
				.body(new File(filePath))
				.post();
		System.out.println(response.statusCode());
		response.prettyPrint();
		
		
		
		
		
		
		
		
		
	}
	
}
