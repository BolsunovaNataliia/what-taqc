package api_tests.courses;

import api_tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class WHAT_153 extends BaseTest {

    @Test
    public void createCourse200Admin() {
        String newCourseID = "74";

        Map <String, String> courseMap = new HashMap<>();
        courseMap.put("name","Brand New Course" + newCourseID);

        given().
                header("Authorization",getAdminToken()).
                contentType(ContentType.JSON).
                body(courseMap).
                when().post("https://whatbackend.azurewebsites.net/api/courses").
                then().assertThat().statusCode(200).
                and().body("id", hasToString(newCourseID)).
                and().body("name", hasToString(courseMap.get("name"))).
                and().log().body();
    }
}
