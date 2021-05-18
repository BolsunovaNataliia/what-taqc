package step.unassigned;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.unassigned.ListOfUnassignedUsersPage;
import step.BaseStep;

public class ListOfUnassignedUsersPageStep extends BaseStep {

    private final ListOfUnassignedUsersPage listOfUnassignedUsersPageStep;

    public ListOfUnassignedUsersPageStep(WebDriver driver) {

        listOfUnassignedUsersPageStep = new ListOfUnassignedUsersPage(driver);
        listOfUnassignedUsersPageStep.clickSidebarItem("Assigment");

    }


    public ListOfUnassignedUsersPageStep verifyUnassignedUserID(String email, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserID(email), expected, "The expected results 'ID' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfUnassignedUsersPageStep verifyUnassignedUserName(int number, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserName(number), expected, "The expected results 'Name' do not correspond to the real ones By 'number'.");
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyUnassignedUserName(String email, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserName(email), expected, "The expected results 'Name' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfUnassignedUsersPageStep verifyUnassignedUserSurname(int number, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserSurname(number), expected, "The expected results 'Surname' do not correspond to the real ones By 'number'.");
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyUnassignedUserSurname(String email, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserSurname(email), expected, "The expected results 'Surname' do not correspond to the real ones By 'email'.");
        return this;
    }


    public ListOfUnassignedUsersPageStep verifyUnassignedUserEmail(int number, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserEmail(number), expected, "The expected results 'Email' do not correspond to the real ones By 'number'.");
        return this;
    }


    public ListOfUnassignedUsersPageStep verifyAddRoleButtonEnabled(int number, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.addRoleButtonEnabled(number), expected, "The expected results 'AddRole' do not correspond to the real ones By 'number'.");
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyAddRoleButtonEnabled(String email, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.addRoleButtonEnabled(email), expected, "The expected results 'AddRole' do not correspond to the real ones By 'email'.");
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyChoseSortEnabled(String unassignedUsers, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.choseSortTypeEnabled(unassignedUsers),expected, "The expected results 'SortType' do not correspond to the real ones By 'unassignedUsers'.");
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyChoseUserRole(String email, String unassignedUsers, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.choseUserRoleEnabled( email, unassignedUsers),expected, "The expected results 'UserRole' do not correspond to the real ones By 'email'.");
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyChoseUserRole(int number, String unassignedUsers, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.choseUserRoleEnabled( number, unassignedUsers),expected, "The expected results 'UserRole' do not correspond to the real ones By 'number'.");
        return this;
    }

    public void addRoleButtonClick(String email) {

        listOfUnassignedUsersPageStep.addRoleButtonClick(email);
    }

    public void addRoleButtonClick(int number) {

        listOfUnassignedUsersPageStep.addRoleButtonClick(number);
    }

    public void choseSortType(String unassignedUsers) {

        listOfUnassignedUsersPageStep.choseSortType(unassignedUsers);
    }

    public void choseUserRole(String email, String unassignedUsers) {
        listOfUnassignedUsersPageStep.choseUserRole(email, unassignedUsers);
    }

    public void choseUserRole(int number, String unassignedUsers) {
        listOfUnassignedUsersPageStep.choseUserRole(number, unassignedUsers);
    }
}