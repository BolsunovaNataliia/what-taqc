package constants;

public class Constants {

    public static String NUMBER = "#",
            EMPTY_STRING = "";

    public interface PageName {
        String MY_PROFILE = "My Profile",
                CHANGE_PASSWORD = "Change password",
                LOD_OUT = "Log Out",

        MENTOR_EDIT = "Mentor Editing",
                MENTOR_DETAILS = "Mentor Details",
                MENTOR_LIST = "Mentors",

        STUDENT_EDIT_DETAILS = "Edit student details",
                STUDENT_DETAILS = "Student details",
                STUDENT_LIST = "Students",

        SECRETARY_EDIT = "Edit Secretary's details",
                SECRETARY_DETAILS = "Secretary's details",
                SECRETARY_LIST = "Secretaries",

        LESSON_EDIT = "Edit a Lesson",
                LESSON_DETAILS = "Lesson details",
                LESSON_LIST = "Lessons",

        GROUP_EDIT = "Group Editing",
                GROUP_DETAILS = "Group:",
                GROUP_LIST = "Groups",

        COURSE_EDIT = "Course Editing",
                COURSE_DETAILS = "Course Details",
                COURSE_LIST = "Courses",
                COURSE_ADD = "Add a course",

        SUPPORT = "Support",
                UNASSIGNED = "Unassigned",

        SIGN_IN = "Sign in",
                REGISTRATION = "Sign up";
    }

    public interface LessonDetails {
        String LESSON_NAME = "Lesson Theme:",
                MENTOR_NAME = "Mentor name:",
                GROUP_NAME = "Group name:",
                LESSON_DATE = "Lesson Date:",
                LESSON_TIME = "Lesson Time:";
    }

    public interface DetailsAboutUser {
        String FIRST_NAME = "First Name:";
        String LAST_NAME = "Last Name:";

        String EMAIL = "Email:";
        String EMAIL_ADDRESS = "Email address:";

        String GROUP = "Group('s):";
        String COURSE = "Course('s):";
    }

    public interface ListUser {
        String NAME = "Name";
        String SURNAME = "Surname";

        String EMAIL = "Email";

        String ROLE = "Choose role";
    }

    public interface ListFeatures {
        String EDIT = "Edit";

        String GROUP_NAME = "Group Name";
        String LESSON_NAME = "Theme Name";
        String COURSE_NAME = "Title";

        String QUANTITY_STUDENTS = "Quantity of students";

        String DATE = "Date";
        String DATE_START = "Date of start";
        String DATE_END = "Date of finish";

        String TIME = "Time";
    }

    public interface UnassignedUsersSelectRole {
        String CHOOSE = "Choose role";
        String STUDENT = "student";
        String MENTOR = "mentor";
        String SECRETARY = "secretary";
    }

    public interface UnassignedUsersSort {
        String SYMBOL = "0";
        String NAME = "1";
        String SURNAME = "2";
        String EMAIL = "3";
    }

}
