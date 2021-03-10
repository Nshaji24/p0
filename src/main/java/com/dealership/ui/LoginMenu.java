package com.dealership.ui;
import com.dealership.db.UserDAO;
import com.dealership.services.CarService;
import com.dealership.services.UserService;
import java.sql.SQLException;
import java.util.Scanner;
public class LoginMenu {

    boolean continueLoop;
    CarService userCar =  new CarService() ;
    CarService cs = new CarService();
    UserService us = new UserService();
    CarService userOwnedCar = new CarService();
    UserDAO jc = new UserDAO();
    public void showMenu(Scanner scan) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {


        System.out.println("username: ");
        String username = scan.nextLine();
        System.out.println("password: ");
        String password = scan.nextLine();


            if(jc.getUserByUserNameAndPassword(username,password)){
                System.out.println("Login Successful! Welcome!");
                boolean continueLoop = true;
                do {
                    us.userMenu();
                } while (continueLoop);

            } else {
                System.out.println("login failed");
                showMenu(scan);
                boolean continueLoop = false;


            }
    }

}








