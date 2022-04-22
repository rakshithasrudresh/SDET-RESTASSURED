package DifferentWaysToPost;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONfile 
{
	@Test
	public void createProject()
	{
		
	
		//step1:create pre requisites
		File file=new File(".\\Data.json");
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()  //step2:perform action
		.post("/addProject")
		
		
		.then()   //step3:validation
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

	
}
