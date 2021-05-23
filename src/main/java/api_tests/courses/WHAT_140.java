package api_tests.courses;

import api_tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class WHAT_140 extends BaseTest {

    @Test
    public void disableCourse200Admin(){
        String courseID = "59";
        String courseName = "unique_Test-55";
        String adminToken = getAdminToken();

        // (step'1')
        given().
                header("Authorization", adminToken).
                contentType(ContentType.BINARY).
                when().delete("https://whatbackend.azurewebsites.net/api/courses/" + courseID).
                then().assertThat().statusCode(200).
                and().assertThat().body(hasToString("true")).
                and().log().body();

        // (step'2')
        given().
                header("Authorization", adminToken).
                when().get("https://whatbackend.azurewebsites.net/api/courses/isActive").
                then().assertThat().statusCode(200).
                and().body("[58].name",hasToString(courseName)).
                and().body("[58].isActive", hasToString("false")).
                and().log().body();
    }

    @AfterClass
    public void enableCourse(){
        String courseID = "59";

        given().
                header("Authorization",getAdminToken()).
                when().patch("https://whatbackend.azurewebsites.net/api/courses/" + courseID).
                then().log().body();
    }
}
