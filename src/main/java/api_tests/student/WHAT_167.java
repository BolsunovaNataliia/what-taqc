package api_tests.student;

import api_tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WHAT_167 extends BaseTest {

    @Test
    public void putStudents200Admin() {

        // Changed student: id = 2, firstName = Student, lastName = Student, email = Student@gmail.org

        int id_student = 2;
        Map<String, String> mapChanges = new HashMap<>();
        mapChanges.put("email", "testEmail_1@gmail.com");
        mapChanges.put("firstName", "fn_1");
        mapChanges.put("lastName", "ln_1");

        given().
                header("Authorization", getAdminToken()).
                contentType(ContentType.JSON).
                body(mapChanges).
                when().put("https://whatbackend.azurewebsites.net/api/students/" + id_student).
                then().assertThat().statusCode(200).
                and().body("email", equalTo(mapChanges.get("email"))).
                and().body("firstName", equalTo(mapChanges.get("firstName"))).
                and().body("lastName", equalTo(mapChanges.get("lastName"))).
                and().log().body();
    }
}
