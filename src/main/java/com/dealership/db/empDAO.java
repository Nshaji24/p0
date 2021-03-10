package com.dealership.db;

import com.dealership.config.ConnectionUtil;
import com.dealership.model.User;
import com.dealership.util.dealershipCollection;


import java.sql.*;
import java.util.Scanner;

import static com.dealership.config.ConnectionUtil.getConnection;

public class empDAO implements GenericDAO<User>{
    @Override
    public void save(User user) {

    }

    @Override
    public User getById(User id) {
        return null;
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

    public boolean checkEmp(String username) throws SQLException {
        boolean checkEmpName = false;

        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("select * from dealershipemp where username = ? ");
        st.setString(1, username);
        ResultSet r1 = st.executeQuery();
        if(r1.next()) {
            checkEmpName = true;
            System.out.println("employee  exists in database");
        }
        return checkEmpName;
    }

    public boolean checkEmpPassword(String password) throws SQLException {
        boolean checkEmpPass = false;

        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("select * from dealershipemp where password = ? ");
        st.setString(1, password);
        ResultSet r1 = st.executeQuery();
        if (r1.next()) {
            System.out.println("User already exists in database");
            checkEmpPass = true;
        } else {
            System.out.println("No duplicate user");

        }
        return checkEmpPass;
    }

    public void viewOffers() {
        try {

            Statement st = ConnectionUtil.getConnection().createStatement();
            String sql = ("select * from dealershiplotoffers;");
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columnsNumber = md.getColumnCount();

            while (rs.next()) {
                for(int i = 1; i <= columnsNumber; i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    System.out.print(columnName +"  :  "+ rs.getString(i) + "  "+ "");
                   // System.out.println();
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkOfferID(int offerID) throws SQLException {
        boolean checkOffer = false;

        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("select * from dealershiplotoffers where offerid = ? ");
        st.setInt(1, offerID);
        ResultSet r1 = st.executeQuery();
        if (r1.next()) {
            System.out.println("offer exists in database");
            checkOffer = true;
        } else {
            System.out.println("No offer detected");

        }
        return checkOffer;
    }

    public void removeOffersfromCar(String make) throws SQLException {
        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("delete from dealershiplotoffers where make = ? ");
        st.setString(1, make);
        int row = st.executeUpdate();

        // ResultSet r1 = st.executeQuery();
        System.out.println("offer successfully deleted");
        System.out.println(row);
    }

    public static void removeFromLot(int car_id) throws SQLException {
        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("delete from dealershiplot where car_id = ? ");
        st.setInt(1, car_id);
        int r1 = st.executeUpdate();
        System.out.println("Car successfully removed from lot");

    }

    public void getAllUsers() throws SQLException {
        try {
           //
            // PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("select get_all_users() from dealershipuser");
            CallableStatement cst = ConnectionUtil.getConnection().prepareCall("{ call get_all_users()}");
            ResultSet rs = cst.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnNumber =md.getColumnCount();


           while(rs.next()) {
               for (int i = 1; i <= columnNumber; i++) {
                   String colName = md.getColumnName(i);
                   System.out.print(colName+ " : "+ rs.getString(i) + " | ");
                   ;
               }
               System.out.println();
           }


            }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void moveToLot(int car_id,String username) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("insert into dealershipusercars (make,model,yearmade,mileage,price,car_condition,car_id,username)" +
                "select make,model,yearmade,mileage,price,car_condition,car_id,? from dealershiplot where car_id = ? ");


        st.setString(1,username);
        st.setInt(2, car_id);

        st.executeUpdate();

        System.out.println("Car successfully moved to customer account");
        empDAO.removeFromLot(car_id);


    }
    public void makeEmp(int id,String username,String password) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("insert into dealershipemp (?,?,?)");

        st.setInt(1,id);
        st.setString(2,username);
        st.setString(3, password);

        st.executeUpdate();

        System.out.println("Employee successfully registered");
    }


}


