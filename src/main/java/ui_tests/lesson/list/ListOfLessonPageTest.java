package ui_tests.lesson.list;

import constants.Constants;
import service.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class ListOfLessonPageTest extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void exampleLessonTest(String path) {
        User user = ReaderFileJson.readFileJsonUser(path);

        String count = "19 lessons";
        String themeName = "Types";
        String date = "Sat Feb 01 2020";
        String time = "00:00:00";

        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
                .clickLessonSidebar(ListOfStudentPage.class,driver)
                .verifyNamePage(Constants.PageName.LESSON_LIST)
                .verifyAddLessonBtnEnabled(true)
                .verifyButtonPageEnabled(1, true)
                .verifyButtonPageEnabled(2,true)
                .verifyCountOfLessons(count)
                .verifyRowCellText(1,1, themeName)
                .verifyRowCellText(1,2, date)
                .verifyRowCellText(1, 3, time)
                .clickLessonDetails(1, driver)
                .verifyNamePage(Constants.PageName.LESSON_DETAILS)
                .verifyTime(time)
                .verifyThemeName(themeName)
                .clickCancelButton(driver)
                .clickLessonEdit(1,driver)
                .verifyNamePage(Constants.PageName.LESSON_EDIT)
                .verifyThemeNameEnabled(true)
                .verifyThemeName(themeName)
                .clickCancelButton(driver)
                .clickSorting(1);
    }

}
