package ui_tests.unassigned;

import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import service.ReaderFileJson;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

import static constants.Constants.UnassignedUsersSelectRole.STUDENT;
import static constants.Constants.UsersSort.NAME;

public class WHAT_52 extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void atc_WHAT_52(String path){
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
                .verifyChoseSortEnabled(NAME, true)

                .verifyChoseUserRole(1, STUDENT, true)
                .choseUserRole(1, STUDENT)
                .choseSortType(NAME)
                .verifyChoseSortEnabled(NAME, true)
                .verifyChoseUserRole(1, STUDENT, true);

    }
}
