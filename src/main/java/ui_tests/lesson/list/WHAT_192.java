package ui_tests.lesson.list;

import service.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.lesson.ListOfLessonPage;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

/**
 * Description
 */

public class WHAT_192 extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void atc_WHAT_192(String path) {
        User user = ReaderFileJson.readFileJsonUser(path);

        // step('preconditions')
        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
        // step('1')
                .verifySidebarItemLessons(ListOfStudentsPageStep.class, ListOfStudentPage.class,true, driver)
                .clickLessonSidebar(ListOfLessonPage.class, driver)
                .verifyAddLessonBtnEnabled(true)
                .verifyEditBtnEnabled(1,true);
    }

}
