package service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.concurrent.TimeUnit;

/**
 *
 * In package resources you can change default options
 * Just de-comment property in driverConfig.properties and set your own value
 *
 * */

public class DriverOption {

    private static final EnvironmentService environment = new EnvironmentService();

    private DriverOption(){
    }

    public static WebDriver manage(){
        WebDriver driver = setBrowserType();
        setImplicitWait(driver);
        setFullScreen(driver);
        getToUrl(driver);
        return driver;
    }

    private static WebDriver setBrowserType(){
        switch (environment.getBrowserType()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (environment.isIncognitoModeOn()) chromeOptions.addArguments("--incognito");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (environment.isIncognitoModeOn()) firefoxOptions.addArguments("-private");
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            case "opera":
                OperaOptions operaOptions = new OperaOptions();
                if (environment.isIncognitoModeOn()) operaOptions.addArguments("-private");
                WebDriverManager.operadriver().setup();
                return new OperaDriver(operaOptions);
            case "explorer":
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                //https://docs.microsoft.com/en-US/troubleshoot/browsers/32-bit-browser-applications-not-working-as-expected
                ieOptions.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                if (environment.isIncognitoModeOn()) ieOptions.addCommandSwitches("-private");
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver(ieOptions);
            default:
                throw new RuntimeException();
        }
    }
    private static void setFullScreen(WebDriver driver){
        if(environment.isFullScreenMode()) driver.manage().window().maximize();
    }
    private static void setImplicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(environment.getImplicitWait(),TimeUnit.SECONDS);
    }
    private static void getToUrl(WebDriver driver){
        driver.get(environment.getAppUrl());
    }

}
