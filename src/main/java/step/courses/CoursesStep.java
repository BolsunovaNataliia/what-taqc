package step.courses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.courses.CoursesPage;
import step.BaseStep;

public class CoursesStep extends BaseStep {
    private final CoursesPage coursesPage;

    public CoursesStep(WebDriver driver) {
        coursesPage = new CoursesPage(driver);
    }

    public CoursesStep verifyPageHeaderName(String expected){
        Assert.assertEquals(coursesPage.getPageHeaderText(), expected);
      return this;
    }

    public CoursesStep verifyAddCourseToListBtnDisplayed(boolean expected){
        Assert.assertEquals(coursesPage.isAddCourseToListBtnDisplayed(), expected);
      return this;
    }

    public CoursesStep verifyNumberOfCoursesDisplayed(boolean expected){
        Assert.assertEquals(coursesPage.isNumberOfCoursesDisplayed(), expected);
      return this;
    }

    public CoursesStep verifySearchCourseInListInputDisplayed(boolean expected){
        Assert.assertEquals(coursesPage.isSearchCourseInListInputDisplayed(), expected);
      return this;
    }

    public CoursesStep verifyCourseName(int courseID, String expected){
        Assert.assertEquals(coursesPage.getCourseNameText(courseID), expected);
      return this;
    }

    public AddCourseStep clickAddCourseToListBtn(WebDriver driver){
        coursesPage.clickAddCourseToListBtn();
      return new AddCourseStep(driver);
    }
    public CourseDetailsStep clickCourseTableRow(String id, WebDriver driver){
        coursesPage.clickCourseTableRow(id);
        return new CourseDetailsStep(driver);
    }

    public EditCourseDetailsStep clickCourseTableEditIcon(String id, WebDriver driver){
        coursesPage.clickCourseTableEditIcon(id);
        return new EditCourseDetailsStep(driver);
    }
    public CoursesStep fillSearchCourseInListInput(String title){
        coursesPage.fillSearchCourseInListInput(title);
      return this;
    }
    public CoursesStep changeCourseListIDSortType(){
        coursesPage.changeCourseListIDSortType();
      return this;
    }
    public CoursesStep changeCourseListNameSortType(){
        coursesPage.changeCourseListNameSortType();
      return this;
    }
    public CoursesStep clickLeftNavigationArrowBtn(){
        coursesPage.clickLeftNavigationArrowBtn();
      return this;
    }
    public CoursesStep clickRightNavigationArrowBtn(){
        coursesPage.clickRightNavigationArrowBtn();
      return this;
    }

}
