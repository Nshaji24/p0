package com.dealership.services;

import com.dealership.db.UserDAO;
import com.dealership.db.carDAO;
import com.dealership.model.User;
import com.dealership.ui.SignUpMenu;
import com.dealership.ui.userMenu;
import com.enterprise.annotations.TestMethod;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    CarService cs = new CarService();
 //   CarService userCar = new CarService();
    SignUpMenu sm = new SignUpMenu();
    userMenu um = new userMenu();

    carDAO cd = new carDAO();
    Scanner scan = new Scanner(System.in);
    UserDAO uj = new UserDAO();
    public static User[] users = new User[6];
    private static int currentIndex = -1;

@TestMethod
    public boolean doesUsernameExist(String username) throws SQLException {
        if (uj.checkUser(username)) {
            return true;
        }
        return false;
    }


    public User findUserByUsername(String username) {

        return null;
    }

    public boolean makeUser(int userID, String username, String password, String phoneNumber, String email) throws SQLException {
        uj.save(new User(userID, username, password, phoneNumber, email));
        return false;
    }

    public boolean purchaseCar() throws SQLException {
        System.out.println("Enter your username ");
        String username = scan.nextLine();
       // uj.getUserName(username);
        System.out.println("Enter car id of car you would like to purchase");
        int car_id = Integer.parseInt(scan.next());
        uj.buyFromLot(car_id,username);

        return false;
    }

    public void makePayment(String username,int car_id,int amountpaid,int carprice) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        uj.makePayment(username,car_id,amountpaid,uj.getRemainingPayment(car_id));
    }

    public void userMenu() throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        System.out.println("Please chose from the following options: 1=>View Cars in Lot %n 2=>Purchase a car %n 3=> " +
                "View Payments remaining on car %n 4 =>make an offer on a car 5=>view cars you own 6=>make a payment 7=>exit");
          String input = scan.nextLine();
          switch (input){
              case "1" :
                  cs.viewLot();
                  break;
              case "2" :
                  cs.viewLot();
                  purchaseCar();
                  break;
              case "3" :
                  System.out.println("Now checking remaining payments on car");
                  System.out.println("Enter your car ID");
                  int car_id = scan.nextInt();
                  uj.getRemainingPayment(car_id);
                  break;
              case "4" :
                  System.out.println("Your selected make an offer");
                  cs.makeOffer("", "", "", (int) Math.round(Math.random() * 100));
                  System.out.println("sucessuly made an offer");
                  break;
              case "5" :
                  System.out.println("viewing cars you own");
                  cs.getUserCar();
                  break;
              case "6" :
                  System.out.println("Enter your username");
                  scan = new Scanner(System.in);
                  String username = scan.nextLine();
                  cd.getcarID(username);
                  System.out.println();
                  System.out.println("Enter car ID");
                  car_id = scan.nextInt();
                  /*System.out.println("current remaining price is : ");
                  uj.getRemainingPayment(car_id);*/
                  System.out.println("Enter amount you want to pay");
                  int amountpaid = scan.nextInt();
                  makePayment(username,car_id,amountpaid,0);
              case "7" :
                  um.showMenu(scan);
              default:

                  break;
          }
         /* if (input.equalsIgnoreCase("1")) {
              cs.viewLot();
          } else if (input.equalsIgnoreCase("2")) {
              cs.viewLot();
              purchaseCar();
              // continueLoop=false;
          } else if (input.equalsIgnoreCase("3")) {
              System.out.println("Now checking remaining payments on car");
              System.out.println("Enter your car ID");
              int car_id = scan.nextInt();
              uj.getRemainingPayment(car_id);
          } else if (input.equalsIgnoreCase("4")) {
              continueLoop = false;
          } else if (input.equalsIgnoreCase("5")) {
              System.out.println("viewing cars you own");
              cs.getUserCar();
              continueLoop = false;
          } else if (input.equalsIgnoreCase("6")) {
              System.out.println("Your selected make an offer");
              cs.makeOffer("", "", "", (int) Math.round(Math.random() * 100));
              System.out.println("sucessuly made an offer");
              System.out.println("For security purposes please log in again");
              continueLoop = false;
          }
          return continueLoop;
      */
    }
}