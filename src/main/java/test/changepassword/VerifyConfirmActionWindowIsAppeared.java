package test.changepassword;

import constants.Messages.Alerts;
import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class VerifyConfirmActionWindowIsAppeared extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void changePasswordVerifyFields(String path) throws InterruptedException {
        User user = ReaderFileJson.readFileJsonUser(path);

        String newPassword = "123456789qQ";

        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickChangePassword(ListOfStudentPage.class,driver)
                .verifiedElementsInitialStateStep(user.getEmail())
                .fillCurrentPasswordFieldStep(user.getPassword())
                .fillNewPasswordFieldStep(newPassword)
                .fillConfirmPasswordFieldStep(newPassword)
                .clickSaveButtonStep(driver)
                .verifyConfirmActionWindow(true)
                .clickConfirmButton(driver)
                .verifyFollowingAlertMessage(Alerts.SUCCESSFULLY_CHANGED_PASSWORD, true);
    }
}