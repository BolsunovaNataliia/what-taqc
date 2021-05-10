package test.courses;

import constants.Constants;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class WHAT_14 extends BaseTest {

    @Test
    public void verifyValuesReturn() throws InterruptedException{
        String email = "admin.@gmail.com";
        String password = "admiN_12";
        String courseID = "0";
        String newCourseName = "Basic Course";
        String initialCourseName = "Курс для демо";

        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickCoursesSidebar(ListOfStudentPage.class,driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
                .clickCourseTableEditIcon(courseID, driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_EDIT)
                // step('1')
                // Clean 'Course name' field, verify 'Course Name' field is cleaned.
                .fillEditCourseNameInput("")
                .verifyEditCourseNameInput("")
                // step('2')
                // Fill 'Course name' field, verify it's value is 'Basic Course'.
                .fillEditCourseNameInput(newCourseName)
                .verifyEditCourseNameInput(newCourseName)
                // (step'3')
                // Click on the 'Clear' button, verify that the 'Course Name' in it's initial state.
                .clickOnResetEditCourseNameInputBtn()
                .verifyEditCourseNameInput(initialCourseName);
    }
}
