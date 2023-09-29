import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestParam {

    @DataProvider
    public Object[] listOfIds(){
        Object data[] = {1,2,3,4,5,6,100};
        return data;
    }

    @Test(dataProvider = "listOfIds")
    public void testGetAuthors(int id){
        RestAssured.baseURI="https://fakerestapi.azurewebsites.net";
        Response res = given().pathParam("id",id).when().get("/api/v1/Authors/{id}");
        System.out.println("the id is : " +res.body().jsonPath().get("id"));
        res.prettyPrint();
        Assert.assertEquals((int) res.body().jsonPath().get("id"),id,"not Match");
        Assert.assertEquals(res.statusCode(),200,"NOt match");
        Assert.assertEquals(res.body().jsonPath().get("firstName"),"First Name "+id);

    }

    @DataProvider
    public Object[] listOfPages(){
        Object data[] = {1,2,3,4,5,6,100};
        return data;
    }

    @Test(dataProvider = "listOfPages")
    public void testGetUsers(int pageNum){
        Response users = given().queryParam("page",pageNum).when().get("https://reqres.in/api/users");
        users.prettyPrint();
        System.out.println("-------------------------------------------");
        Assert.assertEquals((int) users.body().jsonPath().get("page"),pageNum,"ERORRRR");
    }
}
