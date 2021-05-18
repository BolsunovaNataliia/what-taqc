package ui_tests.group;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.signin.SignInPage;

import step.group.ListOfGroupsPageStep;
import ui_tests.BaseTest;

public class ListOfGroupsPageTest extends BaseTest {
    ListOfGroupsPageStep listOfGroupsPageStep;

    @BeforeMethod
    public void prepare() {
        SignInPage signInPage = new SignInPage(driver);
        String email = "admin.@gmail.com";
        String password = "admiN_12";

        signInPage.fillEmail(email);
        signInPage.fillPassword(password);
        signInPage.clickSignInButton();
        driver.findElement(By.xpath("//a[@data-id='4']")).click();

        listOfGroupsPageStep = new ListOfGroupsPageStep(driver);
    }

    @Test
    public void searchByGroupName()  throws InterruptedException{
        listOfGroupsPageStep
                .searchByGroupName("Slytherin")
                .verifySearchByGroupHasText("Slytherin")
                .verifyGroupExists("Slytherin");
    }

    @Test
    public void searchByInvalidGroupName() throws InterruptedException {
        listOfGroupsPageStep
                .searchByGroupName("AAA")
                .verifySearchByGroupHasText("AAA")
                .verifyGroupNotExists();
    }
}
