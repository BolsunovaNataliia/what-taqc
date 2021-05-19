package page.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.List;

import static constants.XPath.Common.H2;
import static constants.XPath.CoursesPage.*;

public class CoursesPage extends BasePage {

    @FindBy(xpath = ADD_COURSE_TO_LIST_BTN)
    private WebElement addCourseToListBtn;
    @FindBy(xpath = SEARCH_COURSE_IN_LIST_INPUT)
    private WebElement searchCourseInListInput;
    @FindBy(xpath = COURSE_LIST_ID_SORT_TYPE)
    private WebElement courseListIDSortType;
    @FindBy(xpath = COURSE_LIST_NAME_SORT_TYPE)
    private WebElement courseListNameSortType;
    @FindBy(xpath = LIST_OF_COURSE_TABLE_ROWS)
    private List <WebElement> listOfCourseTableRows;
    @FindBy(xpath = LIST_OF_COURSE_TABLE_EDIT_ICONS)
    private List <WebElement> listOfCourseTableEditIcons;
    @FindBy(xpath = LEFT_NAVIGATION_ARROW_BTN)
    private WebElement leftNavigationArrowBtn;
    @FindBy(xpath = RIGHT_NAVIGATION_ARROW_BTN)
    private WebElement rightNavigationArrowBtn;
    @FindBy(xpath = H2)
    private WebElement pageHeader;
    @FindBy(xpath = NUMBER_OF_COURSES)
    private WebElement numberOfCourses;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeaderText(){
        return pageHeader.getText();
    }

    public boolean isNumberOfCoursesDisplayed(){
        return numberOfCourses.isDisplayed();
    }

    public boolean isSearchCourseInListInputDisplayed(){
        return searchCourseInListInput.isDisplayed();
    }

    public boolean isAddCourseToListBtnDisplayed(){
        return addCourseToListBtn.isDisplayed();
    }

    public String getCourseNameText(Integer courseID){
        String courseIDXpath = "//tr[@data-student-id='"+ courseID +"']/td[1]";
        String courseNameXpath = "//tr[@data-student-id='"+ courseID +"']/td[2]";
        if (!listOfCourseTableRows.isEmpty()) {
            for (WebElement webElement : listOfCourseTableRows) {
                if (webElement.findElement(By.xpath(courseIDXpath)).getText().equals(courseID.toString())) {
                    return webElement.findElement(By.xpath(courseNameXpath)).getText();
                }
            }
        }
        return null;
    }

    public void clickAddCourseToListBtn(){
        addCourseToListBtn.click();
    }

    public void fillSearchCourseInListInput(String title){
        searchCourseInListInput.clear();
        searchCourseInListInput.sendKeys(title);
    }

    public void changeCourseListIDSortType(){
        courseListIDSortType.click();
    }

    public void changeCourseListNameSortType(){
        courseListNameSortType.click();
    }

    public void clickCourseTableRow(String id){
        try { listOfCourseTableRows.get(Integer.parseInt(id)).click(); }
        catch (NumberFormatException | IndexOutOfBoundsException e) { System.out.println("Exception"); }
    }

    public void clickCourseTableEditIcon(String id){
        try { listOfCourseTableEditIcons.get(Integer.parseInt(id)).click(); }
        catch (NumberFormatException | IndexOutOfBoundsException e) { System.out.println("Exception"); }
    }

    public void clickLeftNavigationArrowBtn(){
        leftNavigationArrowBtn.click();
    }

    public void clickRightNavigationArrowBtn(){
        rightNavigationArrowBtn.click();
    }
}
