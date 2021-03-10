package com.dealership.db;

import com.dealership.config.ConnectionUtil;
import com.dealership.model.Car;
import com.dealership.util.dealershipCollection;

import java.sql.*;

import static com.dealership.config.ConnectionUtil.getConnection;


public class carDAO implements GenericDAO<Car>{
//    UserDAO uj = new UserDAO();
    @Override
    public void save(Car c) {
            try {
                String sql = "insert into dealershiplot values ('" +
                        c.getMake() + "', '" + c.getModel() + "', '" +
                        c.getYearMade() + "', '" + c.getMileage() + "', '" + c.getPrice() + "', '" + c.getCar_condition() + "' ,'"
                        + Math.round(Math.random() * 100) + "') returning car_id;";
                Statement st = ConnectionUtil.getConnection().createStatement();
                st.execute(sql);

                ResultSet retCarID = st.getResultSet();
                retCarID.next();
                int carret_id = retCarID.getInt(1);
                System.out.println(carret_id);
                System.out.println("The car_id is " + carret_id);




            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    @Override
    public Car getById(Car id) {
        return null;
    }

    @Override
    public dealershipCollection getAll() {
        try {
            Statement st = ConnectionUtil.getConnection().createStatement();
            String sql = ("select * from dealershiplot;");
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columnsNumber = md.getColumnCount();

            while (rs.next()) {
                for(int i = 1; i < columnsNumber; i++){
                    String colName = md.getColumnName(i);
                    System.out.print(colName + ": " + rs.getString(i) + " ");
                System.out.println();
            }
        }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(Car id) {
        return false;
    }

    @Override
    public boolean update(Car car) {
        return false;
    }

    @Override
    public int updateAll(dealershipCollection collection) {
        return 0;
    }



    public String getMake(String make) throws SQLException {
        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("select make from dealershiplotoffers where make = ? ");
        st.setString(1, make);
        ResultSet r1 = st.executeQuery();
        while(r1.next()) {

            System.out.print("make of the car: "+r1.getString("make"));
            return r1.getString("make");
        }
        System.out.println("offer successfully deleted");


        return null;
    }

    public int getcarID(String username) throws SQLException {
        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("select car_id from dealershipusercars where username = ? ");
        st.setString(1, username);
        ResultSet r1 = st.executeQuery();
        while(r1.next()) {

            System.out.print("Car ID is: "+r1.getInt("car_id"));
            return r1.getInt("car_id");
        }



        return 0;
    }
    public int getcarprice(String username) throws SQLException {
        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("select price from dealershipusercars where username = ? ");
        st.setString(1, username);
        ResultSet r1 = st.executeQuery();
        while(r1.next()) {

            System.out.print("Car price is:  $" +r1.getInt("price"));
            System.out.println();
            return r1.getInt("price");
        }


        return 0;
    }
    public int upprice(String username) throws SQLException {
        PreparedStatement st = ConnectionUtil.getConnection().prepareStatement("select amountpaid,carprice,carprice-amountpaid as upprice from payments where username = ? ");
        st.setString(1, username);
        ResultSet r1 = st.executeQuery();
        while(r1.next()) {

            System.out.print("Updated price is:  $" +r1.getInt("upprice"));
            System.out.println();
            return r1.getInt("upprice");
        }


        return 0;
    }



}
