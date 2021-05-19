package step.courses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.courses.CourseDetailsPage;
import step.BaseStep;

public class CourseDetailsStep extends BaseStep {
    private final CourseDetailsPage courseDetailsPage;

    public CourseDetailsStep(WebDriver driver){
        courseDetailsPage = new CourseDetailsPage(driver);
    }

    public CourseDetailsStep verifyCourseName(String expected){
        Assert.assertEquals(courseDetailsPage.getCourseNameText(), expected);
      return this;
    }

    public CourseDetailsStep verifyPageLabelText(String expected){
        Assert.assertEquals(courseDetailsPage.getPageLabelText(), expected);
      return this;
    }

    public EditCourseDetailsStep clickEditCourseDetailsTab(WebDriver driver){
        courseDetailsPage.clickEditCourseDetailsTab();
      return new EditCourseDetailsStep(driver);
    }
}
