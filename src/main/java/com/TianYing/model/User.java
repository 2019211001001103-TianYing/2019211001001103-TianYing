package com.TianYing.model;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String Password;
    private String Email;
    private java.util.Date Birthdate;
    private String sex;
    //constructor

    public User() {
    }
    public User(int id, String username, String Password, String Email, Date Birthdate, String sex){
        this.id=id;
        this.username=username;
        this.Password=Password;
        this.Email=Email;
        this.Birthdate=Birthdate;
        this.sex=sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Birthdate=" + Birthdate +
                ", sex='" + sex + '\'' +
                '}';
    }
}
