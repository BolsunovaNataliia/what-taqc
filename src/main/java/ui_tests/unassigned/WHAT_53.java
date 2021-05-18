package ui_tests.unassigned;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.unassigned.ListOfUnassignedUsersPageStep;
import ui_tests.BaseTest;

import static constants.Constants.UnassignedUsersSelectRole.*;
import static constants.Constants.UsersSort.*;

public class WHAT_53 extends BaseTest {
    ListOfUnassignedUsersPageStep coursesStep;
    SignInPage signInPage;
    @BeforeClass
    public void preCond(){
        signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        coursesStep = new ListOfUnassignedUsersPageStep(driver);
    }

    @Test
    public void atc_WHAT_53(){
        String mailOfUser = "abbadabba@gmail.com";
        String expectedSurnameUser = "Dabba";


        coursesStep.verifyUnassignedUserSurname(1, expectedSurnameUser)
                   .verifyUnassignedUserSurname(mailOfUser, expectedSurnameUser)

                   .verifyAddRoleButtonEnabled(1, true)
                   .verifyChoseSortEnabled(SURNAME, true)

                   .verifyChoseUserRole(1, MENTOR, true)
                   .choseUserRole(1, MENTOR);
        coursesStep.choseSortType(SURNAME);
        coursesStep.verifyChoseSortEnabled(SURNAME, true)
                   .verifyChoseUserRole(1, MENTOR, true);

    }
}
