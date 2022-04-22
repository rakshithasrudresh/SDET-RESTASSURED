package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.ProjectLibrary;

public class CreateProAndDelete 
{
	
	@Test
	public void CreateAndDelete()
	{
	//step1:create a project using pojo
	
		JavaLibrary jLib=new JavaLibrary();
		ProjectLibrary pLib=new ProjectLibrary("Rakshu", "Chrome "+jLib.getRandomNumber(),"completd",88);
		baseURI="http://localhost:8084/";
		
	Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when().post("/addProject");


	//capture the project id
	    String proId = resp.jsonPath().get("projectId");
	    System.out.println(proId);
	    resp.then().log().all();
	    
	    
	    //create a get req n pass proId as path Parameter
	    
	    given()
	    .pathParam("pid", proId)
	    
	    .when()
	    .delete("/projects/{pid}")
	    
	    .then()
	    .assertThat().statusCode(204).log().all();
	    
	    
	    
	    
	    
	    
	    
	    
	}
}
