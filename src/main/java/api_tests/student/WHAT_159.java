package api_tests.student;

import api_tests.BaseTest;
import constants.APIConst;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WHAT_159 extends BaseTest {

    @Test
    @Parameters("admin")
    public void getApiStudentsId200Admin(String path){
        String request = "students/";
        int id_student = 4;
        String email = "name_stud@gmail.com";
        String firstName = "FirstNameStud";
        String lastName = "LastNameStud";

        given().
                header(APIConst.HEADER,getAdminToken(path)).
                when().get(APIConst.BASE_URL+ request + id_student).
                then().assertThat().statusCode(200).
                and().body(APIConst.Data.ID, equalTo(id_student)).
                and().body(APIConst.Data.EMAIL, equalTo(email)).
                and().body(APIConst.Data.FIRST_NAME, equalTo(firstName)).
                and().body(APIConst.Data.LAST_NAME, equalTo(lastName)).
                and().log().body();
    }
}
