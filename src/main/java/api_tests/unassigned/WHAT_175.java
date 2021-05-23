package api_tests.unassigned;


import api_tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class WHAT_175 extends BaseTest {

    @Test
    public void getNotAssigned200Admin(){

        String[] notAssignedUserID = new String[] {"115", "116"};
        String[] notAssignedUserFirstName = new String[] {"FirstName", "John"};
        String[] notAssignedUserLastName = new String[] {"LastName", "Doe"};
        String[] notAssignedUserEmail = new String[] {"u.s.e.r+averyrobinson33@what_WH.at", "u.se.r+stevebabyak82@what_WH.at"};
        String[] notAssignedUserRole = new String[] {"0", "1"};
        String[] notAssignedUserIsActive = new String[] {"true", "false"};

        given().
                header("Authorization",getAdminToken()).
                when().get("https://whatbackend.azurewebsites.net/api/accounts/NotAssigned").
                then().assertThat().statusCode(200).

                and().body("[0].id", hasToString(notAssignedUserID[0])).
                and().body("[0].firstName", hasToString(notAssignedUserFirstName[0])).
                and().body("[0].lastName", hasToString(notAssignedUserLastName[0])).
                and().body("[0].email", hasToString(notAssignedUserEmail[0])).
                and().body("[0].role", hasToString(notAssignedUserRole[0])).
                and().body("[0].isActive", hasToString(notAssignedUserIsActive[0])).

                and().body("[1].id", hasToString(notAssignedUserID[1])).
                and().body("[1].firstName", hasToString(notAssignedUserFirstName[1])).
                and().body("[1].lastName", hasToString(notAssignedUserLastName[1])).
                and().body("[1].email", hasToString(notAssignedUserEmail[1])).
                and().body("[1].role", hasToString(notAssignedUserRole[0])).
                and().body("[1].isActive", hasToString(notAssignedUserIsActive[0])).

                and().log().body();
    }
}