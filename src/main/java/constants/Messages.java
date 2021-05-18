package constants;

public class Messages {

    public interface Alerts {

        String SUCCESSFULLY_CHANGED_PASSWORD = "The password has been successfully changed",
                SUCCESS_MESSAGE_REGISTRATION = "You have successfully registered. " +
                        "Please, wait until your account is approved and your role is assigned";


    }

    public interface Errors {

        String FIELD_IS_REQUIRED = "This field is required",
                INVALID_COURSE_NAME = "Invalid course name";


        String INVALID_FIRST_NAME = "Invalid first name",
                INVALID_LAST_NAME = "Invalid last name",
                INVALID_EMAIL_ADDRESS = "Invalid email address",
                PASSWORD_MUST_CONTAIN_AT_LEAST_8_CHARACTERS = "Password must contain at least 8 characters",
                YOU_SHOULD_CONFIRM_YOUR_PASSWORD = "You should confirm your password";

    }
}
