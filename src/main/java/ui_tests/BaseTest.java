package ui_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import service.DBWorker;
import service.DriverOption;
import step.signin.SignInPageStep;

public abstract class BaseTest {

    protected WebDriver driver;
    protected SignInPageStep signInPageStep;

    @BeforeSuite
    public void setUpDB() {
        DBWorker.startFilling();
    }

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
