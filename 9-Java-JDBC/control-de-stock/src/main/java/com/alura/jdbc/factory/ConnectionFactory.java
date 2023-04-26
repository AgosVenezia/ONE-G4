package com.alura.jdbc.factory;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

// Para simplificar y encapsular la creación de la conexión debemos utilizar una clase ConnectionFactory. Esta clase sigue el estándar de creación Factory Method, que encapsula la creación de un objeto.

/*
Tenemos un pool de conexiones que va a comunicarse con el JDBC para mantener una cantidad mínima y una cantidad máxima de conexiones abiertas en la aplicación para que pueda atender a las requisiciones sin que tenga una cola muy grande y que no ahogue la aplicación.

Tal como los drivers de base de datos, también hay varias opciones para drivers que manejen un pool de conexiones. El C3P0 es una de las opciones más conocidas en el mercado. Para utilizarlo bien vamos a aprovechar las ventajas del JDBC para utilizar una nueva interfaz llamada datasource. Esta interfaz va abstraer la implementación del pool de conexiones para nosotros y con esta nueva estructura, la connectionFactory que tenemos no va más a tener la responsabilidad de crear una conexión para nosotros.

Utilizar el pool de conexiones es una buena práctica. El pool de conexiones controla la cantidad de conexiones abiertas entre la aplicación y la base de datos.
Es normal que haya un mínimo y un máximo de conexiones.
De la misma forma que hay, en JDBC, una interfaz para representar la conexión (java.sql.Connection), también hay una interfaz que representa el pool de conexiones (javax.sql.DataSource). C3P0 es una implementación Java de un pool de conexiones.
*/

public class ConnectionFactory {
    
    private DataSource dataSource;
    
    public ConnectionFactory() {
        var comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("codoacodo");
        comboPooledDataSource.setMaxPoolSize(10);
        
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperaConexion() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return this.dataSource.getConnection();

        /*return DriverManager.getConnection(
                "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
                "root",
                "codoacodo");*/
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