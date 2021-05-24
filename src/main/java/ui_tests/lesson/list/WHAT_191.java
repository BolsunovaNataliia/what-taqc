package ui_tests.lesson.list;

import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.myprofile.MyProfilePage;
import page.student.ListOfStudentPage;
import service.ReaderFileJson;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

import java.util.List;

/**
 * Description
 */

public class WHAT_191 extends BaseTest {

    @Test
    @Parameters({"adminSecretMentActive"})
    public void atc_WHAT_191(String path) {
        //admin, secretary, mentors
        List<User> users = ReaderFileJson.readFileJsonListUser(path);

        // step('preconditions')
        for (User user : users) {
            signInPageStep
                    .setEmail(user.getEmail())
                    .setPassword(user.getPassword())
                    .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                    // step('1')
                    .verifySidebarItemLessons(ListOfStudentsPageStep.class, ListOfStudentPage.class, true, driver)
                    .clickLogOut(MyProfilePage.class, driver);
        }
    }

}
