package api_tests.signin;

import entity.User;
import io.restassured.http.ContentType;
import org.testng.annotations.Parameters;
import service.DBWorker;
import org.testng.annotations.Test;
import service.ReaderFileJson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class WHAT_155 {

    @Test
    @Parameters({"usersForSignIn"})
    public void WHAT_155(String path) {
        List<User> user = ReaderFileJson.readFileJsonListUser(path);
        List<Integer> responseCode = Arrays.asList(200, 403, 401);
        Map<String, String> credMap = new HashMap<>();

        for (int i = 0; i < user.size(); i++) {
            credMap.put("email", user.get(i).getEmail());
            credMap.put("password", user.get(i).getPassword());
            given()
                    .body(credMap)
                    .contentType(ContentType.JSON)
                    .when()
                    .post("https://whatbackend.azurewebsites.net/api/accounts/auth")
                    .then().assertThat().statusCode(responseCode.get(i))
                    .and().log().body();
        }

    }
}
