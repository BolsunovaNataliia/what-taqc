package api_tests.secretaries;

import api_tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class WHAT_143 extends BaseTest {

    @Test
    public void getAllSecretaries200Admin(){

        given().
                header("Authorization",getAdminToken()).
                when().get("https://whatbackend.azurewebsites.net/api/secretaries")
                .then().assertThat().statusCode(200)
                .and().log().body();
    }
}