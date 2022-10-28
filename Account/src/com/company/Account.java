package com.company;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountName;
    private String firstName;
    private String lastName;
    private String email;
    private  List<String> roles=new ArrayList<>();

    public Account(String account, String firstName, String lastName, String email, List<String> role) {
        this.accountName = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = role;
    }

    public String getAccount() {
        return accountName;
    }

    public void setAccount(String account) {
        this.accountName = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRoles(String rol){
        roles.add(rol);

    }

    @Override
    public String toString() {
        return " "+ getRoles();
    }
}
