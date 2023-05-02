package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

/*
Nosotros podríamos crear una clase que mantenga todos lo que es necesario, como la conexión de la base de datos para persistir el producto y solamente tengamos que basar el objeto como parámetro. Sería una clase más específica para realizar operaciones en la tabla de productos. La idea de esta clase es dar todo el acceso a las operaciones de base de datos para la entidad de producto. Entonces esta clase lo que está haciendo es tratar todas las operaciones en la tabla de producto. Entonces su finalidad es acceder a los datos de nuestro objeto. Si nosotros queremos guardar un nuevo producto, la aplicación va a crear un objeto acá, lo va a enviar para la clase ProductoDAO, que va a ser la operación de insert en el MySQL en la base de datos. Las clases del tipo DAO, Data Access Object, trabajan con las operaciones de acceso a los datos de una entidad.

Para cada tabla del modelo tenemos una clase de dominio: para la tabla de producto tenemos una clase Producto asociada; los objetos del tipo Producto representan un registro de la tabla. Para acceder a la tabla vamos a utilizar el estándar llamado Data Access Object (DAO): para cada clase de dominio hay un DAO asociado. Por ejemplo, la clase Producto posee la clase ProductoDAO. Todos los métodos JDBC relacionados al producto deben estar encapsulados en ProductoDAO.
*/
public class ProductoDAO {

    private Connection con;

    public ProductoDAO(Connection con) {
        this.con = con;
    }
    
    public void guardar(Producto producto) {
        try {
            //con.setAutoCommit(false);

            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO PRODUCTO "
                        + "(nombre, descripcion, cantidad, categoria_id)"
                        + " VALUES (?, ?, ?, ?)", 
                        Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, producto.getNombre());
                statement.setString(2, producto.getDescripcion());
                statement.setInt(3, producto.getCantidad());
                statement.setInt(4, producto.getCategoriaId());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();

                //ejecutaRegistro(producto, statement);

                //con.commit();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        producto.setId(resultSet.getInt(1));
                        
                        System.out.println(String.format("Fue insertado el producto: %s", producto));
                    }
                }
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            //System.out.println("ROLLBACK de la transacción");
            throw new RuntimeException(e);
            //con.rollback();
        }
    }

    /*private void ejecutaRegistro(Producto producto, PreparedStatement statement) throws SQLException {
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setInt(3, producto.getCantidad());
        //statement.setInt(4, producto.getCategoriaId());
        
        statement.execute();
        
    }*/

    public List<Producto> listar() {
        List<Producto> resultado = new ArrayList<>();

        try {
            var querySelect = "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO";
            System.out.println(querySelect);

            final PreparedStatement statement = con
                    //.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO WHERE CATEGORIA_ID = ?");
                    .prepareStatement(querySelect);

            try (statement) {
                //statement.setInt(1, categoriaId);
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Producto(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION"),
                                resultSet.getInt("CANTIDAD")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public int eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE PRODUCTO SET "
                    + " NOMBRE = ?, "
                    + " DESCRIPCION = ?,"
                    + " CANTIDAD = ?"
                    + " WHERE ID = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, descripcion);
                statement.setInt(3, cantidad);
                statement.setInt(4, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listar(Categoria categoria) {
        List<Producto> resultado = new ArrayList<>();

        try {
            String sql = "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD "
            + " FROM PRODUCTO WHERE CATEGORIA_ID = ?";
            System.out.println(sql);
            
            final PreparedStatement statement = con.prepareStatement(
                    sql);
    
            try (statement) {
                statement.setInt(1, categoria.getId());
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Producto(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION"),
                                resultSet.getInt("CANTIDAD")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
