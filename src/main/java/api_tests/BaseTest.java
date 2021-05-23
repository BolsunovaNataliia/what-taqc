package api_tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseTest {

    public String getAdminToken() {
        Map<String, String> credMap = new HashMap<>();

        credMap.put("email", "admin.@gmail.com");
        credMap.put("password", "admiN_12");
        Response response = given().
                body(credMap).
                contentType(ContentType.JSON).
                when().
                post("https://whatbackend.azurewebsites.net/api/accounts/auth");
        System.out.println(response.getHeader("authorization"));
        return response.getHeader("authorization");
    }


}
