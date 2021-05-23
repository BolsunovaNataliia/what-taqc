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

public class WHAT_173 extends BaseTest {

    @Test
    @Parameters("admin")
    public void updateSecretaryWithInvalidFirstNameSecondName400Admin(String path){
        String request = "secretaries/";
        Map<String, String> mapChanges = new HashMap<>();

        String secretariesId = "2";

        mapChanges.put(APIConst.Data.EMAIL, "JoJoDistruction@gmail.org");
        mapChanges.put(APIConst.Data.FIRST_NAME, "1233332");
        mapChanges.put(APIConst.Data.LAST_NAME, "6");

        given().
                header(HEADER,getAdminToken(path)).
                contentType(ContentType.JSON).
                body(mapChanges).
                when().put(BASE_URL + request+secretariesId)
                .then().assertThat().statusCode(400).
                and().log().body();
    }
}
