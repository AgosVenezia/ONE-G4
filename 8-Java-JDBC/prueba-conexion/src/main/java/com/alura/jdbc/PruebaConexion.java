package com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimezone=UTC", 
            "root",
            "codoacodo");

        System.out.println("Cerrando la conexión");
        
        con.close();
    }
}
