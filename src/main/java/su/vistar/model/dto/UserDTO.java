package su.vistar.model.dto;

import su.vistar.model.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String second_name;
    private String email;
    private String phone;

    private List<CarDTO> cars = new ArrayList<>();

    public UserDTO(){}
    public UserDTO(String username, String password){
        setUsername(username);
        setPassword(password);
    }
    public UserDTO(UserDAO user){
        setUsername(user.getUsername());
        setPassword(user.getPassword());

        setName(user.getName());
        setSurname(user.getSurname());
        setSecondName(user.getSecondName());
        setEmail(user.getEmail());

    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public List<CarDTO> getCars(){return this.cars;}
    public void setCars(List<CarDTO> cars) {this.cars = cars;}

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() { return this.name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() { return this.surname; }
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
    public void setPhone(String second_name) {
        this.phone = phone;
    }

}
