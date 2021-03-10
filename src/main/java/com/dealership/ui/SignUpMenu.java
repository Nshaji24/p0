package com.dealership.ui;

import com.dealership.services.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class SignUpMenu {


    public void ShowMenu(Scanner scan) throws SQLException {
        UserService us = new UserService();
        System.out.println("====Welcome to Noels Car Dealership====");
        String username = "";
        do{
            System.out.println("provide username");
            username = scan.nextLine();
        } while(us.doesUsernameExist(username));

        int userID = (int) Math.round(Math.random() * 100);
        System.out.println("provide password");
        String password = scan.nextLine();
        System.out.println("provide phone number");

        String phoneNumber = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();

        System.out.println(us.makeUser(userID,username, password, phoneNumber, email));



    }



}
