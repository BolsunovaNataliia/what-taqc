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

    public interface SignInPage {
        String  SIGNIN_HEADER = "//h3",
                EMAIL_FIELD = "//input[@id='email']",
                PASSWORD_FIELD = "//input[@id='password']",
                SIGNIN_BUTTON = "//button[@type='submit']",
                //a[@class='auth__form-link___3Q9Ou']
                FORGOT_PASSWORD_LINK = "//a[@href='/forgot-password']",
                REGISTRATION_LINK = "//a[@href='/registration']",
                ERROR_SIGNIN = "//button[@type='submit']/../following-sibling::p";
    }

    public interface RegistrationPage {
        String  SIGNUP_HEADER = "//h3",
                FIRST_NAME_FIELD = "//input[@id='firstName']",
                LAST_NAME_FIELD = "//input[@id='lastName']",
                EMAIL_FIELD = "//input[@id='email']",
                PASSWORD_FIELD = "//input[@id='password']",
                CONFIRM_PASSWORD_FIELD = "//input[@id='confirm-password']",
                SIGNUP_BUTTON = "//button[@type='submit']",
                SIGNIN_LINK = "//a[@href='/auth']",
                FIRST_NAME_ERROR_FIELD = "//input[@name='firstName']//following-sibling::p",
                LAST_NAME_ERROR_FIELD = "//input[@name='lastName']//following-sibling::p",
                EMAIL_ERROR_FIELD = "//input[@name='email']//following-sibling::p",
                PASSWORD_INVALID_FIELD = "//input[@name='password']//following-sibling::p",
                CONFIRM_PASSWORD_INVALID_FIELD = "//input[@name='confirmPassword']//following-sibling::p",
                SUCCESSFUL_REGISTRATION_ALERT = "//p[contains(text(),'You have successfully registered')]",
                SUCCESSFUL_REGISTRATION_BUTTON = "//button[@type='submit']",
                ERROR_SIGNUP = "//button[@type='submit']/../following-sibling::p";
    }

    public interface ChangePasswordPage {
        String EMAIL_FIELD = "//input[@id='email']",
                CURRENT_PASSWORD_FIELD = "//input[@id='currentPassword']",
                NEW_PASSWORD_FIELD = "//input[@id='newPassword']",
                CONFIRM_PASSWORD_FIELD = "//input[@id='confirmNewPassword']",
                CANCEL_BUTTON = "//button[contains(@Class, 'cancel-button')]",
                CURRENT_PASSWORD_ERROR_FIELD = "//input[@name='currentPassword']//following-sibling::div",
                NEW_PASSWORD_ERROR_FIELD = "//input[@name='newPassword']//following-sibling::div",
                CONFIRM_PASSWORD_ERROR_FIELD = "//input[@name='confirmNewPassword']//following-sibling::div",
                PASSWORD_SUCCESSFULLY_CHANGED_MESSAGE = "//div[@role='alert']";
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
                CANCEL_BTN = "//button[contains(@class,'btn-secondary')]",


                CONFIRM_COURSE_DELETE_BTN = "//button[contains(@class,'btn-danger')]";
    }

    public interface EditStudentsDetailsPage {
        String LABEL_STUDENTS_DETAILS = "//div[@class='nav nav-tabs']//a[not(contains(@class, 'tab__active'))]",
                LABEL_EDIT_STUDENTS_DETAILS = "//a[contains(@class, 'tab__active')]",
                FIRST_NAME = "//input[@name='firstName']",
                LAST_NAME = "//input[@name='lastName']",
                EMAIL = "//input[@name='email']",
                LIST_OF_GROUPS = "//li[@data-groupid]",
                BUTTON_EXCLUDE = "//button[contains(@class, 'exclude-btn')]",
                BUTTON_CLEAR = "//button[@type='reset']",
                BUTTON_SAVE = "//button[@type='submit']";
    }

    public interface StudentDetailsPage {
        String LABEL_STUDENTS_DETAILS = "//a[contains(@class, 'tab__active')]",
                FIRST_NAME = "//div[@class='col-12 col-md-6']",
                LAST_NAME = "//div[@class='col-12 col-md-6 ']/span[not(contains(text(), '@'))]",
                EMAIL = "//span[contains(text(), '@')]",
                LIST_OF_GROUPS = "//a[contains(@href, '/groups/')]",
                LIST_OF_LESSONS = "//a[contains(@href, '/lessons/')]";
    }

}
