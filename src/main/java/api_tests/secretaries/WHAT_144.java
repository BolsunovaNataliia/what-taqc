package api_tests.secretaries;

import api_tests.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WHAT_144 extends BaseTest {

    @Test
    public void updateSecretary200Admin(){

        Map<String, String> mapChanges = new HashMap<>();

        String secretariesId = "2";
        String secretariesEmail = "JoJoDistruction@gmail.org";
        String secretariesFirstName = "Vanica";
        String secretariesLastName = "Joster";

        mapChanges.put("email", secretariesEmail);
        mapChanges.put("firstName", secretariesFirstName);
        mapChanges.put("lastName", secretariesLastName);

        given().
                header("Authorization",getAdminToken()).
                contentType(ContentType.JSON).
                body(mapChanges).
                when().put("https://whatbackend.azurewebsites.net/api/secretaries/"+secretariesId)
                .then().assertThat().statusCode(200).
                and().body("email", equalTo(mapChanges.get("email"))).
                and().body("firstName", equalTo(mapChanges.get("firstName"))).
                and().body("lastName", equalTo(mapChanges.get("lastName"))).
                and().log().body();
    }
}
