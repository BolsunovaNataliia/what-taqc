package ui_tests.lesson.list;

import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

/**
 * Description
 */

public class WHAT_191 extends BaseTest {

    //TODO parametrized
    @Test
    public void atc_WHAT_191() {
        //admin, secretary, mentors
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        // step('preconditions')
        signInPageStep
                .setEmail(email)
                .setPassword(password)
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
        // step('1')
                .verifySidebarItemLessons(ListOfStudentsPageStep.class, ListOfStudentPage.class,true, driver);
    }

}
