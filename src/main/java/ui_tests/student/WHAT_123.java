package ui_tests.student;

import constants.Constants;
import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class WHAT_123 extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void verifyStudentsPageSwitchBetweenTabs(String path){
        User user = ReaderFileJson.readFileJsonUser(path);
        String firstName = "student";
        String lastName = "student";
        String emailStudent = "student@gmail.com";

        // step('preconditions')
        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickStudentsSidebar(ListOfStudentPage.class, driver)
        // step('1')
                .clickEditStudent(driver)
                .verifyLabelEditStudentsDetails(Constants.PageName.STUDENT_EDIT_DETAILS)
                .verifyFirstName(firstName)
                .verifyLastName(lastName)
                .verifyEmail(emailStudent)
                .verifyListOfGroupsIsDisplayed()
        // step('2')
                .clickLabelStudentsDetails(driver)
                .verifyLabel(Constants.PageName.STUDENT_DETAILS)
                .verifyFirstName(firstName)
                .verifyLastName(lastName)
                .verifyEmail(emailStudent)
                .verifyListOfGroupsIsDisplayed();
    }
}
