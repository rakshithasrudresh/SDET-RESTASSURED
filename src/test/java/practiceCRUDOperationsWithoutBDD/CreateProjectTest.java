package practiceCRUDOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest
{	
	@Test
public void createProjectTest()
{
	//step1:create the pre requisites -request body
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy","Rakshu");
	jObj.put("projectName","flinkos");
	jObj.put("status","On-going");
	jObj.put("teamSize","30");
	
	RequestSpecification req = RestAssured.given();
	req.body(jObj);
	req.contentType(ContentType.JSON);
	
	//step2:Perform the Action
	
	Response response = req.post("http://localhost:8084/addProject");
	
	
	//step3:Validate the response
	
	System.out.println(response.getContentType());
	System.out.println(response.asString());
	System.out.println(response.prettyPrint());
	System.out.println(response.prettyPeek());
	
	
	
	
}

}
