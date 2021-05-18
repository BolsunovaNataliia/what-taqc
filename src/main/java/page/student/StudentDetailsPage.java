package page.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.ArrayList;
import java.util.List;

import static constants.XPath.StudentDetailsPage.*;

public class StudentDetailsPage extends BasePage {

    @FindBy(xpath = LABEL_STUDENTS_DETAILS)
    private WebElement labelStudentsDetails;

    @FindBy(xpath = FIRST_NAME)
    private WebElement firstName;

    @FindBy(xpath = LAST_NAME)
    private WebElement lastName;

    @FindBy(xpath = EMAIL)
    private WebElement email;

    @FindBy(xpath = LIST_OF_GROUPS)
    private List<WebElement> listOfGroups;

    @FindBy(xpath = LIST_OF_LESSONS)
    private List<WebElement> listOfLessons;

    public StudentDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getLabel(){
        return labelStudentsDetails.getText();
    }

    public String getFirstName(){
        return firstName.getText();
    }

    public String getLastName(){
        return lastName.getText();
    }

    public String getEmail(){
        return email.getText();
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

    public List<WebElement> getListOfLessons(){
        return listOfLessons;
    }

    public List<String> getListLabelsOfLessons(){
        List<String> listLabelsOfLessons = new ArrayList<>();

        for (WebElement element: listOfLessons) {
            listLabelsOfLessons.add(element.getText());
        }
        return listLabelsOfLessons;
    }

    public int getQuantityLessons(){
        return listOfLessons.size();
    }
}
