package com.dealership.ui;

import com.dealership.db.UserDAO;
import com.dealership.db.carDAO;
import com.dealership.db.empDAO;
import com.dealership.services.CarService;
import com.dealership.services.EmpService;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpLoginMenu {
    public void showMenu(Scanner scan) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        empDAO jc = new empDAO();
        carDAO cd = new carDAO();
        UserDAO ud = new UserDAO();
        LoginMenu lm = new LoginMenu();
        EmpService ems = new EmpService();
        userMenu um = new userMenu();

        System.out.println("username: ");
        String username = scan.nextLine();
        System.out.println("password: ");
        String password = scan.nextLine();

        for (int i = 0; i <= 2; i++) {
            if ((!jc.checkEmp(username)) || (!jc.checkEmpPassword(password))) {
                System.out.println("login failed");
                showMenu(scan);
            } else {
                System.out.println("Login Succesful! Welcome!");
                boolean continueLoop = true;


                //  do {
                System.out.println("Please chose from the following options: \n 1=>Add car to lot \n 2=>Remove Car from lot \n 3=>View Offers on Cars " +
                        "  \n 4=>View Payments \n 5=>view all registered users \n 6=>exit");
                String input = scan.nextLine();
                CarService n = new CarService();

                switch (input) {
                    case "1":
                        System.out.println("Add a Car");
                        n.addCar("", "", 0, 0, 0, "", 0);
                        break;
                    case "2":
                        ud.viewCars();
                        System.out.println("Remove a car");
                        System.out.println("ID of car to remove");
                        int car_id = scan.nextInt();
                        jc.removeFromLot(car_id);
                        break;
                    case "3":
                        System.out.println("View offers on Cars");
                        jc.viewOffers();
                        ems.showOfferMenu(scan);
                        break;
                    case "4":
                        System.out.println("view payments");
                        break;
                    case "5":
                        jc.getAllUsers();
                        break;
                    case "6":
                        um.showMenu(scan);
                        break;
                    case "7":
                        System.out.println("Register new employee");
                        ems.makeEmployee();

                }
                   /* if (input.equalsIgnoreCase("1")) {

                        System.out.println("Add a Car");
                        n.addCar("", "", 0, 0, 0, "",0);

                    } else if (input.equalsIgnoreCase("2")) {
                        ud.viewCars();
                        System.out.println("Remove a car");
                        System.out.println("ID of car to remove");
                        int car_id = scan.nextInt();
                        jc.removeFromLot(car_id);

                    } else if (input.equalsIgnoreCase("3")) {
                        System.out.println("View offers on Cars");
                        jc.viewOffers();
                        ems.showOfferMenu(scan);

                    } else if (input.equalsIgnoreCase("4")) {
                        System.out.println("view payments");

                    } else if (input.equalsIgnoreCase("5")) {
                        lm.showMenu(scan);
                    }
                } while (continueLoop);*/


                // }
            }
        }
    }

}



