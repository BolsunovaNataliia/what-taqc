package api_tests.mentor;


import api_tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

public class WHAT_163 extends BaseTest {

    @Test
    public void updateInformationAboutMentors200Admin(){
        String id_mentor = "38";
        Map<String, String> mapChanges = new HashMap<>();

        mapChanges.put("firstName", "fsdadsa_1");
        mapChanges.put("lastName", "fvcdsfvds");
        mapChanges.put("email", "asddasdvhgvhj@gmail.com");


        given().
                header("Authorization", getAdminToken()).
                contentType(ContentType.JSON).
                body(mapChanges).
                when().put("https://whatbackend.azurewebsites.net/api/mentors/" + id_mentor).
                then().assertThat().statusCode(200).

                and().body("firstName", hasToString(mapChanges.get("firstName"))).
                and().body("lastName",  hasToString(mapChanges.get("lastName"))).
                and().body("email",     hasToString(mapChanges.get("email"))).


                and().log().body();
    }
}

