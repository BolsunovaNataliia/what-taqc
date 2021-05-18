package ui_tests.registration;

import org.testng.annotations.Test;
import ui_tests.BaseTest;
import java.util.Random;

public class RegistrationPageTest extends BaseTest {

    @Test
    public void validRegistrationTest() {

        Random random = new Random();
        int n = random.nextInt(100) + 1;

        String firstName = "Abba";
        String lastName = "Dabba";
        String email = "abbadabba" + n + "@gmail.com";
        String password = "AbbaDabba" + n + "@";
        String confirmPassword = "AbbaDabba" + n + "@";

        signInPageStep
                .clickRegistrationLink(driver)
                .setFirstName(firstName).verifyFirstName(firstName)
                .setLastName(lastName).verifyLastName(lastName)
                .setEmail(email).verifyEmail(email)
                .setPassword(password).verifyPassword(password)
                .setConfirmPassword(confirmPassword).verifyConfirmPassword(confirmPassword)
                .verifySignUpBtnEnable()
                .clickSignUpBtn();
    }
}
