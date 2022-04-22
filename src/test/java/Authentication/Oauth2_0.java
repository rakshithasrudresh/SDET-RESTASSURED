package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 {
	@Test
	public void oauth2Authentication()
	{
		//create a req to generate access token
	Response resp = given()
	    .formParam("client_id","Sdet-30_coops")
	     .formParam("client_secret","ac58a3d84093eec4bb5991f9223712d7")
	     .formParam("grant_type","client_credentials")
	     .formParam("Redirect URI","http://example.com")
	     .formParam("code", "authorization_code")
	     
	     .when().post("http://coop.apps.symfonycasts.com/token");
	
	//capture the access token from the response of above request
	
	String token = resp.jsonPath().get("access_token");
	System.out.println(token);
	
	//create another request and use the token to access the APIs
	
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID",3104)
	
	.when()
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
	
	.then().log().all();
	
	
	
	
	
	
	
	
	}
	

}
