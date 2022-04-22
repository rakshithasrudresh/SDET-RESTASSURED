package PracticeCRUDOperationsWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest {
	
	@Test
	public void updateProject()
	{
		
	
	//step1:create the pre requisites -request body
			JSONObject jObj = new JSONObject();
			jObj.put("createdBy","Rakshitha");
			jObj.put("projectName","flinko12345");
			jObj.put("status","Complted");
			jObj.put("teamSize","300");
			
			baseURI="http://localhost:8084/";
			
			
			given()
			.body(jObj)
			.contentType(ContentType.JSON)
			
			.when()  //step2:perform action
			.put("projects/TY_PROJ_1006")
			
			.then()   //step3:validation
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
		
			
			
			
		
}
}
