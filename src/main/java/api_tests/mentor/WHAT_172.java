package api_tests.mentor;


import api_tests.BaseTest;
import constants.APIConst;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static constants.APIConst.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_172 extends BaseTest {

    @Test
    @Parameters("admin")
    public void resumeMentor200Admin(String path){
        String request = "mentors/";
        String id_mentor = "38";

        given().
                header(HEADER,getAdminToken(path)).
                when().delete(BASE_URL + request+ id_mentor).
                then().assertThat().statusCode(200).
                and().assertThat().body(hasToString(APIConst.Result.TRUE)).

                and().log().body();
    }
}