package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import static constants.XPath.Common.*;
import static constants.XPath.CourseDetailsPage.*;

public class CourseDetailsPage extends BasePage {

    @FindBy(xpath = H3)
    private WebElement pageLabel;
    @FindBy(xpath = EDIT_COURSE_DETAILS_TAB)
    private WebElement editCourseDetailsTab;
    @FindBy(xpath = COURSE_NAME)
    private WebElement courseName;

    public CourseDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickEditCourseDetailsTab(){
        editCourseDetailsTab.click();
    }

    public String getCourseNameText(){
        return courseName.getText();
    }

    public String getPageLabelText() {
        return pageLabel.getText();
    }
}
