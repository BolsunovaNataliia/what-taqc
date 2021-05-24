package step.unassigned;

import constants.Messages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.unassigned.ListOfUnassignedUsersPage;
import step.BaseStep;

public class ListOfUnassignedUsersPageStep extends BaseStep {

    private final ListOfUnassignedUsersPage listOfUnassignedUsersPageStep;

    public ListOfUnassignedUsersPageStep(WebDriver driver) {
        listOfUnassignedUsersPageStep = new ListOfUnassignedUsersPage(driver);
    }


    public ListOfUnassignedUsersPageStep verifyUnassignedUserID(String email, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserID(email), expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"ID","email"));
        return this;
    }


    public ListOfUnassignedUsersPageStep verifyUnassignedUserName(int number, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserName(number), expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"Name","number"));
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyUnassignedUserName(String email, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserName(email), expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"Name","email"));
        return this;
    }


    public ListOfUnassignedUsersPageStep verifyUnassignedUserSurname(int number, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserSurname(number), expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"Surname","number"));
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyUnassignedUserSurname(String email, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserSurname(email), expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"Surname","email"));
        return this;
    }


    public ListOfUnassignedUsersPageStep verifyUnassignedUserEmail(int number, String expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.getUnassignedUserEmail(number), expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"Email","number"));
        return this;
    }


    public ListOfUnassignedUsersPageStep verifyAddRoleButtonEnabled(int number, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.addRoleButtonEnabled(number), expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"AddRole","number"));
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyAddRoleButtonEnabled(String email, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.addRoleButtonEnabled(email), expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"AddRole","email"));
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyChoseSortEnabled(String unassignedUsers, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.choseSortTypeEnabled(unassignedUsers),expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"SortType","unassignedUsers"));
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyChoseUserRole(String email, String unassignedUsers, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.choseUserRoleEnabled( email, unassignedUsers),expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"UserRole","email"));
        return this;
    }

    public ListOfUnassignedUsersPageStep verifyChoseUserRole(int number, String unassignedUsers, boolean expected) {

        Assert.assertEquals(listOfUnassignedUsersPageStep.choseUserRoleEnabled( number, unassignedUsers),expected, String.format(Messages.Asserts.DO_NOT_CORRESPOND_TO_THE_REAL_ONES_BY,"UserRole","number"));
        return this;
    }

    public ListOfUnassignedUsersPageStep addRoleButtonClick(String email) {
        listOfUnassignedUsersPageStep.addRoleButtonClick(email);
        return this;
    }

    public ListOfUnassignedUsersPageStep addRoleButtonClick(int number) {
        listOfUnassignedUsersPageStep.addRoleButtonClick(number);
        return this;
    }

    public ListOfUnassignedUsersPageStep choseSortType(String unassignedUsers) {
        listOfUnassignedUsersPageStep.choseSortType(unassignedUsers);
        return this;
    }

    public ListOfUnassignedUsersPageStep choseUserRole(String email, String unassignedUsers) {
        listOfUnassignedUsersPageStep.choseUserRole(email, unassignedUsers);
        return this;
    }

    public ListOfUnassignedUsersPageStep choseUserRole(int number, String unassignedUsers) {
        listOfUnassignedUsersPageStep.choseUserRole(number, unassignedUsers);
        return this;
    }
}