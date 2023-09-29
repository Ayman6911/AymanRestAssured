import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
public class AppTest {

    @Test
     public void test1(){
        RestAssured.baseURI = "https://reqres.in";
        int pageNum = 1;
        //Response da is variable type
        Response res1 = given().queryParam("page",pageNum).when().get("/api/users");
        res1.prettyPrint();
        Assert.assertEquals(res1.statusCode(),200,"Error");
        Assert.assertEquals((int)res1.body().jsonPath().get("page"),pageNum,"error Msg");

        System.out.println("page number:"+res1.body().jsonPath().get("page"));
        System.out.println("print all id:"+res1.body().jsonPath().get("data.id"));
        System.out.println("first id:"+res1.body().jsonPath().get("data.id[0]"));


    }

}
