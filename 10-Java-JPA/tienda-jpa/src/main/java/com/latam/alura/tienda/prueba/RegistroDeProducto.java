package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import com.latam.alura.tienda.dao.CategoriaDao;
//import com.latam.alura.tienda.dao.ProductoDao;
//import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
//import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Teléfono usado");
		celular.setPrecio(new BigDecimal("1000"));

		// EntityManager es la interfase encargada de realizar todas las operaciones cada vez que nosotros queramos guardar o seleccionar algún elemento de la base de datos.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		EntityManager em = factory.createEntityManager();
		// Fueron creadas dos clases, EntityManagerFactory y createEntityManagerFactory que realiza las operaciones por nosotros. Ahora, a partir del entityManager se puede comenzar a realizar la primera persistencia, que me va a permitir guardar el valor de este producto en la base de datos para persistir. El valor de la entidad es celular.
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
		// Nosotros vamos a llamar el EntityManager, vamos a obtener las transacciones y vamos a indicarle que las operaciones van a comenzar con el método begin. Ya con esto, nosotros realizamos nuestra persistencia. Vamos a obtener la transacción, getTransaction() y vamos a realizar un commit. Entonces, ese commit lo que hace es enviar los valores que fueron configurados para esta instancia los envía para la base datos. Por último vamos a cerrar.
		// ¿Cuándo debemos iniciar y commitar una transacción al persistir una unidad? Al realizar operaciones de escrita en la base de datos, como insert, update y delete. Operaciones de escrita exigen el uso de transacciones.

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