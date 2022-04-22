package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.ProjectLibrary;

public class CreateProjectUsingPOJO {

	@Test
	public void createProject()
	{
		JavaLibrary jlib=new JavaLibrary();

		baseURI="http://localhost";
		port=8084;
		
		//create pre-requisites
		ProjectLibrary pLib=new ProjectLibrary("Adhya","Google "+jlib.getRandomNumber(),"completed",100);
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		.when()  //step2:perform action
		.post("/addProject")
		
		
		.then()   //step3:validation
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}
}
