package ui_tests.unassigned;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.unassigned.ListOfUnassignedUsersPageStep;
import ui_tests.BaseTest;

import static constants.Constants.UnassignedUsersSelectRole.*;
import static constants.Constants.UsersSort.*;

public class WHAT_51 extends BaseTest {
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
    public void atc_WHAT_51(){
        String mailOfUser = "abbadabba@gmail.com";
        String expectedSurnameUser = "Dabba";


        coursesStep.verifyUnassignedUserSurname(1, expectedSurnameUser)
                   .verifyUnassignedUserSurname(mailOfUser, expectedSurnameUser)

                   .verifyAddRoleButtonEnabled(1, true)
                   .verifyChoseSortEnabled(SYMBOL, true)

                   .verifyChoseUserRole(1, CHOOSE, true)
                   .choseUserRole(1, CHOOSE);
        coursesStep.choseSortType(SYMBOL);
        coursesStep.verifyChoseSortEnabled(SYMBOL, true)
                   .verifyChoseUserRole(1, CHOOSE, true);

    }
}
