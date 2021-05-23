package step.lesson;

import constants.Messages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.lesson.ListOfLessonPage;
import step.BaseStep;

import java.util.List;

public class ListOfLessonPageStep extends BaseStep {

    ListOfLessonPage listOfLessonPage;

    public ListOfLessonPageStep(WebDriver driver) {
        listOfLessonPage = new ListOfLessonPage(driver);
    }

    public ListOfLessonPageStep verifyNamePage(String expected) {
        Assert.assertEquals(listOfLessonPage.getPageName(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "PageName"));
        return this;
    }

    public ListOfLessonPageStep verifyCountOfLessons(String expected) {
        Assert.assertEquals(listOfLessonPage.getCountOfLessons(), expected,String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "CountOfLessons"));
        return this;
    }

    public ListOfLessonPageStep verifyRowCellText(int row, int col, String expected) {
        Assert.assertEquals(listOfLessonPage.getRowCellText(row, col), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "Cell["+row+","+col+"]"));
        return this;
    }

    public ListOfLessonPageStep verifySortingColText(int col, String expected) {
        Assert.assertEquals(listOfLessonPage.getSortingColText(col), expected,  String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "Column "+col));
        return this;
    }

    public ListOfLessonPageStep verifyBlockViewBtnEnabled(boolean expected) {
        Assert.assertEquals(listOfLessonPage.isBlockViewBtnEnabled(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "BlockViewBtn enabled"));
        return this;
    }

    public ListOfLessonPageStep verifyListViewBtnEnabled(boolean expected) {
        Assert.assertEquals(listOfLessonPage.isListViewBtnEnabled(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "ListViewBtn enabled"));
        return this;
    }

    public ListOfLessonPageStep verifyAddLessonBtnEnabled(boolean expected) {
        Assert.assertEquals(listOfLessonPage.isAddLessonBtnEnabled(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "AddLessonBtn enabled"));
        return this;
    }

    public ListOfLessonPageStep verifyButtonPageEnabled(int pageNum, boolean expected) {
        Assert.assertEquals(listOfLessonPage.isButtonPageEnabled(pageNum), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "ButtonPage enabled"));
        return this;
    }

    public ListOfLessonPageStep verifyEditBtnEnabled(int row, boolean expected) {
        Assert.assertEquals(listOfLessonPage.isLessonEditEnabled(row), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "EditBtn enabled"));
        return this;
    }

    public ListOfLessonPageStep verifyListOfTheme(List<String> expected) {
        Assert.assertEquals(listOfLessonPage.getAllThemeName(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "ListOfTheme"));
        return this;
    }

    public ListOfLessonPageStep verifyListOfDate(List<String> expected) {
        Assert.assertEquals(listOfLessonPage.getAllDate(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "istOfDate"));
        return this;
    }

    public ListOfLessonPageStep verifyListOfTime(List<String> expected) {
        Assert.assertEquals(listOfLessonPage.getAllTime(), expected, String.format(Messages.Asserts.THE_EXPECTED_RESULT_OF, "ListOfTime"));
        return this;
    }

    public ListOfLessonPageStep setThemeName(String name) {
        listOfLessonPage.setThemeSearchText(name);
        return this;
    }

    public ListOfLessonPageStep setDateInput(String dateInput) {
        listOfLessonPage.setDateSearch(dateInput);
        return this;
    }

    public ListOfLessonPageStep clickBlockViewBtn() {
        listOfLessonPage.clickBlockViewBtn();
        return this;
    }

    public ListOfLessonPageStep clickListViewBtn() {
        listOfLessonPage.clickListViewBtn();
        return this;
    }

    public ListOfLessonPageStep clickSorting(int col) {
        listOfLessonPage.clickSorting(col);
        return this;
    }

    public ListOfLessonPageStep clickButtonPage(int pageNum) {
        listOfLessonPage.clickButtonPage(pageNum);
        return this;
    }

    public LessonDetailsPageStep clickLessonDetails(int row, WebDriver driver) {
        listOfLessonPage.clickLessonDetails(row);
        return new LessonDetailsPageStep(driver);
    }

    public LessonEditPageStep clickLessonEdit(int row, WebDriver driver) {
        listOfLessonPage.clickLessonEdit(row);
        return new LessonEditPageStep(driver);
    }

    public void clickAddLessonBtn() {
        listOfLessonPage.clickAddLessonBtn();
    }

}
