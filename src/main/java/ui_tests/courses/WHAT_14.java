package ui_tests.courses;

import constants.Constants;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class WHAT_14 extends BaseTest {

    @Test(groups = "admin" )
    public void verifyValuesReturn() throws InterruptedException{

        String courseID = "0";
        String newCourseName = "Basic Course";
        String initialCourseName = "Курс для демо";

        signInPageStep
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickCoursesSidebar(ListOfStudentPage.class,driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
                .clickCourseTableEditIcon(courseID, driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_EDIT)
                // step('1')
                // Clean 'Course name' field, verify 'Course Name' field is cleaned.
                .fillEditCourseNameInput(Constants.EMPTY_STRING)
                .verifyEditCourseNameInput(Constants.EMPTY_STRING)
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
