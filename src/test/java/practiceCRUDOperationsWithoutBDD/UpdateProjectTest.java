package practiceCRUDOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
@Test
public void updateProject()
{
	//step1:create the pre requisites -request body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Rakshu");
		jObj.put("projectName","flinko");
		jObj.put("status","Completed");
		jObj.put("teamSize","30");
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//step2:Perform the Action
		
		Response response = req.put("http://localhost:8084/projects/TY_PROJ_1003");
		
		
		//step3:Validate the response
		
		response.then().log().all();
		
		int actStatus=response.getStatusCode();
		Assert.assertEquals(200,actStatus);
		
		
		
		
		
}
}
