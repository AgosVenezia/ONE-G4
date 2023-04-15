package com.alura.jdbc.pruebas;

import java.sql.Connection;
//import java.sql.SQLException;

//import com.alura.jdbc.factory.ConnectionFactory;

/*
public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC", 
            "root", 
            "codoacodo");

        System.out.println("Cerrando la conexión");

        con.close();
    }

}
*/

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperaConexion();

        System.out.println("Cerrando la conexión");

        con.close();
    }

}
