import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicAuthGetUsers {
    @Test
    public void BasicAuthGetUsers(){
        Response res = given().auth().basic("admin","12345").when()
                .get("https://apingweb.com/api/auth/users");
       res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
       Assert.assertEquals( res.body().jsonPath().get("success"),true);

    }
}
