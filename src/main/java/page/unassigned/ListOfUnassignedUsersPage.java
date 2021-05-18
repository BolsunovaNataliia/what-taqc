package page.unassigned;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import constants.Constants.UsersSort;
import constants.Constants;
import page.BasePage;
import static constants.Constants.UnassignedUsersSelectRole.*;
import java.util.List;


public class ListOfUnassignedUsersPage extends BasePage {


    private static final String EMAIL_XPATH = "//tr/td[4]";
    private static final String ADD_ROLE_XPATH = "//button[text()='Add role']";
    private static final String CELL_XPATH = "//td";


    @FindBy(xpath = "//input[contains(@class,'searchInput')]")
    private WebElement inputPerson;
    @FindBy(xpath = "//tr/th/span")
    private List<WebElement> sortUnassignedUsers;


    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> tableContent;

    WebDriver driver;

    public ListOfUnassignedUsersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }



    public String getUnassignedUserID(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(0).getText();

        return null;
    }
    public String getUnassignedUserName(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(1).getText();

        return null;
    }

    public String getUnassignedUserName(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(1).getText();

        return null;
    }

    public String getUnassignedUserSurname(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(2).getText();

        return null;
    }

    public String getUnassignedUserSurname(int number) {


        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(2).getText();

        return null;
    }

    public String getUnassignedUserEmail(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(3).getText();

        return null;
    }


    public boolean addRoleButtonEnabled(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            return row.get(4).findElement(By.xpath(ADD_ROLE_XPATH)).isEnabled();
        return false;
    }

    public boolean addRoleButtonEnabled(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            return row.get(4).findElement(By.xpath(ADD_ROLE_XPATH)).isEnabled();
        return false;
    }

    public boolean choseSortTypeEnabled(String unassignedUsers) {

        switch (unassignedUsers) {
            case UsersSort.SYMBOL:
                return sortUnassignedUsers.get(Integer.parseInt(UsersSort.SYMBOL)).isEnabled();
            case UsersSort.NAME:
                return sortUnassignedUsers.get(Integer.parseInt(UsersSort.NAME)).isEnabled();
            case UsersSort.SURNAME:
                return sortUnassignedUsers.get(Integer.parseInt(UsersSort.SURNAME)).isEnabled();
            case UsersSort.EMAIL:
                return sortUnassignedUsers.get(Integer.parseInt(UsersSort.EMAIL)).isEnabled();
        }
        return false;
    }

    public boolean choseUserRoleEnabled(String email, String unassignedUsers) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            row.get(4).findElement(By.xpath("//select")).click();
        switch (unassignedUsers) {
            case CHOOSE:
                return row.get(4).findElement(By.xpath("//select//option[@value='0']")).isEnabled();
            case STUDENT:
                return row.get(4).findElement(By.xpath("//select//option[@value='1']")).isEnabled();
            case MENTOR:
                return row.get(4).findElement(By.xpath("//select//option[@value='2']")).isEnabled();
            case SECRETARY:
                return row.get(4).findElement(By.xpath("//select//option[@value='3']")).isEnabled();
        }
        return false;
    }

    public boolean choseUserRoleEnabled(int number, String unassignedUsers) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            row.get(4).findElement(By.xpath("//select")).click();
        switch (unassignedUsers) {
            case CHOOSE:
                return row.get(4).findElement(By.xpath("//select//option[@value='0']")).isEnabled();
            case STUDENT:
                return row.get(4).findElement(By.xpath("//select//option[@value='1']")).isEnabled();
            case MENTOR:
                return row.get(4).findElement(By.xpath("//select//option[@value='2']")).isEnabled();
            case SECRETARY:
                return row.get(4).findElement(By.xpath("//select//option[@value='3']")).isEnabled();
        }
        return false;
    }
    public void addRoleButtonClick(String email) {
        List<WebElement> row = getElementsOfMass(email);
        if (!row.isEmpty())
            row.get(4).findElement(By.xpath(ADD_ROLE_XPATH)).click();

    }

    public void addRoleButtonClick(int number) {
        List<WebElement> row = getElementsOfMass(number);
        if (!row.isEmpty())
            row.get(4).findElement(By.xpath(ADD_ROLE_XPATH)).click();

    }

    public void choseSortType(String unassignedUsers) {

        switch (unassignedUsers) {
            case UsersSort.SYMBOL:
                sortUnassignedUsers.get(Integer.parseInt(UsersSort.SYMBOL)).click();
                break;
            case UsersSort.NAME:
                sortUnassignedUsers.get(Integer.parseInt(UsersSort.NAME)).click();
                break;
            case UsersSort.SURNAME:
                sortUnassignedUsers.get(Integer.parseInt(UsersSort.SURNAME)).click();
                break;
            case UsersSort.EMAIL:
                sortUnassignedUsers.get(Integer.parseInt(UsersSort.EMAIL)).click();
                break;
        }
    }
    public void choseUserRole(String email, String unassignedUsers) {
        List<WebElement> row = getElementsOfMass(email);
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

    private List<WebElement> getElementsOfMass(String emailOfRole) {
        for (WebElement webElement : tableContent) {
            if (webElement.findElement(By.xpath(EMAIL_XPATH)).getText().matches(emailOfRole)) {
                return webElement.findElements(By.xpath(CELL_XPATH));
            }
        }

        return null;
    }

    private List<WebElement> getElementsOfMass(int numberOfRow) {
        if (!tableContent.isEmpty())
            return tableContent.get(numberOfRow).findElements(By.xpath(CELL_XPATH));
        return null;
    }
}
