package PracticeCRUDOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
	
@Test
public void createProjectTest()
{
 JavaLibrary jlib=new JavaLibrary();
	
		//step1:create the pre requisites -request body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Rakshitha");
		jObj.put("projectName","flinko123456"+jlib.getRandomNumber());
		jObj.put("status","On-going");
		jObj.put("teamSize","30");
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()  //step2:perform action
		.post("/addProject")
		
		
		.then()   //step3:validation
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	
}
}
