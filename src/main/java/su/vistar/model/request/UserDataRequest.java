package su.vistar.model.request;

import java.io.Serializable;
import java.util.List;

public class UserDataRequest implements Serializable {
    private List<CarRequest> cars;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String second_name;
    private String email;
    private String phone;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return this.second_name;
    }

    public void setSecondName(String second_name) {
        this.second_name = second_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CarRequest> getCars() {
        return this.cars;
    }

    public void setCars(List<CarRequest> cars) {
        this.cars = cars;
    }
}