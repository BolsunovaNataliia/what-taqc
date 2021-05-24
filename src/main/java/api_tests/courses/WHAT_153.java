package api_tests.courses;

import api_tests.BaseTest;
import constants.APIConst;
import io.restassured.http.ContentType;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_153 extends BaseTest {

    @Test
    @Parameters("admin")
    public void createCourse200Admin(String path){
        String request = "courses";
        String newCourseID = "74";
        Map <String, String> courseMap = new HashMap<>();
        courseMap.put(APIConst.Data.NAME,"Brand New Course" + newCourseID);

        given().
                header(APIConst.HEADER,getAdminToken(path)).
                contentType(ContentType.JSON).
                body(courseMap).
                when().post(APIConst.BASE_URL + request).
                then().assertThat().statusCode(200).
                and().body(APIConst.Data.ID, hasToString(newCourseID)).
                and().body(APIConst.Data.NAME, hasToString(courseMap.get(APIConst.Data.NAME))).
                and().log().body();
    }
}
