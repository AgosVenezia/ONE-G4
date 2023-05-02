package com.alura.jdbc.pruebas;

//import java.sql.Connection;
import java.sql.SQLException;

import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaPoolDeConexiones {

    public static void main(String[] args) throws SQLException {
        //ConnectionFactory connectionFactory = new ConnectionFactory();
        ConnectionFactory factory = new ConnectionFactory();
        
        for (int i = 0; i < 20; i++) {
            //Connection conexion = connectionFactory.recuperaConexion();
            factory.recuperaConexion();
            
            //System.out.println("Abriendo la conexión de número " + (i + 1));
            System.out.println("Abriendo conexión #" + i);
        }
    }
    
}

/*
El máximo de conexiones que podemos mantener abiertas acá va a ser de 10 conexiones. Nosotros solicitamos 20 conexiones, pero fueron abiertas las 10 conexiones del pool. Está bien, el loop está parado, esperando que una conexión se quede disponible para utilizarla. Si llegamos al tope de conexiones de pool, el próximo cliente va a tener que esperar un ratito hasta que el procesamiento de un cliente termine y él va a poder utilizar la próxima conexión libre. De esta forma, nosotros limitamos la apertura descontrolada de conexiones y no saturamos la base de datos. 
*/