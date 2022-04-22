package PracticeCRUDOperationsWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class getAllProjects {

	@Test
	public void getallProjects()
	{
		baseURI="http://localhost:8084/";
		
		
		when()
		 .get("projects")
		 
		 
	 .then()
	 .log().all();	
	}
}
