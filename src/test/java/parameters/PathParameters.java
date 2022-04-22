package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameters
{
@Test
public void getSingleProject()
{
	//pre reqisities
	baseURI="http://localhost:8084/";
	
	given()
	.pathParam("pid","TY_PROJ_603")
	
	//actions
	.when().get("/projects/{pid}")
	
	//validation
	.then().log().all();
	
	
}

}
