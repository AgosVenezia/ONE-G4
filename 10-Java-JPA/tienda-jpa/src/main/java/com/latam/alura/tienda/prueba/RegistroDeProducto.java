package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.CategoriaDao;
//import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		/*Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Teléfono usado");
		celular.setPrecio(new BigDecimal("1000"));

		// EntityManager es la interfase encargada de realizar todas las operaciones cada vez que nosotros queramos guardar o seleccionar algún elemento de la base de datos.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		EntityManager em = factory.createEntityManager();
		// Fueron creadas dos clases, EntityManagerFactory y createEntityManagerFactory que realiza las operaciones por nosotros. Ahora, a partir del entityManager se puede comenzar a realizar la primera persistencia, que me va a permitir guardar el valor de este producto en la base de datos para persistir. El valor de la entidad es celular.
		
		ProductoDao productoDao = new ProductoDao(em);

		em.getTransaction().begin();
		//em.persist(celular);
		productoDao.guardar(celular);
		em.getTransaction().commit();
		em.close();
		// Nosotros vamos a llamar el EntityManager, vamos a obtener las transacciones y vamos a indicarle que las operaciones van a comenzar con el método begin. Ya con esto, nosotros realizamos nuestra persistencia. Vamos a obtener la transacción, getTransaction() y vamos a realizar un commit. Entonces, ese commit lo que hace es enviar los valores que fueron configurados para esta instancia los envía para la base datos. Por último vamos a cerrar.
		// ¿Cuándo debemos iniciar y commitar una transacción al persistir una unidad? Al realizar operaciones de escrita en la base de datos, como insert, update y delete. Operaciones de escrita exigen el uso de transacciones.*/

		/*Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Samsung","Teléfono usado", new BigDecimal("1000"), celulares);

		EntityManager em = JPAUtils.getEntityManager();

		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		// Se mantiene la conexión antes de los DAO para poder evitar la duplicación de código.
		em.getTransaction().begin();

		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);

		em.getTransaction().commit();
		em.close();*/

		Categoria celulares = new Categoria("CELULARES");

		EntityManager em = JPAUtils.getEntityManager();

		em.getTransaction().begin();

		em.persist(celulares); // Persistencia de valores

		celulares.setNombre("LIBROS");

		/*em.getTransaction().commit(); // El método commit sincroniza los datos con la base de datos de forma definitiva.
		em.close(); // Todo lo que ocurre luego de haber realizado la persistencia, JPA lo va a estar observando.*/

		em.flush(); // El método flush sincroniza los datos con la base de datos y permite realizar un roll back en caso de errores.
		em.clear();

		celulares.setNombre("SOFTWARES");

		/*
		Entonces a partir de este momento si yo hago algo una alteración dentro de la entidad categoría JPA va a estar atento de esas alteraciones y va a realizar modificaciones en la base de datos. Por ejemplo, se puede tomar la entidad celulares, voy a configurar el nombre y ahora no va a ser celulares, sino que va a ser “LIBROS”. Yo voy a modificar esa categoría, que yo estoy instanciando aquí inicialmente, voy a realizar la persistencia. Ahora esa entidad va a estar en un estado Managed. Quiere decir que va a ser considerada para ser guardada en la base de datos. Voy a modificar el nombre de celulares a libro y voy a hacer el commit. Podría utilizar el método flush, que sincroniza los valores con la base de datos. Cuando se encuentre con el estado Managed, él va a considerar esa entidad para ser modificada o ser observada y prestar atención de todos los cambios que se han realizado dentro del estado Managed. Una vez que yo realizo el commit y el close o que hay algún clear, esa entidad va a estar en un estado detached. Entonces si yo hago alguna modificación, luego de haber realizado el close, por ejemplo celulares y modifico el nombre, ahora va a ser “SOFTWARE”. Al nosotros realizar una modificación de esa entidad que fue persistida y por lo tanto se encuentra con el estado Managed, él va a realizar un update dentro de los registros. Luego de que nosotros confirmamos esa operación, esa transacción y cerramos la conexión con el método close del EntityManager, si nosotros nuevamente modificamos la entidad “CELULARES”, vamos a modificar el parámetro, el atributo nombre, esa última modificación no debería ser considerada dentro de los registros.
		*/

		/*registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
	    ProductoDao productoDao = new ProductoDao(em);
	    Producto producto = productoDao.consultaPorId(1l);
	    System.out.println(producto.getNombre());
	    
	    BigDecimal precio = productoDao.consultarPrecioPorNombreDeProducto("Xiaomi Redmi");
	    System.out.println(precio);*/

	}

	/*private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");

		Producto celular = new Producto("Xiaomi Redmi", "Muy bueno", new BigDecimal("800"), celulares);

	    EntityManager em = JPAUtils.getEntityManager();
	    ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        
	    em.getTransaction().begin();
	    
	    categoriaDao.guardar(celulares);
	    productoDao.guardar(celular);	
	    
	    em.getTransaction().commit();
	    em.close();
	}*/

}