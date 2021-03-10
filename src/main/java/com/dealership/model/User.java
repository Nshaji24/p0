package com.dealership.model;

import java.util.Scanner;

public class User extends Object{


    private userType usType;
    private int userID;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    Scanner scan = new Scanner(System.in);


    public User(int userID,String username, String password, String phoneNumber, String email,userType usType){
        this.userID = userID;
        this.usType = usType;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public userType getUsType() {return usType;}

    public void setUsType(userType usType) {
        this.usType = usType;
    }

    public void setUserID(int userID){
        this.userID = userID;
    }

    public int getUserID(){
        return userID;
    }

    public User(int userID,String username, String password, String phoneNumber, String email) {
        this.userID =userID;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        System.out.println("Your username is :" +username);
        return username;
    }

    public void setUsername(String username) {
        System.out.println("Enter your username");
        this.username= scan.nextLine();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("Enter your password");
        this.password = scan.nextLine();
    }

    public String getPhoneNumber() {
        System.out.println("Your phone number is :" + phoneNumber);
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        System.out.println("Enter your phone number");
        this.phoneNumber = scan.nextLine();
    }

    public String getEmail() {
        System.out.println("Your email is :" + email);
        return email;
    }

    public void setEmail(String email) {
        System.out.println("Enter your email");
        this.email = scan.nextLine();
    }
}
