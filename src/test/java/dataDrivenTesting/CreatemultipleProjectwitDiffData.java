package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreatemultipleProjectwitDiffData {

	@Test(dataProvider="getData")
	public void createProject(String createdBy, String projectName,String status,int teamSize)
	{
		//pre requisities
		
		JavaLibrary jLib=new JavaLibrary();
		ProjectLibrary pLib=new ProjectLibrary(createdBy, projectName+jLib.getRandomNumber(),status,teamSize);
		baseURI="http://localhost:8084/";
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		.when()//action
		.post("addProject")
		
		.then()//validation
		.log().all();
		
	}
	
	
	@DataProvider(name="getData")
	public Object[][] data()
	{
		Object[][] data=new Object[3][4];
		
		data[0][0]="Raksh";
		data[0][1]="Dell";
		data[0][2]="Completed";
		data[0][3]=12;
	
		
		data[1][0]="Rakshitha";
		data[1][1]="IBM";
		data[1][2]="On-going";
		data[1][3]=125;
	
		
		
		data[2][0]="Rakshu";
		data[2][1]="Infosys";
		data[2][2]="Completed";
		data[2][3]=122;
		
	return data;
	
		
		
	}
	
	
	
	
	
	
	
	
	
}
