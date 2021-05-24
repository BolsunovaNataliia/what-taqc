package ui_tests.signin;

import service.ReaderFileJson;
import entity.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import step.student.ListOfStudentsPageStep;
import ui_tests.BaseTest;

public class SignInPageTest extends BaseTest {

    @Test
    @Parameters({"admin"})
    public void authorizationValidTest(String path) {
        User user = ReaderFileJson.readFileJsonUser(path);

        signInPageStep
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInBtn(ListOfStudentsPageStep.class, driver);
    }
}
