package constants;

public class APIConst {

    public static final String BASE_URL = "https://whatbackend.azurewebsites.net/api/";
    public static final String HEADER = "authorization";

    public interface Data {
        String EMAIL = "email",
                PASSWORD = "password",
                ID = "id",
                NAME = "name",
                FIRST_NAME = "firstName",
                LAST_NAME = "lastName",
                IS_ACTIVE= "isActive",
                ROLE= "role";
    }
    public interface Result {
        String TRUE = "true",
                FALSE = "false";
    }

}
