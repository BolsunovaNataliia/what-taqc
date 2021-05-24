package step.myprofile;

import constants.Messages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.myprofile.MyProfilePage;
import step.BaseStep;
import step.changepassword.ChangePasswordPageSteps;

public class MyProfilePageStep extends BaseStep {

    private MyProfilePage myProfilePage;

    public MyProfilePageStep(WebDriver driver){
        myProfilePage = new MyProfilePage(driver);
    }

    public MyProfilePageStep verifyPageName(String expected){
        Assert.assertEquals(myProfilePage.getNameOfPage(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "PageName"));
        return this;
    }

    public MyProfilePageStep verifyFirstName(String expected){
        Assert.assertEquals(myProfilePage.getFirstName(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "FirstName"));
        return this;
    }

    public MyProfilePageStep verifyLastName(String expected){
        Assert.assertEquals(myProfilePage.getLastName(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "LastName"));
        return this;
    }

    public MyProfilePageStep verifyEmailAddress(String expected){
        Assert.assertEquals(myProfilePage.getEmailAddress(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "EmailAddress"));
        return this;
    }

    public MyProfilePageStep verifyChangePasswordBtnEnabled(boolean expected){
        Assert.assertEquals(myProfilePage.isChangePasswordEnable(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "ChangePasswordBtn enabled"));
        return this;
    }

    public ChangePasswordPageSteps clickChangePasswordBtn(WebDriver driver){
        myProfilePage.clickChangePasswordBtn();
        return new ChangePasswordPageSteps(driver);
    }

}
