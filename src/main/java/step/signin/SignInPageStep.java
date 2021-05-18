package step.signin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.signin.SignInPage;
import step.BaseStep;
import step.Step;
import step.registration.RegistrationPageStep;

import java.lang.reflect.InvocationTargetException;

import static constants.Classes.Steps.LIST_OF_STUDENTS_PAGE_STEP;
import static constants.Classes.Steps.SUPPORT_PAGE_STEP;

public class SignInPageStep extends Step {

    SignInPage signInPage;

    public SignInPageStep(WebDriver driver) {
        signInPage = new SignInPage(driver);
    }

    public SignInPageStep setEmail(String email) {
        signInPage.fillEmail(email);
        return this;
    }

    public SignInPageStep setPassword(String password) {
        signInPage.fillPassword(password);
        return this;
    }

    public RegistrationPageStep clickRegistrationLink(WebDriver driver) {
        signInPage.clickRegistrationLink();
        return new RegistrationPageStep(driver);
    }

    public SignInPageStep verifyEmail(String expected) {
        Assert.assertEquals(signInPage.getEmail(), expected);
        return this;
    }

    public SignInPageStep verifyPassword(String expected) {
        Assert.assertEquals(signInPage.getPassword(), expected);
        return this;
    }

    public <T extends BaseStep> T clickSignInBtn(Class<T> context, WebDriver driver) {
        if(context.getName().matches(LIST_OF_STUDENTS_PAGE_STEP+"|"+ SUPPORT_PAGE_STEP)) {
            signInPage.clickSignInButton();
            try {
                Thread.sleep(1000);
                return context.getConstructor(WebDriver.class).newInstance(driver);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                throw new RuntimeException("No such page");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Sign in page is not redirecting to such page");
    }

    public SignInPageStep clickSignInBtnNotSuccessful() {
        signInPage.clickSignInButton();
        return this;
    }

}
