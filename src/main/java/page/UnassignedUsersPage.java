package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import component.WebElements.UnassignedUsersSort;
import test.Constants;
import java.util.List;

public class UnassignedUsersPage extends BasePage {

    private static final String EMAIL_XPATH = "//tr/td[4]";
    private static final String ADD_ROLE_XPATH = "//button[text()='Add role']";
    private static final String CELL_XPATH = "//td";

    @FindBy(xpath = "//input[contains(@class,'searchInput')]")
    private WebElement inputPerson;
    @FindBy(xpath = "//tr/th/span")
    private List<WebElement> sortUnassignedUsers;
    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> tableContent;

    public UnassignedUsersPage(WebDriver driver) {
        super(driver);
    }

    public String getIdUser(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(0).getText();

        return null;
    }

    public String getUnassignedUser(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(1).getText();

        return null;
    }

    public String getUnassignedUser(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(1).getText();

        return null;
    }

    public String getSurnameUser(int number) {

        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(2).getText();

        return null;
    }

    public String getSurnameUser(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(2).getText();

        return null;
    }

    public String getEmailUser(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(3).getText();

        return null;
    }

    public void addRoleButtonClick(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            row.get(4).findElement(By.xpath(ADD_ROLE_XPATH)).click();
    }

    public void choseSort(String unassignedUsers) {

        switch (unassignedUsers) {
            case UnassignedUsersSort.SYMBOL:
                sortUnassignedUsers.get(Integer.parseInt(UnassignedUsersSort.SYMBOL)).click();
                break;
            case UnassignedUsersSort.NAME:
                sortUnassignedUsers.get(Integer.parseInt(UnassignedUsersSort.NAME)).click();
                break;
            case UnassignedUsersSort.SURNAME:
                sortUnassignedUsers.get(Integer.parseInt(UnassignedUsersSort.SURNAME)).click();
                break;
            case UnassignedUsersSort.EMAIL:
                sortUnassignedUsers.get(Integer.parseInt(UnassignedUsersSort.EMAIL)).click();
                break;
        }
    }

    public void choseUserRole(int number, String unassignedUsers) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            row.get(4).findElement(By.xpath("//select")).click();
        switch (unassignedUsers) {
            case Constants.UnassignedUsersSelectRole.CHOOSE:
                row.get(4).findElement(By.xpath("//select//option[@value='0']")).click();
                break;
            case Constants.UnassignedUsersSelectRole.STUDENT:
                row.get(4).findElement(By.xpath("//select//option[@value='1']")).click();
                break;
            case Constants.UnassignedUsersSelectRole.MENTOR:
                row.get(4).findElement(By.xpath("//select//option[@value='2']")).click();
                break;
            case Constants.UnassignedUsersSelectRole.SECRETARY:
                row.get(4).findElement(By.xpath("//select//option[@value='3']")).click();
                break;
        }
    }

    private List<WebElement> getElementsOfMass(int numberOfRow) {
        if (!tableContent.isEmpty())
            return tableContent.get(numberOfRow).findElements(By.xpath(CELL_XPATH));
        return null;
    }

    private List<WebElement> getElementsOfMass(String emailOfRole) {
        for (WebElement webElement : tableContent) {
            if (webElement.findElement(By.xpath(EMAIL_XPATH)).getText().matches(emailOfRole)) {
                return webElement.findElements(By.xpath(CELL_XPATH));
            }
        }
        return null;
    }
}
