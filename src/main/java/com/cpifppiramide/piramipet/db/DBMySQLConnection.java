package com.cpifppiramide.piramipet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySQLConnection {

    private final static String
            host = "bd-sergio.cbcah7kmtstt.us-east-1.rds.amazonaws.com",
            db = "piramipet",
            user = "admin",
            passsword = "SaltoRoldan";

    private static Connection connection;

    public static Connection getConnection() {
        if(connection == null){
            try {
                connection= DriverManager.getConnection(
                        "jdbc:mysql://"+host+":3306/"+db,user,passsword);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
