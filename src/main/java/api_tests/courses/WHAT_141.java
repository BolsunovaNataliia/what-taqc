package api_tests.courses;

import api_tests.BaseTest;
import constants.APIConst;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_141 extends BaseTest {

    @Test
    @Parameters("admin")
    public void getCourses200Admin(String path){
        String request = "courses/isActive";
        String result = "[15].%s";
        String courseID = "16";
        String courseName = "You know WHAT to do";

        given().
                header(APIConst.HEADER,getAdminToken(path)).
                when().get(APIConst.BASE_URL + request).
                then().assertThat().statusCode(200).
                and().body(String.format(result, APIConst.Data.ID), hasToString(courseID)).
                and().body(String.format(result, APIConst.Data.NAME), hasToString(courseName)).
                and().log().body();
    }
}
