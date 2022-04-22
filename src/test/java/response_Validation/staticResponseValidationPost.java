package response_Validation;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import projectLibrary.ProjectLibrary;

public class staticResponseValidationPost {
@Test
public void staticresponsevali()
{
	
	
	//step1:pre requisities
	JavaLibrary jlib=new JavaLibrary();
	ProjectLibrary plib=new ProjectLibrary("Raksh","Xylem"+jlib.getRandomNumber(),"completed",30);
	
	baseURI="http://localhost:8084/";
	
	Response resp = given()
	.body(plib)
	.contentType(ContentType.JSON)
	
	.when()
	.post("addProject");
	
	
String actData = resp.jsonPath().get("projectId");

Assert.assertEquals(actData,"TY_PROJ_1204");
	System.out.println(actData);
	resp.then().log().all();
}
}
