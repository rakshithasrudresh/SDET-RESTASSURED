package practiceCRUDOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetAllProjectsTest {
@Test
public void getAllProjects()
{
	//step1:create a pre-requities
	//step2:perform the action
	
	Response resp=RestAssured.get("http://localhost:8084/projects");
	
	//step3:provide validation
	      resp.then().log().all();
	     int actStatus = resp.getStatusCode();
	     Assert.assertEquals(200, actStatus);
	     
	
}
}
