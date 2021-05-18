package page.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.ArrayList;
import java.util.List;

import static constants.XPath.EditStudentsDetailsPage.*;

public class EditStudentsDetailsPage extends BasePage {

    @FindBy(xpath = LABEL_STUDENTS_DETAILS)
    private WebElement labelStudentsDetails;
    @FindBy(xpath = LABEL_EDIT_STUDENTS_DETAILS)
    private WebElement labelEditStudentsDetails;
    @FindBy(xpath = FIRST_NAME)
    private WebElement firstName;
    @FindBy(xpath = LAST_NAME)
    private WebElement lastName;
    @FindBy(xpath = EMAIL)
    private WebElement email;
    @FindBy(xpath = LIST_OF_GROUPS)
    private List<WebElement> listOfGroups;
    @FindBy(xpath = BUTTON_EXCLUDE)
    private WebElement buttonExclude;
    @FindBy(xpath = BUTTON_CLEAR)
    private WebElement buttonClear;
    @FindBy(xpath = BUTTON_SAVE)
    private WebElement buttonSave;

    public EditStudentsDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getLabelStudentsDetails(){
        return labelEditStudentsDetails.getText();
    }

    public void clickLabelStudentsDetails(){
        labelStudentsDetails.click();
    }

    public String getLabelEditStudentsDetails(){
        return labelEditStudentsDetails.getText();
    }

    public String getFirstName(){
        return firstName.getAttribute("value");
    }

    public String getLastName(){
        return lastName.getAttribute("value");
    }

    public String getEmail(){
        return email.getAttribute("value");
    }

    public List<WebElement> getListOfGroups(){
        return listOfGroups;
    }

    public List<String> getListLabelsOfGroups(){
        List<String> listLabelsOfGroups = new ArrayList<>();

        for (WebElement element: listOfGroups) {
            listLabelsOfGroups.add(element.getText());
        }
        return listLabelsOfGroups;
    }

    public int getQuantityGroup(){
        return listOfGroups.size();
    }
}
