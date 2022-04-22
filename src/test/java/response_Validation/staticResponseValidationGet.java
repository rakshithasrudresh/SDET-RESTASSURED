package response_Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import projectLibrary.ProjectLibrary;

public class staticResponseValidationGet {
	@Test
	public void staticresponsevaliGet()
	{
		String expData="Rakshitha";
		
		//step1:pre requisities
		JavaLibrary jlib=new JavaLibrary();
		baseURI="http://localhost:8084/";
		
		//perform validation
		Response resp=when()
		.get("projects");
		
		//validation
	String actData = resp.jsonPath().get("[0].createdBy");

	Assert.assertEquals(actData,expData);
		System.out.println("Data Verified");
		resp.then().log().all();
	}
}
