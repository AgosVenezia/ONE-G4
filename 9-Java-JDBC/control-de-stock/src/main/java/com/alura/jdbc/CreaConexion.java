package com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreaConexion {
    
    public Connection recuperarConexion() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost/control_de_stock?useTimezone=true&serverTimezone=UTC", 
            "root", 
            "codoacodo");
    }
}

// Connection, Statement y ResultSet son algunas de las interfaces del paquete java.sql.