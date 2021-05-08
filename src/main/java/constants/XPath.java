package constants;

public class XPath {

    public interface Common {
        String H3 = "//h3",
                H2 = "//h2",
                A = "//a",
                P = "//p",
                SPAN_WITHOUT_SLASH = "span",

        COURSE_NAME_INPUT = "//input[@id='name']",

        TABLE_HEADLINES = "//thead//th",
                TABLE_CONTENT = "//tbody//tr",

        ROW_ON_DETAILS_PAGE = "//*[contains(@class,'row') and contains(@class,'mb-4')] | //div[@ class='row']",

        RESET_BUTTON = "//button[@type='reset']",
                SAVE_BUTTON = "//button[@type='submit']";

    }

    public interface ChangePasswordPage {
        String EMAIL_FIELD = "//input[@id='email']",
                CURRENT_PASSWORD_FIELD = "//input[@id='currentPassword']",
                NEW_PASSWORD_FIELD = "//input[@id='newPassword']",
                CONFIRM_PASSWORD_FIELD = "//input[@id='confirmNewPassword']",
                CANCEL_BUTTON = "//button[contains(@Class, 'cancel-button')]",
                CURRENT_PASSWORD_ERROR_FIELD = "//input[@name='currentPassword']//following-sibling::div",
                NEW_PASSWORD_ERROR_FIELD = "//input[@name='newPassword']//following-sibling::div",
                CONFIRM_PASSWORD_ERROR_FIELD = "//input[@name='confirmNewPassword']//following-sibling::div";
    }

    public interface AddCoursePage {
        String CANCEL_COURSE_ADDING_BTN = "//div[contains(@class,'d-flex')]/a[.='Cancel']";
    }

    public interface CourseDetailsPage {
        String EDIT_COURSE_DETAILS_TAB = "//div[contains(@class,'nav-tabs')]/a[contains(text(),'Edit')]",
                COURSE_NAME = "//div[@class='row']/div/following-sibling::div/span";
    }

    public interface CoursesPage {
        String ADD_COURSE_TO_LIST_BTN = "//div[contains(@class,'col-2 offset-5')]/button",
                SEARCH_COURSE_IN_LIST_INPUT = "//input[contains(@class,'search')]",
                COURSE_LIST_ID_SORT_TYPE = "//span[@data-sorting-param='id']",
                COURSE_LIST_NAME_SORT_TYPE = "//span[@data-sorting-param='name']",
                LIST_OF_COURSE_TABLE_ROWS = "//tr[contains(@class,'list-of-courses')]",
                LIST_OF_COURSE_TABLE_EDIT_ICONS = "//td[@data-student-id]/*",
                LEFT_NAVIGATION_ARROW_BTN = "//nav[contains(@class,'flex-row')]/ul[1]//button",
                RIGHT_NAVIGATION_ARROW_BTN = "//nav[contains(@class,'flex-row')]/ul[3]//button",
                NUMBER_OF_COURSES = "//span[contains(@class,'col-2')]";
    }

    public interface EditCourseDetailsPage {
        String COURSE_DETAILS_TAB = "//div[contains(@class,'nav-tabs')]/a[1]",
                DELETE_COURSE_BTN = "//button[contains(@class,'remove-button')]",
                FAILED_COURSE_DELETION_ALERT = "//div[@role='alert' and contains(text(),'not found') or contains(text(),'active')]",
                FAILED_EDIT_COURSE_SUBMIT_ALERT = "//div[@role='alert' and contains(text(),'Inactive') or contains(text(),'included')]",
                CONFIRM_COURSE_DELETE_BTN = "//button[contains(@class,'btn-danger')]";
    }

    public interface LessonDetailsPage {
        String PRESENT_ICON_XPATH = "//*[contains(@href,'Present')]",
                VALUE_FIELD_INFO_LESSON_XPATH = "div[@class='col-sm-6'] | div[@class='col-sm-6 lead']",
                NAME_FIELD_INFO_LESSON_XPATH = "div[contains(@class,'col-sm-6 font-weight-bolder')]",
                MARK_XPATH = "td[@class='text-center align-content-center']",
                ID_XPATH = "th[@scope='row']",
                CANCEL_BTN = "//button[@class='btn-secondary']",


                CONFIRM_COURSE_DELETE_BTN = "//button[contains(@class,'btn-danger')]";
    }


}
