package api_tests.unassigned;

import api_tests.BaseTest;
import constants.APIConst;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class WHAT_175 extends BaseTest {

    @Test
    @Parameters("admin")
    public void getNotAssigned200Admin(String path){
        String request = "accounts/NotAssigned";
        String firstResult = "[0].%s";
        String secondResult = "[1].%s";

        String[] notAssignedUserID = new String[] {"112", "113"};
        String[] notAssignedUserFirstName = new String[] {"Student", "Secretary"};
        String[] notAssignedUserLastName = new String[] {"Student", "Secretary"};
        String[] notAssignedUserEmail = new String[] {"user+samanthamartin92@what_WH.at", "u.ser+charlesscott18@what_WH.at"};
        String[] notAssignedUserRole = new String[] {"0", "1"};
        String[] notAssignedUserIsActive = new String[] {"true", "false"};

        given().
                header(APIConst.HEADER, getAdminToken(path)).
                when().get(APIConst.BASE_URL + request).
                then().assertThat().statusCode(200).

                and().body(String.format(firstResult, APIConst.Data.ID), hasToString(notAssignedUserID[0])).
                and().body(String.format(firstResult, APIConst.Data.FIRST_NAME), hasToString(notAssignedUserFirstName[0])).
                and().body(String.format(firstResult, APIConst.Data.LAST_NAME), hasToString(notAssignedUserLastName[0])).
                and().body(String.format(firstResult, APIConst.Data.EMAIL), hasToString(notAssignedUserEmail[0])).
                and().body(String.format(firstResult, APIConst.Data.ROLE), hasToString(notAssignedUserRole[0])).
                and().body(String.format(firstResult, APIConst.Data.IS_ACTIVE), hasToString(notAssignedUserIsActive[0])).

                and().body(String.format(secondResult, APIConst.Data.ID), hasToString(notAssignedUserID[1])).
                and().body(String.format(secondResult, APIConst.Data.FIRST_NAME), hasToString(notAssignedUserFirstName[1])).
                and().body(String.format(secondResult, APIConst.Data.LAST_NAME), hasToString(notAssignedUserLastName[1])).
                and().body(String.format(secondResult, APIConst.Data.EMAIL), hasToString(notAssignedUserEmail[1])).
                and().body(String.format(secondResult, APIConst.Data.ROLE), hasToString(notAssignedUserRole[0])).
                and().body(String.format(secondResult, APIConst.Data.IS_ACTIVE), hasToString(notAssignedUserIsActive[0])).

                and().log().body();
    }
}