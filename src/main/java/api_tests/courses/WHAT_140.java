package api_tests.courses;

import api_tests.BaseTest;
import constants.APIConst;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_140 extends BaseTest {

    private static String adminToken;
    private static String firstRequest = "courses/";

    @Test
    @Parameters("admin")
    public void disableCourse200Admin(String path) {
        String secondRequest = "isActive";
        String result = "[58].%s";
        String courseID = "59";
        String courseName = "unique_Test-55";
        adminToken = getAdminToken(path);

        // (step'1')
        given().
                header(APIConst.HEADER, adminToken).
                contentType(ContentType.BINARY).
                when().delete(APIConst.BASE_URL + firstRequest + courseID).
                then().assertThat().statusCode(200).
                and().assertThat().body(hasToString(APIConst.Result.TRUE)).
                and().log().body();

        // (step'2')
        given().
                header(APIConst.HEADER, adminToken).
                when().get(APIConst.BASE_URL + firstRequest + secondRequest).
                then().assertThat().statusCode(200).
                and().body(String.format(result, APIConst.Data.NAME), hasToString(courseName)).
                and().body(String.format(result, APIConst.Data.IS_ACTIVE), hasToString(APIConst.Result.FALSE)).
                and().log().body();
    }

    @AfterClass
    public void enableCourse() {
        String courseID = "59";

        given().
                header(APIConst.HEADER, adminToken).
                when().patch(APIConst.BASE_URL + firstRequest + courseID).
                then().log().body();
    }
}
