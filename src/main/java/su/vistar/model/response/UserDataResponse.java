package su.vistar.model.response;

import su.vistar.model.entity.UserData;

import java.io.Serializable;

public class UserDataResponse implements Serializable {
    private String username;
    private String name;
    private String surname;
    private String secondName;
    private String email;
    private String phone;

    public UserDataResponse(UserData userData) {
        this.username = userData.getUsername();
        this.name = userData.getName();
        this.surname = userData.getSurname();
        this.secondName = userData.getSecondName();
        this.email = userData.getEmail();
        this.phone = userData.getPhone();
    }
}