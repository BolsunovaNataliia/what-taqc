package entity;

import lombok.Data;

@Data
public class User {

    private byte id;
    private byte role;

    private String first_name;
    private String last_name;

    private String email;
    private String password;

}
