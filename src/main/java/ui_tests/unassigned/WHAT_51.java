package ui_tests.unassigned;

import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import service.ReaderFileJson;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

import static constants.Constants.UnassignedUsersSelectRole.CHOOSE;
import static constants.Constants.UsersSort.SYMBOL;

public class WHAT_51 extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void atc_WHAT_51(String path){
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
                .verifyChoseSortEnabled(SYMBOL, true)
                .verifyChoseUserRole(1, CHOOSE, true)
                .choseUserRole(1, CHOOSE)
                .choseSortType(SYMBOL)
                .verifyChoseSortEnabled(SYMBOL, true)
                .verifyChoseUserRole(1, CHOOSE, true);

    }
}
