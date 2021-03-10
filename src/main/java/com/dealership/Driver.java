package com.dealership;


import com.dealership.db.carDAO;
import com.dealership.services.CarService;
import com.dealership.ui.EmpLoginMenu;
import com.dealership.ui.LoginMenu;
import com.dealership.ui.SignUpMenu;

import java.sql.SQLException;
import java.util.Scanner;

import static com.dealership.services.CarService.lotCars;

public class Driver {

    static CarService cs = new CarService();
    static SignUpMenu newMenu = new SignUpMenu();
    static LoginMenu  newLoginMenu = new LoginMenu();
    static EmpLoginMenu newEmpMenu = new EmpLoginMenu();
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        boolean continueLoop = true;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("View Lot , Sign Up, Login , Employee Login or Exit");
            String input = scan.nextLine();
            if(input.equalsIgnoreCase("sign up")){
                newMenu.ShowMenu(scan);
            }else if (input.equalsIgnoreCase("login")){
                    newLoginMenu.showMenu(scan);
            }else if (input.equalsIgnoreCase("exit")){
                continueLoop=false;
            }else if (input.equalsIgnoreCase("Employee Login")){
                newEmpMenu.showMenu(scan);
            }else if (input.equalsIgnoreCase("View Lot")){
                cs.viewLot();
            }

        }while(continueLoop);

        System.out.println(lotCars[0]);


    }
}
