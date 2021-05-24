package api_tests.mentor;


import api_tests.BaseTest;
import constants.APIConst.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static constants.APIConst.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_163 extends BaseTest {

    @Test
    @Parameters("admin")
    public void updateInformationAboutMentors200Admin(String path){
        String request = "mentors/";
        String id_mentor = "38";
        Map<String, String> mapChanges = new HashMap<>();

        mapChanges.put(Data.FIRST_NAME, "fsdadsa_1");
        mapChanges.put(Data.LAST_NAME, "fvcdsfvds");
        mapChanges.put(Data.EMAIL, "asddasdvhgvhj@gmail.com");


        given().
                header(HEADER,getAdminToken(path)).
                contentType(ContentType.JSON).
                body(mapChanges).
                when().put(BASE_URL+request + id_mentor).
                then().assertThat().statusCode(200).

                and().body(Data.FIRST_NAME, hasToString(mapChanges.get(Data.FIRST_NAME))).
                and().body(Data.LAST_NAME,  hasToString(mapChanges.get(Data.LAST_NAME))).
                and().body(Data.EMAIL, hasToString(mapChanges.get(Data.EMAIL))).

                and().log().body();
    }
}

