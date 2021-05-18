package step.changepassword;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.changepassword.ChangePasswordPage;
import step.BaseStep;
import step.ConfirmActionWindowSteps;
import step.myprofile.MyProfilePageStep;

public class ChangePasswordPageSteps extends BaseStep {

    ChangePasswordPage changePasswordPage;

    public ChangePasswordPageSteps(WebDriver driver) {
        changePasswordPage = new ChangePasswordPage(driver);
    }

    public ChangePasswordPageSteps verifiedElementsInitialStateStep(String email) throws InterruptedException {
        Assert.assertTrue(
                changePasswordPage.emailAddressIsFieldCorrectly(email)
                        && changePasswordPage.newPasswordFieldIsEmpty()
                        && changePasswordPage.currentPasswordFieldIsEmpty()
                        && changePasswordPage.confirmPasswordFieldIsEmpty()
                        && changePasswordPage.confirmSaveButtonIsDisable()
                        && changePasswordPage.emailAddressFieldIsDisabled());
        return this;
    }

    public ChangePasswordPageSteps fillChangePasswordPageStep(String currentPassword, String newPassword, String confirmPassword) {
        changePasswordPage.fillCurrentPasswordField(currentPassword);
        changePasswordPage.fillNewPasswordField(newPassword);
        changePasswordPage.fillConfirmPasswordField(confirmPassword);
        return this;
    }

    public ChangePasswordPageSteps fillCurrentPasswordFieldStep(String currentPassword) {
        changePasswordPage.fillCurrentPasswordField(currentPassword);
        return this;
    }

    public ChangePasswordPageSteps fillNewPasswordFieldStep(String newPassword) {
        changePasswordPage.fillNewPasswordField(newPassword);
        return this;
    }

    public ChangePasswordPageSteps fillConfirmPasswordFieldStep(String confirmPassword) {
        changePasswordPage.fillConfirmPasswordField(confirmPassword);
        return this;
    }

    public ConfirmActionWindowSteps clickSaveButtonStep(WebDriver driver) {
        changePasswordPage.clickSaveButton();
        return new ConfirmActionWindowSteps(driver);
    }

    public ChangePasswordPageSteps clickOnCurrentPasswordField() {
        changePasswordPage.clickOnCurrentPasswordField();
        return this;
    }

    public ChangePasswordPageSteps verifyCurrentPasswordFieldErrorMessage(String errorString, boolean expected) {
        changePasswordPage.clickOnCurrentPasswordField();
        changePasswordPage.clickOnPageLable();
        boolean actual = changePasswordPage.verifyCurrentPasswordErrorField(errorString);
        Assert.assertEquals(actual, expected, "Error message [" + errorString + "] did not found.");
        return this;
    }
    public ChangePasswordPageSteps verifyFollowingAlertMessage(String Alert, boolean expected) {
        boolean actual = changePasswordPage.verifyFollowingAlert(Alert);
        Assert.assertEquals(actual, expected, "Alert message [" + Alert + "] did not contain.");
        return this;
    }

    public MyProfilePageStep clickCancelButtonStep(WebDriver driver) {
        changePasswordPage.clickCancelButton();
        return new MyProfilePageStep(driver);
    }
}
