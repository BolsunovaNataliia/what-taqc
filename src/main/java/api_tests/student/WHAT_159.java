package api_tests.student;

import api_tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WHAT_159 extends BaseTest {

    @Test
    public void getApiStudentsId200Admin() {

        int id_student = 4;
        String email = "name_stud@gmail.com";
        String firstName = "FirstNameStud";
        String lastName = "LastNameStud";

        given().
                header("Authorization", getAdminToken()).
                when().get("https://whatbackend.azurewebsites.net/api/students/" + id_student).
                then().assertThat().statusCode(200).
                and().body("id", equalTo(id_student)).
                and().body("email", equalTo(email)).
                and().body("firstName", equalTo(firstName)).
                and().body("lastName", equalTo(lastName)).
                and().log().body();
    }
}
