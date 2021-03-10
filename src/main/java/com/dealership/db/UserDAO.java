package com.dealership.db;

import com.dealership.model.Car;
import com.dealership.model.User;
import com.dealership.util.dealershipCollection;

import java.sql.*;
import java.util.Scanner;

import static com.dealership.config.ConnectionUtil.getConnection;

public class UserDAO implements GenericDAO<User> {
    carDAO cdd = new carDAO();
    private static UserDAO instance;

    //public UserDAO(){}

    static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }


    @Override
    public void save(User us) {
        try {
            String sql = "insert into dealershipuser values ('" + us.getUserID() + "','" +
                    us.getUsername() + "', '" + us.getPassword() + "', '" +
                    us.getPhoneNumber() + "', '" + us.getEmail() + "', '" + us.getUsType() + "')";

            Statement st = getConnection().createStatement();
            int i = st.executeUpdate(sql);
            System.out.println("Your user ID is : " + us.getUserID());
            System.out.println("The number of updated rows were " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println("use a different username");
    }

    public void saveUserCar(Car c) {

        try {
            String sql = "insert into dealershipusercars values ('" +
                    c.getMake() + "', '" + c.getModel() + "', '" +
                    c.getYearMade() + "', '" + c.getMileage() + "', '" + c.getPrice() + "', '" + c.getCar_condition() + "' )";

            Statement st = getConnection().createStatement();
            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(User us) throws SQLException {

        return us;
    }

    @Override
    public dealershipCollection getAll() {
        return null;
    }

    @Override
    public boolean remove(User id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public int updateAll(dealershipCollection collection) {
        return 0;
    }


    public boolean checkUser(String username) throws SQLException {
        boolean checkUsername = false;

        PreparedStatement st = getConnection().prepareStatement("select * from dealershipuser where username = ? ");
        st.setString(1, username);
        ResultSet r1 = st.executeQuery();
        if (r1.next()) {
            System.out.println("Username already exists in database");
            checkUsername = true;
        } else {
            System.out.println("No duplicate user");

        }
        return checkUsername;
    }


    public boolean getUserByUserNameAndPassword(String user, String pass) {
        boolean checkUser = false;
        try {
            PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM dealershipuser WHERE username=? AND password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("User already exists in database");
                checkUser = true;
            } else {
                checkUser = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return checkUser;
    }

    public String getUserName(String username) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement("SELECT username FROM dealershipuser WHERE username=? ");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            username = rs.getString("username");
        }
        return username;
    }




    public void makeOffer(String make, String model, String offer, int offerID, int car_id,String username) throws SQLException {
        Statement st = getConnection().createStatement();
        String sql = "insert into dealershiplotoffers values ('" + make  +  "', '" + model+  "', '" + offer + "', '"+ offerID +"', '" +car_id+ "', '" +username+"')";
        st.executeUpdate(sql);

    }
    public int getUserID(int userID) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("select id from dealershipuser where id = ? ");
        st.setInt(1, userID);
        ResultSet r1 = st.executeQuery();
        while(r1.next()) {

            System.out.print("ID of user : "+r1.getInt("id"));
            return r1.getInt("id");
        }



        return 0;
    }

    public void getUserCar(String username) throws SQLException {

        PreparedStatement st = getConnection().prepareStatement("select * from dealershipusercars where username = ? ");
        st.setString(1, username);
        ResultSet r1 = st.executeQuery();
        ResultSetMetaData md = r1.getMetaData();
        int columnsNumber = md.getColumnCount();
        while (r1.next()) {
            for (int i = 1; i < columnsNumber; i++) {
                String columnName = r1.getMetaData().getColumnName(i);
                System.out.print(columnName + " :  " + r1.getString(i) + " ");

            }
            System.out.println();
        }
    }

    public void buyFromLot(int car_id,String username) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("insert into dealershipusercars (make,model,yearmade,mileage,price,car_condition,car_id,username)" +
                "select make,model,yearmade,mileage,price,car_condition,car_id,? from dealershiplot where car_id = ? ");


        st.setString(1,username);
        st.setInt(2, car_id);

        st.executeUpdate();

        System.out.println("Car successfully bought");
        empDAO.removeFromLot(car_id);


    }


    public int getRemainingPayment(int car_id) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("select price from dealershipusercars where car_id = ?");
        st.setInt(1,car_id);
        ResultSet r1 = st.executeQuery();
        ResultSetMetaData md = r1.getMetaData();
        int columnsNumber = md.getColumnCount();

        while (r1.next()) {
            int remPrice = r1.getInt("price");
            System.out.println("Remaining amount owed on car is : " + remPrice);
            System.out.println("Would you like to see monthly payment options? y/n");
            Scanner scan = new Scanner(System.in);
            String uInput = scan.nextLine();
            if ((uInput.equalsIgnoreCase("y"))) {
                System.out.println("Select number of months you would like to pay over : 36 | 48 | 60 | 72 ");
                int input =scan.nextInt();
                switch (input){
                    case 36:
                        System.out.println("Monthly payment owed is " + (remPrice/36));
                        break;
                    case 48:
                        System.out.println("Monthly payment owed is " + (remPrice/48));
                        break;
                    case 60:
                        System.out.println("Monthly payment owed is " + (remPrice/60));
                        break;
                    case 72:
                        System.out.println("Monthly payment owed is " + (remPrice/72));
                        break;
                    default:
                        System.out.println("no option selected");
                }
            }else if (uInput.equalsIgnoreCase("n")){
                System.out.println("Have a nice day!");
            }
        }

        return columnsNumber;
    }


    public void viewCars() {
        try {
            Statement st = getConnection().createStatement();
            String sql = ("select * from dealershiplot;");
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columnsNumber = md.getColumnCount();


          /*  for (int index = 1; index <= columnsNumber; index++) {
                String columnName = rs.getMetaData().getColumnName(index);
                System.out.print(columnName+ " ");*/
          //  }
            while (rs.next()) {
                System.out.println();
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    System.out.print(columnName +" :  " + rs.getString(i) + " ");

                    }
                    System.out.println();
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
    }

    public void makePayment(String username, int car_id,int amountpaid,int carprice) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("insert into payments (username,car_id,amountpaid,carprice,upprice)" +
                "select ?,?,?,?,? from dealershipusercars where username = ? ");


        st.setString(1,username);
        st.setInt(2, car_id);
        st.setInt(3,amountpaid);
        st.setInt(4, cdd.getcarprice(username));
        st.setString(6, username);
        st.setInt(5,cdd.upprice(username));


        st.executeUpdate();

        System.out.println("Payment successfull");
        cdd.upprice(username);


    }

}
