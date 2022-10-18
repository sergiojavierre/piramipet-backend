package com.cpifppiramide.piramipet.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMYSQL {

    private static Connection conexion;

    public static Connection getInstance() {

        if(conexion == null){
            try{
                String url = "jdbc:mysql://bd-sergio.cbcah7kmtstt.us-east-1.rds.amazonaws.com:3306/piramipet_Angel";
                conexion = DriverManager.getConnection(url,"admin","SaltoRoldan");
                return conexion;
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return conexion;
    }
}
