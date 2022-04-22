package response_Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicResponseValidation {
@Test
public void dynamicresp()
{
	
	
	//pre requisites
	String expData="TY_PROJ_1004";
	baseURI="http://localhost";
	port=8084;
	
	//acttion
	Response resp=when()
			.get("/projects");
	
	//validation
	Boolean flag=false;
	List<String> pIDs=resp.jsonPath().get("projectId");
	for(String projectID:pIDs) 
	{
		if(projectID.equalsIgnoreCase(expData))
		{
			flag=true;
		}
		
	}
	Assert.assertTrue(flag);
	System.out.println("data verified");
	resp.then().log().all();
	
	
}
	
	
}
