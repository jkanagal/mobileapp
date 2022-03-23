package com.example.myapplication_smartblinds;

public class User {

    public String fullName, desiredtemp, email;

    public User(){

    }

    public User(String fullName, String desiredtemp, String email){
        this.fullName = fullName;
        this.email=email;
        this.desiredtemp = desiredtemp;
    }
}