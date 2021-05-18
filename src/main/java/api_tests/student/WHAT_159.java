package api_tests.student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class WHAT_159 {

    @Test
    public void WHAT_159() {

        Map<String, String> map = new HashMap<>();
        map.put("email", "admin.@gmail.com");
        map.put("password", "admiN_12");
        Response response = RestAssured.given().body(map).contentType(ContentType.JSON).post("https://whatbackend.azurewebsites.net/api/accounts/auth");
        String token = response.getHeader("authorization");

        response = RestAssured.given().header("Authorization", token).get("https://whatbackend.azurewebsites.net//api/students/4");

        Assert.assertEquals(200, response.statusCode());
    }
}
