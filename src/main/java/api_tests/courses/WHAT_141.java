package api_tests.courses;

import api_tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class WHAT_141 extends BaseTest {

    @Test
    public void getCourses200Admin(){
        String courseID = "16";
        String courseName = "You know WHAT to do";

        given().
                header("Authorization",getAdminToken()).
                when().get("https://whatbackend.azurewebsites.net/api/courses/isActive").
                then().assertThat().statusCode(200).
                and().body("[15].id", hasToString(courseID)).
                and().body("[15].name", hasToString(courseName)).
                and().log().body();
    }
}
