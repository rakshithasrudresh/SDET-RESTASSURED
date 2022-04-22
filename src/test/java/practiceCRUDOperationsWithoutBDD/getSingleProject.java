package practiceCRUDOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class getSingleProject {
	
	@Test
	public void getsingleProject()
	{
		Response resp=RestAssured.get("http://localhost:8084/projects/TY_PROJ_1003");
		
		//step3:provide validation
		      resp.then().log().all();
		     int actStatus = resp.getStatusCode();
		     Assert.assertEquals(actStatus,200);
	}

}
