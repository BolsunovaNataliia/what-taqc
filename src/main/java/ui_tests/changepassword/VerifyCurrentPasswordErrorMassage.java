package ui_tests.changepassword;

import constants.Messages.Errors;
import service.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class VerifyCurrentPasswordErrorMassage extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void verifyCurrentPasswordFieldError(String path) {
        User user = ReaderFileJson.readFileJsonUser(path);

        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickChangePassword(ListOfStudentPage.class,driver)
                .verifyCurrentPasswordFieldErrorMessage(Errors.FIELD_IS_REQUIRED, true);
    }
}
