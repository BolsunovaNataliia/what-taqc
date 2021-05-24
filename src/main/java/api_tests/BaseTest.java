package api_tests;

import constants.APIConst;
import entity.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.ReaderFileJson;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class BaseTest extends BaseSetUp {

    public String getAdminToken(String path){
        User user = ReaderFileJson.readFileJsonUser(path);
        Map<String, String> credMap = new HashMap<>();
        String request = "accounts/auth";

        credMap.put(APIConst.Data.EMAIL, user.getEmail());
        credMap.put(APIConst.Data.PASSWORD, user.getPassword());
        Response response = given()
                .body(credMap)
                .contentType(ContentType.JSON)
                .when()
                .post(APIConst.BASE_URL + request);
        System.out.println(response.getHeader(APIConst.HEADER));
        return response.getHeader(APIConst.HEADER);
    }


}
