package api_tests.courses;

import api_tests.BaseTest;
import constants.APIConst;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_152 extends BaseTest {

    private static String adminToken;
    private static String request = "courses/";

    @Test
    @Parameters("admin")
    public void updateCourseName200Admin(String path) {
        String courseID = "60";
        adminToken = getAdminToken(path);

        Map<String, String> newNameMap = new HashMap<>();
        newNameMap.put(APIConst.Data.NAME,"New Epic Course");

        // (step'1')
        System.out.println(newNameMap);
        given().
                header(APIConst.HEADER, adminToken).
                contentType(ContentType.JSON).
                body(newNameMap).
                when().put(APIConst.BASE_URL + request + courseID).
                then().assertThat().statusCode(200).
                and().assertThat().body(APIConst.Data.ID,hasToString(courseID)).
                and().assertThat().body(APIConst.Data.NAME,hasToString(newNameMap.get(APIConst.Data.NAME))).
                and().log().body();

    }

    @AfterClass
    public void resetCourseName() {
        String courseID = "60";

        Map<String, String> oldNameMap = new HashMap<>();
        oldNameMap.put(APIConst.Data.NAME,"Course for Update Test");

        given().
                header(APIConst.HEADER, adminToken).
                contentType(ContentType.JSON).
                body(oldNameMap).
                when().put(APIConst.BASE_URL + request + courseID).
                then().log().body();
    }
}
