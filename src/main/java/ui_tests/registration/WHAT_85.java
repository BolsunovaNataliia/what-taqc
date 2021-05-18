package ui_tests.registration;

import org.testng.annotations.Test;
import page.signin.SignInPage;
import step.registration.RegistrationPageStep;
import constants.Messages.Errors;
import ui_tests.BaseTest;

/**
 * This test case verifies that any @User can't register in the system with invalid values
 * in the First name, Last name, Email address, Password, Confirm Password, after clicking the 'Sign up' button
 */

public class WHAT_85 extends BaseTest {

    @Test
    public void atc_WHAT_85() {
        String firstName = "11111";
        String lastName = "22222";
        String email = "abbadabba";
        String password = "Abba";
        String confirmPassword = "Dabba";

        // steps
        signInPageStep
                .clickRegistrationLink(driver)
                .setFirstName(firstName)                            // step('1')
                .setLastName(lastName)                              // step('2')
                .setEmail(email)                                    // step('3')
                .setPassword(password)                              // step('4')
                .setConfirmPassword(confirmPassword)                // step('5')
                .setConfirmPassword(confirmPassword)
                .verifyErrorFirstName(Errors.INVALID_FIRST_NAME)
                .verifyErrorLastName(Errors.INVALID_LAST_NAME)
                .verifyErrorEmail(Errors.INVALID_EMAIL_ADDRESS)
                .verifyErrorPassword(Errors.PASSWORD_MUST_CONTAIN_AT_LEAST_8_CHARACTERS)
                .verifyErrorConfirmPassword(Errors.YOU_SHOULD_CONFIRM_YOUR_PASSWORD)
                .verifySignUpBtnEnable()
                .clickSignUpBtn();                                  // step('6')
    }
}
