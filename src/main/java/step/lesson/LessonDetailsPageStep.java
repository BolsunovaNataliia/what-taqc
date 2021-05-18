package step.lesson;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.lesson.LessonDetailsPage;
import step.BaseStep;
import step.student.StudentDetailsPageStep;

public class LessonDetailsPageStep extends BaseStep {

    LessonDetailsPage lessonDetailsPage;

    public LessonDetailsPageStep(WebDriver driver){
        lessonDetailsPage = new LessonDetailsPage(driver);
    }

    public LessonDetailsPageStep verifyNamePage(String expected){
        Assert.assertEquals(lessonDetailsPage.getPageName(),expected);
        return this;
    }

    public LessonDetailsPageStep verifyThemeName(String expected){
        Assert.assertEquals(lessonDetailsPage.getThemeName(),expected);
        return this;
    }

    public LessonDetailsPageStep verifyGroupName(String expected){
        Assert.assertEquals(lessonDetailsPage.getGroupName(),expected);
        return this;
    }

    public LessonDetailsPageStep verifyMentorName(String expected){
        Assert.assertEquals(lessonDetailsPage.getMentorName(),expected);
        return this;
    }

    public LessonDetailsPageStep verifyDate(String expected){
        Assert.assertEquals(lessonDetailsPage.getDate(),expected);
        return this;
    }

    public LessonDetailsPageStep verifyTime(String expected){
        Assert.assertEquals(lessonDetailsPage.getTime(),expected);
        return this;
    }

    public LessonDetailsPageStep verifyFullStudentName(int studentId, String expected){
        Assert.assertEquals(lessonDetailsPage.getFullStudentName(studentId),expected);
        return this;
    }
    public LessonDetailsPageStep verifyMark(int studentId, String expected){
        Assert.assertEquals(lessonDetailsPage.getMark(studentId),expected);
        return this;
    }
    public LessonDetailsPageStep verifyPresence(int studentId, boolean expected){
        Assert.assertEquals(lessonDetailsPage.getPresence(studentId),expected);
        return this;
    }

    public LessonDetailsPageStep verifyCancelButtonEnabled(boolean expected){
        Assert.assertEquals(lessonDetailsPage.isCancelButtonEnabled(),expected);
        return this;
    }

    public ListOfLessonPageStep clickCancelButton(WebDriver driver){
        lessonDetailsPage.clickCancelButton();
        return new ListOfLessonPageStep(driver);
    }

    public StudentDetailsPageStep getToStudentDetailsPage(int number, WebDriver driver){
        lessonDetailsPage.clickStudent(number);
        return new StudentDetailsPageStep(driver);
    }

    public void getToStudentDetailsPage(String name){
        lessonDetailsPage.clickStudent(name);
    }

    public void getToMentorDetailsPage(){
        lessonDetailsPage.clickMentor();
    }

    public void getToGroupDetailsPage(){
        lessonDetailsPage.clickGroup();
    }
}
