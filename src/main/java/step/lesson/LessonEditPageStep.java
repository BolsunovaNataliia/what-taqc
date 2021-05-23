package step.lesson;

import constants.Messages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.lesson.LessonEditPage;
import step.BaseStep;
import step.student.StudentDetailsPageStep;

public class LessonEditPageStep extends BaseStep {

    LessonEditPage lessonEditPage;

    public LessonEditPageStep(WebDriver driver) {
        lessonEditPage = new LessonEditPage(driver);
    }

    public LessonEditPageStep verifyNamePage(String expected) {
        Assert.assertEquals(lessonEditPage.getPageName(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "PageName"));
        return this;
    }

    public LessonEditPageStep verifyThemeName(String expected) {
        Assert.assertEquals(lessonEditPage.getThemeName(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "ThemeName"));
        return this;
    }

    public LessonEditPageStep verifyGroupName(String expected) {
        Assert.assertEquals(lessonEditPage.getGroupName(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "GroupName"));
        return this;
    }

    public LessonEditPageStep verifyFullStudentName(int studentId, String expected) {
        Assert.assertEquals(lessonEditPage.getFullStudentName(studentId), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "FullStudentName"));
        return this;
    }

    public LessonEditPageStep verifyMark(int studentId, String expected) {
        Assert.assertEquals(lessonEditPage.getMark(studentId), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "Mark"));
        return this;
    }

    public LessonEditPageStep verifyPresence(int studentId, boolean expected) {
        Assert.assertEquals(lessonEditPage.getPresence(studentId), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "Presence"));
        return this;
    }

    public LessonEditPageStep verifyGroupNameEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isGroupNameEnabled(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "GroupName enabled"));
        return this;
    }

    public LessonEditPageStep verifyThemeNameEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isThemeNameInputEnabled(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "ThemeName enabled"));
        return this;
    }

    public LessonEditPageStep verifyDateInputEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isDateInputEnabled(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "DateInput enabled"));
        return this;
    }

    public LessonEditPageStep verifyCancelButtonEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isCancelButtonEnabled(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "CancelButton enabled"));
        return this;
    }

    public LessonEditPageStep verifySaveButtonEnabled(boolean expected) {
        Assert.assertEquals(lessonEditPage.isSaveButtonEnabled(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "SaveButton enabled"));
        return this;
    }

    public LessonEditPageStep setThemeName(String name) {
        lessonEditPage.setThemeName(name);
        return this;
    }

    public LessonEditPageStep setDateInput(String dateInput) {
        lessonEditPage.setDateInput(dateInput);
        return this;
    }

    public LessonEditPageStep clickPresenceOfStudent(int number) {
        lessonEditPage.clickPresence(number);
        return this;
    }

    public LessonEditPageStep setMarkOfStudent(int number, int input) {
        lessonEditPage.setMark(number, input);
        return this;
    }

    public ListOfLessonPageStep clickCancelButton(WebDriver driver) {
        lessonEditPage.clickCancelButton();
        return new ListOfLessonPageStep(driver);
    }

    public ListOfLessonPageStep clickSaveButton(ListOfLessonPageStep context, WebDriver driver) {
        lessonEditPage.clickSaveButton();
        return context;
    }

    public StudentDetailsPageStep getToStudentDetailsPage(int number, WebDriver driver) {
        lessonEditPage.clickStudent(number);
        return new StudentDetailsPageStep(driver);
    }

}
