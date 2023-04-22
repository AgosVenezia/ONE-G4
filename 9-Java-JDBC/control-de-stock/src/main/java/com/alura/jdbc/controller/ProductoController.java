package com.alura.jdbc.controller;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

//import java.sql.DriverManager;
/*
Para acceder a una base de datos necesitamos del driver de conexión.
JDBC significa Java DataBase Connectivity. El JDBC define una capa de abstracción entre la aplicación y el driver de la base de datos. Esta capa es compuesta de interfaces que el driver implementa.
*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alura.jdbc.dao.ProductoDAO;
//import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;
//import com.alura.jdbc.modelo.Categoria;
//import com.alura.jdbc.modelo.Producto;
import com.alura.jdbc.modelo.Producto;

//import com.alura.jdbc.CreaConexion;

public class ProductoController {

    private ProductoDAO productoDAO;
    
    public ProductoController() {
        //var factory = new ConnectionFactory();
        //this.productoDAO = new ProductoDAO(factory.recuperaConexion());
        this.productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
    }

    public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        final Connection con = factory.recuperaConexion();

/*
El Try With Resources nos permite declarar recursos que van a ser utilizados en un bloque de try catch con la certeza de que estos recursos van a ser cerrados o finalizados automáticamente después de la ejecución del bloque. Como estas interfaces extienden la interfaz AutoCloseable, el try-with-resources ejecuta el comando close implícitamente. Un requisito para eso es que estos recursos deben implementar la interfaz autoCloseable. Esos bloques aún pueden tener los bloques de catch y final para trabajar en algún manejo de excepción como el rollback que estamos haciendo en nuestro método de registro de productos.

Para garantizar el cierre de los recursos abiertos en el código, Java provee un recurso llamado try-with-resources para ayudarnos. Para utilizar este recurso es necesario que la clase utilizada (como la Connection) implemente la interfaz Autocloseable.
*/
        try (con) {
            final PreparedStatement statement = con.prepareStatement("UPDATE PRODUCTO SET "
                    + " NOMBRE = ? "
                    + ", DESCRIPCION = ? "
                    + ", CANTIDAD = ? "
                    + " WHERE ID = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, descripcion);
                statement.setInt(3, cantidad);
                statement.setInt(4, id);

                statement.execute();
                
                /*Statement statement = con.createStatement();
                
                statement.execute("UPDATE PRODUCTO SET "
                        + " NOMBRE = '" + nombre + "'"
                        + ", DESCRIPCION = '" + descripcion + "'"
                        + ", CANTIDAD = " + cantidad
                        + " WHERE ID = " + id);*/
                
                int updateCount = statement.getUpdateCount();
                
                con.close();
                
                return updateCount;
        }
    }
}
    
    //public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
        //return productoDao.modificar(nombre, descripcion, cantidad, id);
    //}

    public int eliminar(Integer id) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        final Connection con = factory.recuperaConexion();

        try (con) {
        
            final PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);

                statement.execute();
                //Statement statement = con.createStatement();
                
                // El método execute devuelve true cuando el resultado devuelve un java.sql.ResultSet (resultado de un SELECT) y false cuando el resultado no devuelve contenido (resultado de un DELETE, UPDATE o DELETE).
                //statement.execute("DELETE FROM PRODUCTO WHERE ID = " + id);
                
                int updateCount = statement.getUpdateCount();
                // Para saber si algo fue realmente eliminado hay un método que es el statement.getUpdateCount. Esto nos va a devolver un Int que voy a asignarlo a una variable que es un UpdateCount, y este número del tipo Int nos devuelve cuántas filas fueron modificadas luego que ejecutamos el comando de SQL en el statement
                
                //con.close();
        
                return updateCount;
            }
        }
    }
    
    //public int eliminar(Integer id) {
        //return productoDao.eliminar(id);
    //}

    /*public List<Map<String, String>> listar() throws SQLException {
        //Connection con = DriverManager.getConnection(
            //"jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC", 
            //"root", 
            //"codoacodo");
        // Para abrir una conexión con la base de datos debemos utilizar el método getConnection de la clase DriverManager. El método getConnection recibe tres parámetros. Son ellos la URL de conexión JDBC, el usuario y la contraseña.

        Connection con = new CreaConexion().recuperaConexion();

        Statement statement = con.createStatement();

        statement.execute("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

        ResultSet resultSet = statement.getResultSet();

        List<Map<String, String>> resultado = new ArrayList<>();

        while (resultSet.next()) {
            Map<String, String> fila = new HashMap<>();
            fila.put("ID", String.valueOf(resultSet.getInt("ID")));
            fila.put("NOMBRE", resultSet.getString("NOMBRE"));
            fila.put("DESCRIPCION", resultSet.getString("DESCRIPCION"));
            fila.put("CANTIDAD", String.valueOf(resultSet.getInt("CANTIDAD")));

            resultado.add(fila);
        }
        
        con.close();

        return resultado;
    }*/
    
    //public List<Map<String, String>> listar() throws SQLException {
    public List<Producto> listar() {
        return productoDAO.listar();
        //productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
        
        //List<Map<String, String>> resultado = new ArrayList<>();

        //ConnectionFactory factory = new ConnectionFactory();
        //final Connection con = factory.recuperaConexion();

        //try(con) {
        
            //final PreparedStatement statement = con.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");
            
            //try (statement) {
                //statement.execute();
        
                //Statement statement = con.createStatement();
                //statement.execute("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

                // Para tomar el resultado del statement tenemos que ejecutar otro comando del statement, en el propio statement.getResultSet. Este método nos devuelve un objeto del tipo ResultSet.
                //final ResultSet resultSet = statement.getResultSet();

                //List<Map<String, String>> resultado = new ArrayList<>();

                /*try(resultSet) {
                    while (resultSet.next()) {
                        Map<String, String> fila = new HashMap<>();
                        fila.put("ID", String.valueOf(resultSet.getInt("ID")));
                        fila.put("NOMBRE", resultSet.getString("NOMBRE"));
                        fila.put("DESCRIPCION", resultSet.getString("DESCRIPCION"));
                        fila.put("CANTIDAD", String.valueOf(resultSet.getInt("CANTIDAD")));

                        resultado.add(fila);
                    }
                }
                    //con.close();
            }
                    return resultado;
        }*/
    }
    
    //public List<Producto> listar() {
        //return productoDao.listar();
    //}

    //public void guardar(Map<String, String> producto) throws SQLException {
    public void guardar(Producto producto) {
        /*String nombre = producto.get("NOMBRE");
        String descripcion = producto.get("DESCRIPCION");
        Integer cantidad = Integer.valueOf(producto.get("CANTIDAD"));
        Integer maximoCantidad = 50;*/

        /*var nombre = producto.getNombre();
        var descripcion = producto.getDescripcion();
        var cantidad = producto.getCantidad();
        final var maximoCantidad = 50;*/
        
        //Connection con = new ConnectionFactory().recuperaConexion();        
        //ConnectionFactory factory = new ConnectionFactory();
        //final Connection con = factory.recuperaConexion();
        //con.setAutoCommit(false);
        /*
        Para cada ejecución del Insert la aplicación está abriendo una transacción para guardar los datos, devuelve el resultSet y cierra la transacción. El tema es que cuando es lanzada una excepción, parte de la información es guardada y la otra parte es perdida. ¿Cuál es el estándar de JDBC (del driver) para manejar transacciones de base de datos?: Auto-Commit. Este es el estándar, que puede ser modificado por el método setAutoCommit, de la interfaz Connection.
        */

        //Statement statement = con.createStatement();
        /*statement.execute(
            "INSERT INTO PRODUCTO (nombre, descripcion, cantidad)"
                + " VALUES ('" + producto.get("NOMBRE") + "', '"
                + producto.get("DESCRIPCION") + "', '" 
                + producto.get("CANTIDAD") + "')",
                Statement.RETURN_GENERATED_KEYS);
        // Entonces en el VALUES tenemos la comilla simple para señalar que es un string adentro del string de SQL. Y las comillas simples en SQL señalan un string, y acá en Java son las comillas dobles las que señalan un string.*/

        /*String sqlInsert = "INSERT INTO PRODUCTO (nombre, descripcion, cantidad)"
                + " VALUES ('" + producto.get("NOMBRE") + "', '"
                + producto.get("DESCRIPCION") + "', '" 
                + producto.get("CANTIDAD") + "')";
        
        System.out.println(sqlInsert);*/

/*
Cuando ejecutamos una query SQL como Statement tenemos un riesgo de seguridad llamado SQL Injection. SQL Injection es el hecho de enviar comandos SQL como parámetro de las solicitudes en una aplicación. Para evitar el fallo por SQL Injection debemos utilizar la interfaz PreparedStatement. Diferente del Statement, el PreparedStatement trata los parámetros del comando SQL para que caracteres y comandos especiales sean tratados como strings.
*/
        
        // Statement se utiliza para ejecutar consultas SQL basadas en cadenas. PreparedStatement mantiene la query compilada en la base de datos, de forma parametrizada. Así el usuario puede ejecutar la misma consulta diversas veces con parámetros distintos.
        
        //try(con) {
            //con.setAutoCommit(false);
        
            //final PreparedStatement statement = con.prepareStatement("INSERT INTO PRODUCTO "
                //+ "(nombre, descripcion, cantidad)" 
                //+ " VALUES (?, ?, ?)",
                //Statement.RETURN_GENERATED_KEYS);

            /*try(statement) {
                do {
                    int cantidadParaGuardar = Math.min (cantidad, maximoCantidad);

                    //ejecutaRegistro(nombre, descripcion, cantidadParaGuardar, statement);
                    ejecutaRegistro(producto, statement);

                    //cantidad -= maximoCantidad;
                } while (cantidad > 0);

            //statement.setString(1, nombre);
            //statement.setString(2, descripcion);
            //statement.setInt(3, cantidad);

            //statement.execute();

            //ejecutaRegistro(nombre, descripcion, cantidad, statement);

            /*ResultSet resultSet = statement.getGeneratedKeys();
        
            // El resultado nos provee una forma de ir hasta el próximo elemento del resultado, hasta que lleguemos al final. El recurso que nos provee resultSet es un método llamado acá resultSet.next().
            while(resultSet.next()) {
                System.out.println(String.format(
                    "Fue insertado el producto de ID: %d",
                    resultSet.getInt(1)));
            }*/

            //try(statement) {
                //ejecutaRegistro(producto, statement);

                //con.commit();
                //System.out.println("COMMIT");
            //}

        //} catch (Exception e) {
            //e.printStackTrace();
            //System.out.println("ROLLBACK de la transacción");
            //con.rollback();
                //System.out.println("ROLLBACK");
        //}

            //statement.close();

            //con.close();
/*
Las bases de datos ofrecen un recurso llamado transacción, que junta muchas operaciones SQL como un conjunto de ejecución. Si el conjunto falla no es aplicada ninguna modificación y ocurre el rollback de la transacción. Todos los comandos del conjunto necesitan funcionar para que la transacción sea finalizada con un commit.
*/
    //ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion()); // SÓLO ESTAS LÍNEAS SON NECESARIAS PARA "PUBLIC GUARDAR"
    //new ProductoDAO(new ConnectionFactory().recuperaConexion());
    productoDAO.guardar(producto);
    }
}

    /*
    Cuando trabajamos con el control manual de una transacción, o sea con el AutoCommit(false); nosotros tenemos que agregar explícitamente el comando de commit en el código. El comando con.commit lo vamos a agregar afuera del bloque de do while. Y va a ser acá con.commit(); para garantizar que todos los comandos del loop hayan sido ejecutados correctamente. O sea, si la ejecución acá tiene un error, él ejecuta registro o cualquier cosa que hay acá dentro del try tiene un error, vamos a caer en el catch, nosotros vamos a hacer un rollback de la transacción, vamos a cerrar la conexión y no hay ningún problema. Nosotros cancelamos la ejecución de estas transacciones.
    */

    /*private void ejecutaRegistro(String nombre, String descripcion, Integer cantidad, PreparedStatement statement) throws SQLException {
        statement.setString(1, nombre);
        statement.setString(2, descripcion);
        statement.setInt(3, cantidad);*/

    //private void ejecutaRegistro(Producto producto, PreparedStatement statement) throws SQLException {

        //statement.setString(1, producto.getNombre());
        //statement.setString(2, producto.getDescripcion());
        //statement.setInt(3, producto.getCantidad());

        /*if (cantidad < 50) {
            throw new RuntimeException("Ocurrió un error");
        }*/

        //statement.execute();

        /*ResultSet resultSet = statement.getGeneratedKeys();

        while (resultSet.next()) {
            System.out.println(String.format(
                "Fue insertado el producto de ID: %d",
                resultSet.getInt(1)));
        }

        resultSet.close();*/

        //final ResultSet resultSet = statement.getGeneratedKeys();

        //try(resultSet) {
            //while (resultSet.next()) {
                //producto.setId(resultSet.getInt(1));
                //System.out.println(String.format(
                    //"Fue insertado el producto %d", producto
                    //resultSet.getInt(1)
                    //));
            //}
        //}
    //}
    
    //public void guardar(Producto producto, Integer categoriaId) {
        //producto.setCategoriaId(categoriaId);
        //productoDao.guardar(producto);
    //}

    //public List<Producto> listar(Categoria categoria) {
        //return productoDao.listar(categoria);
    //}

//}
