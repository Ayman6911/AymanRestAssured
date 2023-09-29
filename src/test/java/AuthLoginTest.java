import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthLoginTest {
    String token;
    @Test (priority = 0)
    public void loginTest() {

        JSONObject bodyData = new JSONObject();

//String body = "{\n" +
//        "    \"email\":\"superman@gmail.com\",\n" +
//        "    \"password\":\"123456\"\n" +
//        "}";

        bodyData.put("email","superman@gmail.com");
        bodyData.put("password","123456");
       Response login = given().headers("Content-Type","application/json").body(bodyData.toString())
            .when().post("https://apingweb.com/api/login");
       login.prettyPrint();
       token = login.body().jsonPath().get("token");
       System.out.println("newtok: " + token);


    }
    @Test (priority = 1)
    public void getArticles(){
        Response Articles = given().when().auth().oauth2(token).get("https://apingweb.com/api/articles");
        Articles.prettyPrint();
    }
}
