package step;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.BasePage;
import step.changepassword.ChangePasswordPageSteps;
import step.courses.CoursesStep;
import step.group.ListOfGroupsPageStep;
import step.lesson.ListOfLessonPageStep;
import step.mentor.ListOfMentorsPageStep;
import step.myprofile.MyProfilePageStep;
import step.secretary.ListOfSecretaryPageStep;
import step.signin.SignInPageStep;
import step.student.ListOfStudentsPageStep;
import step.support.SupportPageStep;
import step.unassigned.UnassignedUsersStep;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseStep extends Step {

    public ListOfStudentsPageStep clickStudentsSidebar(Class<? extends BasePage> context, WebDriver driver) {
        clickSidebarItem(context, Constants.PageName.STUDENT_LIST, driver);
        return new ListOfStudentsPageStep(driver);
    }

    public ListOfLessonPageStep clickLessonSidebar(Class<? extends BasePage> context, WebDriver driver) {
        clickSidebarItem(context, Constants.PageName.LESSON_LIST, driver);
        return new ListOfLessonPageStep(driver);
    }

    public CoursesStep clickCoursesSidebar(Class<? extends BasePage> context, WebDriver driver) {
        clickSidebarItem(context, Constants.PageName.COURSE_LIST, driver);
        return new CoursesStep(driver);
    }

    public ListOfSecretaryPageStep clickSecretariesSidebar(Class<? extends BasePage> context, WebDriver driver) {
        clickSidebarItem(context, Constants.PageName.SECRETARY_LIST, driver);
        return new ListOfSecretaryPageStep(driver);
    }

    public UnassignedUsersStep clickUnassignedSidebar(Class<? extends BasePage> context, WebDriver driver) {
        clickSidebarItem(context, Constants.PageName.UNASSIGNED, driver);
        return new UnassignedUsersStep(driver);
    }

    public SupportPageStep clickSupportSidebar(Class<? extends BasePage> context, WebDriver driver) {
        clickSidebarItem(context, Constants.PageName.SUPPORT, driver);
        return new SupportPageStep(driver);
    }

    public ListOfMentorsPageStep clickMentorsSidebar(Class<? extends BasePage> context, WebDriver driver) {
        clickSidebarItem(context, Constants.PageName.MENTOR_LIST, driver);
        return new ListOfMentorsPageStep(driver);
    }

    public ListOfGroupsPageStep clickGroupsSidebar(Class<? extends BasePage> context, WebDriver driver) {
        clickSidebarItem(context, Constants.PageName.GROUP_LIST, driver);
        return new ListOfGroupsPageStep(driver);
    }


    public MyProfilePageStep clickMyProfile(Class<? extends BasePage> context, WebDriver driver) {
        clickDropdownItem(context, Constants.PageName.MY_PROFILE, driver);
        return new MyProfilePageStep(driver);
    }

    public ChangePasswordPageSteps clickChangePassword(Class<? extends BasePage> context, WebDriver driver) {
        clickDropdownItem(context, Constants.PageName.CHANGE_PASSWORD, driver);
        return new ChangePasswordPageSteps(driver);
    }

    public SignInPageStep clickLogOut(Class<? extends BasePage> context, WebDriver driver) {
        clickDropdownItem(context, Constants.PageName.LOD_OUT, driver);
        return new SignInPageStep(driver);
    }


    public <T extends BaseStep> T verifySidebarItemStudents(Class<T> stepContext,
                                                            Class<? extends BasePage> pageContext,
                                                            boolean expected, WebDriver driver) {
        return verifySidebarItem(stepContext, pageContext, expected, Constants.PageName.STUDENT_LIST, driver);
    }

    public <T extends BaseStep> T verifySidebarItemLessons(Class<T> stepContext,
                                                           Class<? extends BasePage> pageContext,
                                                           boolean expected, WebDriver driver) {
        return verifySidebarItem(stepContext, pageContext, expected, Constants.PageName.LESSON_LIST, driver);
    }

    public <T extends BaseStep> T verifySidebarItemCourses(Class<T> stepContext,
                                                            Class<? extends BasePage> pageContext,
                                                            boolean expected, WebDriver driver) {
        return verifySidebarItem(stepContext, pageContext, expected, Constants.PageName.COURSE_LIST, driver);
    }

    public <T extends BaseStep> T verifySidebarItemSecretaries(Class<T> stepContext,
                                                            Class<? extends BasePage> pageContext,
                                                            boolean expected, WebDriver driver) {
        return verifySidebarItem(stepContext, pageContext, expected, Constants.PageName.SECRETARY_LIST, driver);
    }

    public <T extends BaseStep> T verifySidebarItemUnassigned(Class<T> stepContext,
                                                           Class<? extends BasePage> pageContext,
                                                           boolean expected, WebDriver driver) {
        return verifySidebarItem(stepContext, pageContext, expected, Constants.PageName.UNASSIGNED, driver);
    }

    public <T extends BaseStep> T verifySidebarItemSupport(Class<T> stepContext,
                                                            Class<? extends BasePage> pageContext,
                                                            boolean expected, WebDriver driver) {
        return verifySidebarItem(stepContext, pageContext, expected, Constants.PageName.SUPPORT, driver);
    }

    public <T extends BaseStep> T verifySidebarItemMentors(Class<T> stepContext,
                                                            Class<? extends BasePage> pageContext,
                                                            boolean expected, WebDriver driver) {
        return verifySidebarItem(stepContext, pageContext, expected, Constants.PageName.MENTOR_LIST, driver);
    }

    public <T extends BaseStep> T verifySidebarItemGroups(Class<T> stepContext,
                                                            Class<? extends BasePage> pageContext,
                                                            boolean expected, WebDriver driver) {
        return verifySidebarItem(stepContext, pageContext, expected, Constants.PageName.GROUP_LIST, driver);
    }


    private void clickSidebarItem(Class<? extends BasePage> context,
                                  String item, WebDriver driver) {
        try {
            Thread.sleep(5000); //due to load list
            BasePage basePage = context.getConstructor(WebDriver.class).newInstance(driver);
            basePage.clickSidebarItem(item);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("No such page");
        } catch (InterruptedException e) {
            throw new RuntimeException("Element is not found for 5 sec");
        }
    }

    private void clickDropdownItem(Class<? extends BasePage> context,
                                   String item, WebDriver driver) {
        try {
            BasePage basePage = context.getConstructor(WebDriver.class).newInstance(driver);
            basePage.clickArrowIcon();
            basePage.clickDropdownItem(item);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("No such page");
        }
    }

    private <T extends BaseStep> T verifySidebarItem(Class<T> stepContext,
                                                     Class<? extends BasePage> pageContext,
                                                     boolean expected, String item, WebDriver driver) {
        try {
            BasePage basePage = pageContext.getConstructor(WebDriver.class).newInstance(driver);
            Assert.assertEquals(basePage.sidebarItemExist(item), expected);
            return stepContext.getConstructor(WebDriver.class).newInstance(driver);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("No such page or step");
        }
    }

}
