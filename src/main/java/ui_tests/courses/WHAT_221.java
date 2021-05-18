package ui_tests.courses;

import constants.Constants;
import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.support.SupportPage;
import step.support.SupportPageStep;
import ui_tests.BaseTest;

public class WHAT_221 extends BaseTest {

    @Test
    @Parameters({"student"})
    public void displayForStudent(String path) throws InterruptedException {
        User user = ReaderFileJson.readFileJsonUser(path);

        String courseNameBefSort = "fantasy111";
        int courseIDBefSort = 7;

        signInPageStep
                // Preconditions.
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(SupportPageStep.class, driver)
                .verifySidebarItemSupport(SupportPageStep.class, SupportPage.class, true, driver)
                // Steps.
                .clickCoursesSidebar(SupportPage.class, driver)
                .verifyPageHeaderName(Constants.PageName.COURSE_LIST)
                .verifyNumberOfCoursesDisplayed(true)
                .verifySearchCourseInListInputDisplayed(true)
                .verifyCourseName(courseIDBefSort, courseNameBefSort);
    }
}
