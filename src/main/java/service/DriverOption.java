package service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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
            case "remoteChrome":
                try {
                    ChromeOptions chromeOptions1 = new ChromeOptions();
                    chromeOptions1.setCapability("browserName", "chrome");
                    if (environment.isIncognitoModeOn()) chromeOptions1.addArguments("--incognito");
                    return new RemoteWebDriver(new URL(System.getenv("STANDALONE")), chromeOptions1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            case "remoteFirefox":
                try {
                    FirefoxOptions firefoxOptions1 = new FirefoxOptions();
                    firefoxOptions1.setCapability("browserName", "firefox");
                    if (environment.isIncognitoModeOn()) firefoxOptions1.addArguments("-private");
                    return new RemoteWebDriver(new URL(System.getenv("STANDALONE")), firefoxOptions1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            case "remoteOpera":
                try {
                    OperaOptions operaOptions1 = new OperaOptions();
                    operaOptions1.setCapability("browserName", "opera");
                    if (environment.isIncognitoModeOn()) operaOptions1.addArguments("-private");
                    return new RemoteWebDriver(new URL(System.getenv("STANDALONE")), operaOptions1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
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
