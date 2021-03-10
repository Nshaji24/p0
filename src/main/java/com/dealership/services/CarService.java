package com.dealership.services;

import com.dealership.db.UserDAO;
import com.dealership.db.carDAO;
import com.dealership.model.Car;
import java.sql.SQLException;
import java.util.Scanner;


public class CarService {
     UserDAO userDAO =  new UserDAO();
     carDAO carD = new carDAO();

    public static Car[] lotCars = new Car[10];
    public static Car[] userOwnedCar = new Car[10];
   // UserService us = new UserService();
    private static int currentIndex = -1;
    Scanner scan = new Scanner(System.in);
    public String[] carOffers = new String[10];

    public boolean addCar(String make, String model, int yearMade, int mileage, int price, String condition, int car_id) {
        System.out.println("Enter car make");
        make = scan.nextLine();
        System.out.println("Enter car model");
        model = scan.nextLine();
        System.out.println("Enter car year made");
        yearMade = scan.nextInt();
        System.out.println("Enter car mileage");
        mileage = scan.nextInt();
        System.out.println("Enter car price");
        price = scan.nextInt();
        System.out.println("Enter car condition");
        condition = scan.nextLine();
        car_id = (int) Math.round(Math.random() * 100);

                carD.save(new Car(make, model, yearMade, mileage, price, condition,car_id));
                return true;
    }

    public boolean addUserCar(String make, String model, int yearMade, int mileage, int price, String condition,int userID) throws SQLException {
        System.out.println("Enter car make");
        make = scan.nextLine();
        System.out.println("Enter car model");
        model = scan.nextLine();
        System.out.println("Enter car year made");
        yearMade = scan.nextInt();
        System.out.println("Enter car mileage");
        mileage = scan.nextInt();
        System.out.println("Enter car price");
        price = scan.nextInt();
        System.out.println("Enter car condition");
        condition = scan.nextLine();
        userDAO.getUserID(userID);

                userDAO.saveUserCar(new Car(make, model, yearMade, mileage, price, condition,userID));
                return true;

    }



    public void findCarByCarUserName(String username) {

    }


    public void viewLot() {
        userDAO.viewCars();
    }


    public void getUserCar() throws SQLException {
        System.out.println("Enter your username");
        String username =scan.nextLine();
        userDAO.getUserCar(username);
    }


    public void makeOffer(String make, String model,String offer,int offerID) throws SQLException {
        userDAO.viewCars();
        System.out.println("Enter desired car make");
        make = scan.nextLine();
        System.out.println("Enter car model");
        model = scan.nextLine();
        System.out.println("Enter your offer" );
        offer=scan.nextLine();
        offerID= (int) Math.round(Math.random() * 100);
        userDAO.makeOffer(make,model,offer,offerID);

    }
}



