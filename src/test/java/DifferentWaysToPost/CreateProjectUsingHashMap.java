package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap {

	@Test
	public void createProject()
	{
		JavaLibrary jlib=new JavaLibrary();

		baseURI="http://localhost";
		port=8084;
		
		//step1:create pre requisite
		
		HashMap map=new HashMap();
		map.put("createdBy", "adhvik");
		map.put("projectName", "IBM "+jlib.getRandomNumber());
		map.put("status", "Created");
		map.put("teamSize", "100");
		
		
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()  //step2:perform action
		.post("/addProject")
		
		
		.then()   //step3:validation
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
