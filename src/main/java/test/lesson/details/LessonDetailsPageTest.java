package test.lesson.details;

import constants.Constants;
import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class LessonDetailsPageTest extends BaseTest {

    @Test(groups = { "admin" })
    @Parameters({"user"})
    public void  exampleLessonTest(String path) {
        User user = ReaderFileJson.readFileJsonUser(path);

        String themeName = "Types";
        String groupName = "Griffindorrr";
        String mentorName = "Леголас New";
        String lessonDate = "2020-02-01";
        String lessonTime = "00:00:00";
        String fullName = "Pavel Kundenko";
        String mark = "11";
        int studentId = 1;

        signInPageStep
                .clickSignInBtn(ListOfStudentsPageStep.class,driver)
                .clickLessonSidebar(ListOfStudentPage.class,driver)
                .clickLessonDetails(1, driver)
                .verifyNamePage(Constants.PageName.LESSON_DETAILS)
                .verifyThemeName(themeName)
                .verifyGroupName(groupName)
                .verifyMentorName(mentorName)
                .verifyDate(lessonDate)
                .verifyTime(lessonTime)
                .verifyCancelButtonEnabled(true)
                .verifyFullStudentName(studentId,fullName)
                .verifyMark(studentId, mark)
                .verifyPresence(studentId,true)
                .clickCancelButton(driver);
    }
}
