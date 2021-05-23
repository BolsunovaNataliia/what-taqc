package api_tests.mentor;


import api_tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_172 extends BaseTest {

    @Test
    public void resumeMentor200Admin(){
        String id_mentor = "38";

        given().
                header("Authorization",getAdminToken()).
                when().delete("https://whatbackend.azurewebsites.net/api/mentors/" + id_mentor).
                then().assertThat().statusCode(200).
                and().assertThat().body(hasToString("true")).


                and().log().body();
    }
}