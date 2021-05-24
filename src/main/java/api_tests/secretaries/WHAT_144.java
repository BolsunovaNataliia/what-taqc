package api_tests.secretaries;

import api_tests.BaseTest;
import constants.APIConst;
import io.restassured.http.ContentType;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static constants.APIConst.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WHAT_144 extends BaseTest {

    @Test
    @Parameters("admin")
    public void updateSecretary200Admin(String path){
        String request = "secretaries/";
        Map<String, String> mapChanges = new HashMap<>();

        String secretariesId ="2";

        mapChanges.put(APIConst.Data.EMAIL, "JoJoDistruction@gmail.org");
        mapChanges.put(APIConst.Data.FIRST_NAME, "Vanica");
        mapChanges.put(APIConst.Data.LAST_NAME, "Joster");

        given().
                header(HEADER,getAdminToken(path)).
                contentType(ContentType.JSON).
                body(mapChanges).
                when().put(BASE_URL + request+secretariesId)
                .then().assertThat().statusCode(200).
                and().body(APIConst.Data.EMAIL, equalTo(mapChanges.get(APIConst.Data.EMAIL))).
                and().body(APIConst.Data.FIRST_NAME, equalTo(mapChanges.get(APIConst.Data.FIRST_NAME))).
                and().body(APIConst.Data.LAST_NAME, equalTo(mapChanges.get(APIConst.Data.LAST_NAME))).
                and().log().body();
    }
}
