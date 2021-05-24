package api_tests.secretaries;

import api_tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static constants.APIConst.*;
import static io.restassured.RestAssured.given;

public class WHAT_143 extends BaseTest {

    @Test
    @Parameters("admin")
    public void getAllSecretaries200Admin(String path){
        String request = "secretaries";

        given().
                header(HEADER,getAdminToken(path)).
                when().get(BASE_URL + request)
                .then().assertThat().statusCode(200)
                .and().log().body();
    }
}