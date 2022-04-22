package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
@Test
public void bearerToken()
{
    baseURI="https://api.github.com/";
    JSONObject jObj=new JSONObject();
    jObj.put("name","SDET-RESTASSURED");
    
    
    given()
    .auth()
    .oauth2("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")
    .body(jObj)
    .contentType(ContentType.JSON)
    
    .when().post("/user/repos")
    
    .then().log().all();

}
}
