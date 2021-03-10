package com.dealership.ui;

import com.dealership.services.CarService;

import java.sql.SQLException;
import java.util.Scanner;

public class userMenu {
    static CarService cs = new CarService();
    static SignUpMenu newMenu = new SignUpMenu();
    static LoginMenu  newLoginMenu = new LoginMenu();
    static EmpLoginMenu newEmpMenu = new EmpLoginMenu();
    public void showMenu(Scanner scan) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        boolean continueLoop = true;
        scan = new Scanner(System.in);
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
    }
}

