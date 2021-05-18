package ui_tests.lesson.edit;

import constants.Constants;
import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

/**
 * Description of test
 */

public class WHAT_201 extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void atc_WHAT_201(String path) {
        User user = ReaderFileJson.readFileJsonUser(path);
        //admin, mentors
        int lessonId = 1;
        String oldName = "Types";
        String newName = "nameLessonNew";
        String dateTime = "080520212154";

        // step('preconditions')
        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
                .clickLessonSidebar(ListOfStudentPage.class, driver)
                .verifyNamePage(Constants.PageName.LESSON_LIST)
                .verifyRowCellText(lessonId,1, oldName)
        // step('1')
                .clickLessonEdit(lessonId,driver)
                .setThemeName(newName)
                .setDateInput(dateTime);
        // step('2')
//                .clickSaveButton(new ListOfLessonPageStep(driver),driver)
//                .verifyRowCellText(lessonId,2, newName);
    }

}
