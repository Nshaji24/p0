package com.dealership.services;






import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

import com.dealership.db.UserDAO;
import com.dealership.db.carDAO;
import com.dealership.db.empDAO;

public class EmpService {
    UserDAO uj = new UserDAO();
    empDAO ed = new empDAO();
    carDAO cd = new carDAO();
    public void showOfferMenu(Scanner scan) throws SQLException {
        System.out.println("Would you like to accept any of these offers? y/n");
        switch (scan.nextLine()) {
            case "y" :
                System.out.println("select the ID of the offer you want to accept");
                int offerID = scan.nextInt();
                System.out.println("enter make of car the offer is on ");
                String make = scan.next();
                ed.checkOfferID(offerID);
                if(ed.checkOfferID(offerID)){
                    System.out.println("Offer accepted! ");
                    moveCar();
                    System.out.println("All other offers removed");
                    ed.removeOffersfromCar(cd.getMake(make));

                }else {
                    System.out.println("no offer found");
                }
                break;
            case "n":
                break;
        }

    }

    public void moveCar() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter customer username ");
        String username = scan.nextLine();
        System.out.println("Enter car id of car customer would like to purchase");
        int car_id = Integer.parseInt(scan.next());
        uj.buyFromLot(car_id,username);
        System.out.println("Car moved to user account");
    }

    public void makeEmployee() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter desired employee id ");
        int id=scan.nextInt();
        System.out.println("Enter desired username");
        String username = scan.next();
        System.out.println("Enter desired password");
        String password = scan.next();
        ed.makeEmp(id,username,password);
    }



}

