package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class queryParameter 
{
@Test
public void querypara()
{
baseURI="https://reqres.in";

given()
.queryParam("page", 2)

.when()
.get("/api/users")

.then()
.log().all();
}
}
