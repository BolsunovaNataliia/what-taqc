package page.courses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import static constants.XPath.Common.*;

public class AddCoursePage extends BasePage {

    @FindBy(xpath = H3)
    private WebElement pagesLabel;
    @FindBy(xpath = COURSE_NAME_INPUT)
    private WebElement courseNameInput;
    @FindBy(xpath = SAVE_BUTTON)
    private WebElement submitNewCourseBtn;
    @FindBy(xpath = "//div[contains(@class,'d-flex')]/a[.='Cancel']")
    private WebElement cancelCourseAddingBtn;
    @FindBy(xpath = "//h3")
    private WebElement pageHeader;
    @FindBy(xpath = "//p[contains(text(),Invalid)]")
    private WebElement invalidCourseNameError;

    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeaderText(){
        return pageHeader.getText();
    }

    public String getInvalidCourseNameError(){
        return invalidCourseNameError.getText();
    }

    public void fillCourseNameInput(String courseName) {
        waitVisibility(courseNameInput, 1);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.evaluate('//input', document, null, 9, null).singleNodeValue.value = ''");
        courseNameInput.sendKeys(courseName);
    }

    public void clickCancelCourseAddingBtn() {
        cancelCourseAddingBtn.click();
    }

    public void clickSubmitNewCourseBtn(){
        submitNewCourseBtn.click();
    }

    public boolean isSubmitBtnEnabled() {
        return submitNewCourseBtn.isEnabled();
    }
}
