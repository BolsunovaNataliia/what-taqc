package step.secretary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.secretary.ListOfSecretaryPage;
import step.BaseStep;

public class ListOfSecretaryPageStep extends BaseStep {

    private final ListOfSecretaryPage listOfSecretaryPage;

    public ListOfSecretaryPageStep(WebDriver driver) {
        listOfSecretaryPage = new ListOfSecretaryPage(driver);
        listOfSecretaryPage.clickSidebarItem("Mentors");
    }
    public ListOfSecretaryPageStep verifySecretaryID(String email, String expected) {

        Assert.assertEquals(listOfSecretaryPage.getSecretaryID(email), expected, "The expected results 'ID' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfSecretaryPageStep verifySecretaryName(int number, String expected) {

        Assert.assertEquals(listOfSecretaryPage.getSecretaryName(number), expected, "The expected results 'Name' do not correspond to the real ones By 'number'.");
        return this;
    }

    public ListOfSecretaryPageStep verifySecretaryName(String email, String expected) {

        Assert.assertEquals(listOfSecretaryPage.getSecretaryName(email), expected, "The expected results 'Name' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfSecretaryPageStep verifySecretarySurname(int number, String expected) {

        Assert.assertEquals(listOfSecretaryPage.getSecretarySurname(number), expected, "The expected results 'Surname' do not correspond to the real ones By 'number'.");
        return this;
    }

    public ListOfSecretaryPageStep verifySecretarySurname(String email, String expected) {

        Assert.assertEquals(listOfSecretaryPage.getSecretarySurname(email), expected, "The expected results 'Surname' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfSecretaryPageStep verifySecretaryEmail(int number, String expected) {

        Assert.assertEquals(listOfSecretaryPage.getSecretaryEmail(number), expected, "The expected results 'Email' do not correspond to the real ones By 'number'.");
        return this;
    }




    public ListOfSecretaryPageStep verifyChoseSortEnabled(String secretary, boolean expected) {

        Assert.assertEquals(listOfSecretaryPage.choseSortTypeEnabled(secretary),expected, "The expected results 'SortType' do not correspond to the real ones By 'secretary'.");
        return this;
    }

    public void choseSortType(String secretary) {

        listOfSecretaryPage.choseSortType(secretary);
    }
}

