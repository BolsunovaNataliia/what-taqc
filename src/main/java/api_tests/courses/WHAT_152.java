package api_tests.courses;

import api_tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_152 extends BaseTest {

    @Test
    public void updateCourseName200Admin(){
        String courseID = "60";
        String adminToken = getAdminToken();

        Map<String, String> newNameMap = new HashMap<>();
        newNameMap.put("name","New Epic Course");

        // (step'1')
        System.out.println(newNameMap);
        given().
                header("Authorization", adminToken).
                contentType(ContentType.JSON).
                body(newNameMap).
                when().put("https://whatbackend.azurewebsites.net/api/courses/" + courseID).
                then().assertThat().statusCode(200).
                and().assertThat().body("id",hasToString(courseID)).
                and().assertThat().body("name",hasToString(newNameMap.get("name"))).
                and().log().body();

    }

    @AfterClass
    public void resetCourseName() {
        String courseID = "60";
        String adminToken = getAdminToken();

        Map<String, String> oldNameMap = new HashMap<>();
        oldNameMap.put("name","Course for Update Test");

        given().
                header("Authorization", adminToken).
                contentType(ContentType.JSON).
                body(oldNameMap).
                when().put("https://whatbackend.azurewebsites.net/api/courses/" + courseID).
                then().log().body();
    }
}
