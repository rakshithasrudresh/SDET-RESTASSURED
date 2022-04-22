package requestChaining;



import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import projectLibrary.ProjectLibrary;

public class CreateProjectandGetProject {
@Test
public void requestChaining()
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
    .get("/projects/{pid}")
    .then()
    .assertThat().statusCode(200).log().all();
    
    
    
    
    
    
    
    
}
}
