package test.group;

import entity.ReaderFileJson;
import entity.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.student.ListOfStudentPage;
import step.group.ListOfGroupsPageStep;
import step.student.ListOfStudentsPageStep;
import test.BaseTest;

public class ListOfGroupsPageTest extends BaseTest {
    ListOfGroupsPageStep listOfGroupsPageStep;

    @BeforeMethod(groups = "admin")
    public void prepare() {

        listOfGroupsPageStep = signInPageStep
                .clickSignInBtn(ListOfStudentsPageStep.class, driver)
                .clickGroupsSidebar(ListOfStudentPage.class,driver);
    }

    @Test
    public void searchByGroupName()  throws InterruptedException{
        listOfGroupsPageStep
                .searchByGroupName("Slytherin")
                .verifySearchByGroupHasText("Slytherin")
                .verifyGroupExists("Slytherin");
    }

    @Test
    public void searchByInvalidGroupName() throws InterruptedException {
        listOfGroupsPageStep
                .searchByGroupName("AAA")
                .verifySearchByGroupHasText("AAA")
                .verifyGroupNotExists();
    }
}
