import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCreatUser {
    @Test
    public void testCreateUser(){

        JSONObject bodyData = new JSONObject();
        bodyData.put("id","1000");
        bodyData.put("userName","Ayman");
        bodyData.put("password","555");

        Response createUser = given().header("Content-Type","Application/JSON").body(bodyData.toString())
                .when().post("https://fakerestapi.azurewebsites.net/api/v1/Users");
        createUser.prettyPrint();

    }
}
