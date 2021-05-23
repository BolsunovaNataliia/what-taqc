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

    public ChangePasswordPageSteps verifiedEmailAddressIsFieldCorrectlyStep(String email) {
        Assert.assertTrue(changePasswordPage.emailAddressIsFieldCorrectly(email));
        return this;
    }

    public ChangePasswordPageSteps verifyNewPasswordFieldInitialStateStep() {
        Assert.assertTrue(changePasswordPage.newPasswordFieldIsEmpty());
        return this;
    }

    public ChangePasswordPageSteps verifyCurrentPasswordFieldInitialStateStep() {
        Assert.assertTrue(changePasswordPage.currentPasswordFieldIsEmpty());
        return this;
    }

    public ChangePasswordPageSteps verifyConfirmPasswordFieldInitialStateStep() {
        Assert.assertTrue(changePasswordPage.confirmPasswordFieldIsEmpty());
        return this;
    }

    public ChangePasswordPageSteps verifyConfirmSaveButtonIsDisableStep() {
        Assert.assertTrue(changePasswordPage.confirmSaveButtonIsDisable());
        return this;
    }

    public ChangePasswordPageSteps verifyEmailAddressFieldIsDisabledStep() {
        Assert.assertTrue(changePasswordPage.emailAddressFieldIsDisabled());
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
