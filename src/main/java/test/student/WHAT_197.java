package test.student;

import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class WHAT_197 extends BaseTest {

    @Test
    public void verifyStudentDetailsLessonsDisplayed(String path){
        User user = ReaderFileJson.readFileJsonUser(path);


        // step('preconditions')
        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickStudentsSidebar(ListOfStudentPage.class, driver)
        // step('1')
                .clickCurrentStudent(driver)
                .verifyListOfLessonsIsDisplayed();
    }
}
