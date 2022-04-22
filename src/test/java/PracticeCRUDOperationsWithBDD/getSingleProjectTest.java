package PracticeCRUDOperationsWithBDD;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getSingleProjectTest {

	@Test
	public void getsingleProject()
	{
	
		baseURI="http://localhost:8084/";
		
		when()
		 .get("projects/TY_PROJ_1003")
		 
		 
	 .then()
	 .log().all();
		
		
		
	}
	
}
