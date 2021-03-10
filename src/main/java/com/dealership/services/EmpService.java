package com.dealership.services;






import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

import com.dealership.db.carDAO;
import com.dealership.db.empDAO;

public class EmpService {
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
                    System.out.println("Offer accepted!");
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



}

