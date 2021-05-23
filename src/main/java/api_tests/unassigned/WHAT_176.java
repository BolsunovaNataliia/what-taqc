package api_tests.unassigned;


import api_tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class WHAT_176 extends BaseTest {

    @Test
    public void getNotAssigned401WrongToken(){

        String notValidToken = "Bearer Token_1";

        given().
                header("Authorization",notValidToken).
                when().get("https://whatbackend.azurewebsites.net/api/accounts/NotAssigned").
                then().assertThat().statusCode(401);
    }
}