package ui_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import service.DriverOption;
import step.signin.SignInPageStep;

public abstract class BaseTest {

    protected WebDriver driver;
    protected SignInPageStep signInPageStep;

    @BeforeClass
    public void setUp() {
        driver = DriverOption.manage();
        signInPageStep = new SignInPageStep(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
