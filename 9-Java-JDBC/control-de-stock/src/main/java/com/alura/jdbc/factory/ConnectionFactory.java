package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import javax.sql.DataSource;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

// Para simplificar y encapsular la creación de la conexión debemos utilizar una clase ConnectionFactory. Esta clase sigue el estándar de creación Factory Method, que encapsula la creación de un objeto.
public class ConnectionFactory {
    
    //private DataSource dataSource;
    
    //public ConnectionFactory() {
        //var comboPooledDataSource = new ComboPooledDataSource();
        //comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
        //comboPooledDataSource.setUser("root");
        //comboPooledDataSource.setPassword("codoacodo");
        //comboPooledDataSource.setMaxPoolSize(10);
        
        //this.dataSource = comboPooledDataSource;
    //}

    public Connection recuperaConexion() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
                "root",
                "codoacodo");
    }
    
    //public Connection recuperaConexion() {
        //try {
            //return this.dataSource.getConnection();
        //} catch (SQLException e) {
            //throw new RuntimeException(e);
        //}
    //}

}

// Patrón de diseño llamado factory method. El factory method tiene como objetivo encapsular el código de creación de un objeto específico, centralizando la lógica en un solo punto. La clase crea conexión, es una fábrica de conexiones. Entonces, siempre que la llamamos es porque queremos crear una conexión.