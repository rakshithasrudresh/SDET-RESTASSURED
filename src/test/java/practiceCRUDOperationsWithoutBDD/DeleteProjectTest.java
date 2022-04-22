package practiceCRUDOperationsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteProjectTest {
	
@Test
public void deleteProjectTest()
{
	
	
	
Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_202");
response.then().log().all();

int actStatus=response.getStatusCode();
Assert.assertEquals(actStatus,204);

	
	
}
}
