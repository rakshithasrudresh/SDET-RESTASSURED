package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class formParameters 
{
@Test
public void createProjectusingFormParameter()
{
	
	
	
//prequities
	baseURI="http://localhost";
	port=8084;
	
	given()
	  .formParam("createdBy","aish")
	.formParam("projectName","btmc")
	.formParam("status","Created")
	.formParam("teamSize",1)
	
	//action
	.when().post("/addProject")
	
	//validation
	.then().log().all();
	
	
}
}
