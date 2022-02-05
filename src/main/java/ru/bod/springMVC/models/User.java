package ru.bod.springMVC.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    int id;
    @Size(min = 5, max = 10, message = "The field must contain from 5 to 10 characters!")
    String name;
    @Size(min = 5, max = 10, message = "The field must contain from 5 to 10 characters!")
    String password;
    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
