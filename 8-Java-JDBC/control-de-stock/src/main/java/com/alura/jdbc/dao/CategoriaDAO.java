package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

public class CategoriaDAO {

    private Connection con;

    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    public List<Categoria> listar() {
        List<Categoria> resultado = new ArrayList<>();

/*
querySelect: como tenemos cuatro categorías acá en el reporte, nosotros fuimos cuatro veces a la base de datos para buscar a sus productos. Ese número crece en n veces, es infinita la cantidad de veces. Y esto impacta directamente en la performance de nuestra aplicación, porque para cada iteración que estamos haciendo estamos abriendo una nueva conexión con la base de datos que tiene su costo. Esta situación es conocida como queries N + 1, que es cuando para ejecutar una cierta funcionalidad, estamos yendo a la base de datos más de lo que es necesario cuando hay la posibilidad de ir una sola vez. ¿Cuál es el problema de la aplicación tener queries N + 1? Porque son utilizadas múltiples queries, aumentando la cantidad de acceso a la base de datos y, por consecuencia, empeorando la performance de la aplicación y del propio sistema de base de datos. Cuando las consultas son sencillas no hay problemas. Pero cuanto más complejidad van teniendo nuestras consultas hay la necesidad de buscar más informaciones de múltiples tablas, aumentando el acceso exponencialmente. Eso impacta gravemente la performance de la aplicación y del sistema de base de datos.
*/
        
        try {
            var querySelect = "SELECT ID, NOMBRE FROM CATEGORIA";
            System.out.println(querySelect);
            
            //String sql = "SELECT ID, NOMBRE FROM CATEGORIA";
            
            //System.out.println(sql);
            
            final PreparedStatement statement = con
                    .prepareStatement(querySelect);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();
                // En lugar de statement.execute, que devuelve un boolean y después hacer un statement.getResultSet para tomar los resultados, vamos a utilizar un acceso directo para ejecutar la query y ya tomar el resultado. Este método que tiene ese acceso directo se llama executeQuery.

                try (resultSet) {
                    while (resultSet.next()) {
                        /*resultado.add(new Categoria(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE")));*/
                        var categoria = new Categoria(resultSet.getInt("ID"), resultSet.getString("NOMBRE"));
                        
                        resultado.add(categoria);
                        
                    }
                };
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

/*
El patrón DAO centraliza las operaciones de acceso a un recurso específico. En nuestro caso, tenemos el recurso de categoría, las tablas de la base de datos, que son la categoría y el producto. Y las clases DAO hacen justamente todo ese manejo de las conexiones de acceso a las fuentes de datos.
*/

    public List<Categoria> listarConProductos() {
        List<Categoria> resultado = new ArrayList<>();

        try {
            var querySelect = "SELECT C.ID, C.NOMBRE, P.ID, P.NOMBRE, P.CANTIDAD "
                    + " FROM CATEGORIA C INNER JOIN PRODUCTO P "
                    + " ON C.ID = P.CATEGORIA_ID";
            /*String sql = "SELECT C.ID, C.NOMBRE, P.ID, P.NOMBRE, P.CANTIDAD "
                    + " FROM CATEGORIA C INNER JOIN PRODUCTO P "
                    + " ON C.ID = P.CATEGORIA_ID";*/

/*
Cuando tenemos una relación entre tables debemos tener cuidado para no crear el problema de queries N + 1. N + 1 quiere decir que, para buscar los datos de una relación, es ejecutada una query y luego una más por cada relación. Este tipo de problema puede generar problemas de performance en la aplicación y en la base de datos. Este tipo de problema puede ser evitado utilizando join en la query SQL.
*/
            
            System.out.println(querySelect);
            //System.out.println(sql);
            
            final PreparedStatement statement = con
                    //.prepareStatement(sql);
                    .prepareStatement(querySelect);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        int categoriaId = resultSet.getInt("C.ID");
                        String categoriaNombre = resultSet.getString("C.NOMBRE");
                        
                        var categoria = resultado
                            .stream()
                            .filter(cat -> cat.getId().equals(categoriaId))
                            .findAny().orElseGet(() -> {
                                Categoria cat = new Categoria(
                                        categoriaId, categoriaNombre);
                                resultado.add(cat);
                                
                                return cat;
                            });

/*
INNER JOIN: este recurso nos posibilita unificar dos tablas que tienen columnas en común y para nuestro caso la tabla producto tiene la columna categoría id, que hace referencia a la columna de id, a la de la tabla categoría. Acá estamos tomando el resultado, que es un list de categoría. Lo estoy transformando en un string y haciendo un filter, o sea, estoy buscando si en este listado ya tenemos una categoría con este id de esta variable, de este loop que estamos haciendo. Si ya existe, o sea, un findAny si encontramos cualquier resultado que tenga esta igualdad de la condición acá del filter, nosotros vamos a asignar este resultado a la variable de categoría. Si no existe nada de eso, o sea, es la primera vez que estamos pasando por esta categoría del id específico, entonces nosotros estamos creando el objeto de la categoría y lo estamos agregando a nuestro listado de resultados.
*/
                        
                        Producto producto = new Producto(
                                resultSet.getInt("P.ID"),
                                resultSet.getString("P.NOMBRE"),
                                resultSet.getInt("P.CANTIDAD"));
                        
                        categoria.agregar(producto);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
