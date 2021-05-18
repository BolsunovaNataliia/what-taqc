package ui_tests.myProfile;

import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;
import constants.Constants;

/**
 * This test case verifies that any @User from UsersDifferentRoleRegisteredInSystem.csv
 * (Secretary, Mentor, Student) has access to his personal data and can get
 * correct data about his profile.
 */

public class WHAT_190 extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void atc_WHAT_190(String path) {
        User user = ReaderFileJson.readFileJsonUser(path);

        // step('preconditions')
        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
                .clickMyProfile(ListOfStudentPage.class,driver)
        // step('1')
                .verifyPageName(Constants.PageName.MY_PROFILE)
                .verifyFirstName(user.getFirst_name())
                .verifyLastName(user.getLast_name())
                .verifyEmailAddress(user.getEmail())
                .verifyChangePasswordBtnEnabled();
    }
}
