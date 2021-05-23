package ui_tests.lesson.edit;

import constants.Constants;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import service.ReaderFileJson;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class LessonEditPageTest extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void exampleLessonTest(String path) {
        User user = ReaderFileJson.readFileJsonUser(path);

        String themeName = "Types";
        String groupName = "Griffindorrr";
        String fullName = "Pavel Kundenko";
        String mark = "11";
        int studentId = 1;

        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickLessonSidebar(ListOfStudentPage.class, driver)
                .clickLessonEdit(1, driver)
                .verifyNamePage(Constants.PageName.LESSON_EDIT)
                .verifyThemeName(themeName)
                .verifyThemeNameEnabled(true)
                .verifyGroupName(groupName)
                .verifyGroupNameEnabled(false)
                .verifyDateInputEnabled(true)
                .verifyCancelButtonEnabled(true)
                .verifySaveButtonEnabled(true)
                .verifyFullStudentName(studentId, fullName)
                .verifyMark(studentId, mark)
                .verifyPresence(studentId, true)
                .getToStudentDetailsPage(studentId, driver);
    }
}
