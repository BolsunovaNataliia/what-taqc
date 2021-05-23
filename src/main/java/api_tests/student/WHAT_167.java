package api_tests.student;

import api_tests.BaseTest;
import constants.APIConst;
import io.restassured.http.ContentType;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WHAT_167 extends BaseTest {

    @Test
    @Parameters("admin")
    public void putStudents200Admin(String path){
        String request = "students/";
        // Changed student: id = 2, firstName = Student, lastName = Student, email = Student@gmail.org

        int id_student = 2;
        Map<String, String> mapChanges = new HashMap<>();
        mapChanges.put(APIConst.Data.EMAIL, "testEmail_1@gmail.com");
        mapChanges.put(APIConst.Data.FIRST_NAME, "fn_1");
        mapChanges.put(APIConst.Data.LAST_NAME, "ln_1");

        given().
                header(APIConst.HEADER,getAdminToken(path)).
                contentType(ContentType.JSON).
                body(mapChanges).
                when().put(APIConst.BASE_URL+ request + id_student).
                then().assertThat().statusCode(200).
                and().body(APIConst.Data.EMAIL, equalTo(mapChanges.get(APIConst.Data.EMAIL))).
                and().body(APIConst.Data.FIRST_NAME, equalTo(mapChanges.get(APIConst.Data.FIRST_NAME))).
                and().body(APIConst.Data.LAST_NAME, equalTo(mapChanges.get(APIConst.Data.LAST_NAME))).
                and().log().body();
    }
}
