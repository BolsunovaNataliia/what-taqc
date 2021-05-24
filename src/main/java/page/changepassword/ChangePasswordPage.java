package page.changepassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import static constants.XPath.ChangePasswordPage.*;
import static constants.XPath.Common.H3;
import static constants.XPath.Common.SAVE_BUTTON;

public class ChangePasswordPage extends BasePage {

    /**
     * Try to identify page using this text
     */

    @FindBy(xpath = H3)
    private WebElement pagesLabel;
    @FindBy(xpath = EMAIL_FIELD)
    private WebElement emailField;
    @FindBy(xpath = CURRENT_PASSWORD_FIELD)
    private WebElement currentPasswordField;
    @FindBy(xpath = NEW_PASSWORD_FIELD)
    private WebElement newPasswordField;
    @FindBy(xpath = CONFIRM_PASSWORD_FIELD)
    private WebElement confirmPasswordField;
    @FindBy(xpath = SAVE_BUTTON)
    private WebElement saveButton;
    @FindBy(xpath = CANCEL_BUTTON)
    private WebElement cancelButton;
    @FindBy(xpath = CURRENT_PASSWORD_ERROR_FIELD)
    private WebElement currentPasswordErrorField;
    @FindBy(xpath = NEW_PASSWORD_ERROR_FIELD)
    private WebElement newPasswordErrorField;
    @FindBy(xpath = CONFIRM_PASSWORD_ERROR_FIELD)
    private WebElement confirmPasswordErrorField;
    @FindBy(xpath = PASSWORD_SUCCESSFULLY_CHANGED_MESSAGE)
    private WebElement followingAlert;

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void fillCurrentPasswordField(String currentPassword) {
        fillField(currentPasswordField, currentPassword);
    }

    public void fillNewPasswordField(String newPassword) {
        fillField(newPasswordField, newPassword);
    }

    public void fillConfirmPasswordField(String confirmPassword) {
        fillField(confirmPasswordField, confirmPassword);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * we need to return 'User profile' page
     */
    public void clickCancelButton() {
        cancelButton.click();
    }

    public boolean emailAddressIsFieldCorrectly(String email) {
        String currentEmail = emailField.getAttribute("value");
        return currentEmail.equals(email);
    }

    public boolean currentPasswordFieldIsEmpty() {
        return currentPasswordField.getText().equals("");
    }

    public boolean newPasswordFieldIsEmpty() {
        return newPasswordField.getText().equals("");
    }

    public boolean confirmPasswordFieldIsEmpty() {
        return confirmPasswordField.getText().equals("");
    }

    public boolean confirmSaveButtonIsDisable() {
        return saveButton.isDisplayed();
    }

    public boolean verifyCurrentPasswordErrorField(String message) {
        return currentPasswordErrorField.getText().equals(message);
    }
    public boolean verifyFollowingAlert(String message) {
        String alertMessage = followingAlert.getText();
        return alertMessage.contains(message);
    }

    public boolean verifyNewPasswordErrorField(String message) {
        return newPasswordField.getText().equals(message);
    }

    public boolean verifyConfirmPasswordErrorField(String message) {
        return confirmPasswordField.getText().equals(message);
    }

    public String getCurrentPasswordErrorMessage(String message) {
        return currentPasswordField.getText();
    }

    public String getPagesLabel() {
        return pagesLabel.getText();
    }

    public void clickOnPageLable() {
        pagesLabel.click();
    }

    public void clickOnCurrentPasswordField() {
        currentPasswordField.click();
    }

    public boolean confirmSaveButtonIsEnabled() {
        return saveButton.isEnabled();
    }

    public boolean emailAddressFieldIsDisabled() {
        return emailField.isDisplayed();
    }
}
