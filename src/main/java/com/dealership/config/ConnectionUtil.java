package com.dealership.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static ConnectionUtil instance;

    private ConnectionUtil(){}

    public static ConnectionUtil getInstance(){
        if(instance == null){
            instance = new ConnectionUtil();
        }
        return instance;
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://database-1.cm9wmuctsjy6.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=public",
                "noeltest",
                "pass");
    }
}
