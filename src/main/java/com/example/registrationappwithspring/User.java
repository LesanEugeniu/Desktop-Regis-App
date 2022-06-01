package com.example.registrationappwithspring;

public class User {
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public User(String firstname, String lastname, String username, String password){
        setFirstname(firstname);
        setLastname(lastname);
        setUsername(username);
        setPassword(password);
    }
    public User(String username, String password){
        setUsername(username);
        setPassword(password);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
