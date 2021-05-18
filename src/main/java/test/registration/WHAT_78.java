package test.registration;

import constants.Messages.Errors;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * This test case verifies that users can't register into the system with empty 'First Name', 'Last Name',
 * 'Email address', 'Password', 'Confirm password' fields after clicking the 'Sign up' button.
 */

public class WHAT_78 extends BaseTest {

    @Test
    public void atc_WHAT_78() {

        // steps
        signInPageStep
                .clickRegistrationLink(driver)
                .clickSignUpBtn()
                .verifyErrorFirstName(Errors.FIELD_IS_REQUIRED)
                .verifyErrorLastName(Errors.FIELD_IS_REQUIRED)
                .verifyErrorEmail(Errors.FIELD_IS_REQUIRED)
                .verifyErrorPassword(Errors.FIELD_IS_REQUIRED)
                .verifyErrorConfirmPassword(Errors.FIELD_IS_REQUIRED)
                .verifySignUpBtnEnable();
    }
}
