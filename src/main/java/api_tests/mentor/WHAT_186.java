package api_tests.mentor;


import api_tests.BaseTest;
import constants.APIConst;
import io.restassured.http.ContentType;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static constants.APIConst.BASE_URL;
import static constants.APIConst.HEADER;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_186 extends BaseTest {

    @Test
    @Parameters("admin")
    public void createMentor200Admin(String path){
        String request = "mentors/";
        int id_notAssigned = 122;
        Map <String, String> mentorMap = new HashMap<>();
        mentorMap.put(APIConst.Data.ROLE,"2");

        given().
                header(HEADER,getAdminToken(path)).
                contentType(ContentType.JSON).
                body(mentorMap).
                when().post(BASE_URL + request+ id_notAssigned).
                then().assertThat().statusCode(200).

                and().body(APIConst.Data.ROLE, hasToString(mentorMap.get(APIConst.Data.ROLE))).

                and().log().body();
    }
}