package ui_tests.registration;

import java.util.Random;

import constants.Messages.Alerts;
import org.testng.annotations.Test;
import ui_tests.BaseTest;

/**
 * This test case verifies that any @User can register in the system by entering the valid data:
 * First name, Last name, Email address, Password, Confirm Password, and by clicking the 'Sign up' button
 */

public class WHAT_73 extends BaseTest {

    @Test
    public void atc_WHAT_73() {
        Random random = new Random();
        int n = random.nextInt(100) + 1;

        String firstName = "Abba";
        String lastName = "Dabba";
        String email = "abbadabba" + n + "@gmail.com";
        String password = "AbbaDabba" + n + "@";
        String confirmPassword = "AbbaDabba" + n + "@";

        // steps
        signInPageStep
                .clickRegistrationLink(driver)
                .setFirstName(firstName).verifyFirstName(firstName)     // step('1')
                .setLastName(lastName).verifyLastName(lastName)         // step('2')
                .setEmail(email).verifyEmail(email)                     // step('3')
                .setPassword(password).verifyPassword(password)         // step('4')
                .setConfirmPassword(confirmPassword)                    // step('5')
                .verifyConfirmPassword(confirmPassword)
                .verifySignUpBtnEnable()
                .clickSignUpBtn()                                       // step('6')
                .verifySuccessAlert(Alerts.SUCCESS_MESSAGE_REGISTRATION)// step('7')
                .verifySuccessRegistrationBtnEnable()
                .clickSuccessRegistrationBtn();
    }
}
