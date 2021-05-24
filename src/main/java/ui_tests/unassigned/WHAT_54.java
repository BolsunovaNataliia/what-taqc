package ui_tests.unassigned;

import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import service.ReaderFileJson;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

import static constants.Constants.UnassignedUsersSelectRole.SECRETARY;
import static constants.Constants.UsersSort.EMAIL;

public class WHAT_54 extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void atc_WHAT_54(String path){
        User user = ReaderFileJson.readFileJsonUser(path);
        String mailOfUser = "abbadabba@gmail.com";
        String expectedSurnameUser = "Dabba";


        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickUnassignedSidebar(ListOfStudentPage.class, driver)
                .verifyUnassignedUserSurname(1, expectedSurnameUser)
                .verifyUnassignedUserSurname(mailOfUser, expectedSurnameUser)
                .verifyAddRoleButtonEnabled(1, true)
                .verifyChoseSortEnabled(EMAIL, true)
                .verifyChoseUserRole(1, SECRETARY, true)
                .choseUserRole(1, SECRETARY)
                .choseSortType(EMAIL)
                .verifyChoseSortEnabled(EMAIL, true)
                .verifyChoseUserRole(1, SECRETARY, true);

    }
}
