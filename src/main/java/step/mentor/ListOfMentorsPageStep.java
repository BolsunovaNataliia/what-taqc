package step.mentor;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.mentor.ListOfMentorsPage;
import step.BaseStep;

public class ListOfMentorsPageStep extends BaseStep {

    private final ListOfMentorsPage listOfMentorsPage;

    public ListOfMentorsPageStep(WebDriver driver) {
         listOfMentorsPage = new ListOfMentorsPage(driver);
         listOfMentorsPage.clickSidebarItem("Secretaries");
    }
    public ListOfMentorsPageStep verifyMentorsID(String email, String expected) {

        Assert.assertEquals(listOfMentorsPage.getMentorsID(email), expected, "The expected results 'ID' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfMentorsPageStep verifyMentorsName(int number, String expected) {

        Assert.assertEquals(listOfMentorsPage.getMentorsName(number), expected, "The expected results 'Name' do not correspond to the real ones By 'number'.");
        return this;
    }

    public ListOfMentorsPageStep verifyMentorsName(String email, String expected) {

        Assert.assertEquals(listOfMentorsPage.getMentorsName(email), expected, "The expected results 'Name' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfMentorsPageStep verifyMentorsSurname(int number, String expected) {

        Assert.assertEquals(listOfMentorsPage.getMentorsSurname(number), expected, "The expected results 'Surname' do not correspond to the real ones By 'number'.");
        return this;
    }

    public ListOfMentorsPageStep verifyMentorsSurname(String email, String expected) {

        Assert.assertEquals(listOfMentorsPage.getMentorsSurname(email), expected, "The expected results 'Surname' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfMentorsPageStep verifyMentorsEmail(int number, String expected) {

        Assert.assertEquals(listOfMentorsPage.getMentorsEmail(number), expected, "The expected results 'Email' do not correspond to the real ones By 'number'.");
        return this;
    }




    public ListOfMentorsPageStep verifyChoseSortEnabled(String mentor, boolean expected) {

        Assert.assertEquals(listOfMentorsPage.choseSortTypeEnabled(mentor),expected, "The expected results 'SortType' do not correspond to the real ones By 'mentor'.");
        return this;
    }

    public void choseSortType(String mentor) {

        listOfMentorsPage.choseSortType(mentor);
    }
}