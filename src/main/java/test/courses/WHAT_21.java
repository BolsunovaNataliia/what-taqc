package test.courses;

import constants.Constants;
import constants.Messages.Errors;
import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class WHAT_21 extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void verifySearchFillingSymbols(String path) throws InterruptedException {
        User user = ReaderFileJson.readFileJsonUser(path);

        String invalidCourseName = "!@#$%^&*()";

        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickCoursesSidebar(ListOfStudentPage.class, driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
        // (step'1')
        // Click on the 'Add a course' button, verify the 'Add a course' page opened.
                .clickAddCourseToListBtn(driver)
                .verifyPageHeaderText(Constants.PageName.COURSE_ADD)
        // (step'2')
        // Fill the 'Course name' input with an invalid name, verify error message 'Invalid course name'
        // appeared and verify that 'Save' button disabled.
                .fillCourseNameInput(invalidCourseName)
                .verifyInvalidCourseMessageText(Errors.INVALID_COURSE_NAME)
                .verifySubmitButtonEnabled(false);
    }
}
