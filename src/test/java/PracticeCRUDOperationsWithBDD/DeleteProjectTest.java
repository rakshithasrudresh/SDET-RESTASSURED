package PracticeCRUDOperationsWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteProjectTest {

	@Test
	public void deleteProject()
	{
		baseURI="http://localhost:8084/";
		
		
		when()
		 .delete("projects/TY_PROJ_1003")
		 
		 
	 .then()
	 .assertThat()
	 .statusCode(204)
	 .log().all();	
	}
	
	
	
}
