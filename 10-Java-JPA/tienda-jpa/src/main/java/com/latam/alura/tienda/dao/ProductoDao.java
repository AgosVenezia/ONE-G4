package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
//import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

//import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;

// El DAO tiene la responsabilidad de dar acceso a la base de datos, para guardar, actualizar, eliminar o para consulta de una entidad.
public class ProductoDao {
	
	private EntityManager em;

	public ProductoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	public void actualizar(Producto producto) {
		this.em.merge(producto);
	}
	
	public void remover(Producto producto) {
		producto=this.em.merge(producto);
		this.em.remove(producto);
	}
	
	public Producto consultaPorId(Long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos(){
		String jqpl= "SELECT P FROM Producto AS P";
		return em.createQuery(jqpl,Producto.class).getResultList();
	}

	// La consulta la vamos a realizar a través del lenguaje JPQL, que es un lenguaje de consulta similar a SQL, pero utilizado para Java, cuyo significado es Java Persistence Query Language. Lo primero que tenemos que hacer es establecer nuestra query o nuestra consulta. Esa consulta va a ser un string, que lo vamos a llamar en este caso JPQL, y string va ser un “SELECT”. Colocamos la entidad que aquí sería producto, un alias que sería AS e indicamos que lo vamos a representar esa entidad con la letra P. En JPQL nosotros no utilizamos un asterisco, sino que tenemos que utilizar un token. Ese token va a ser la letra P que estamos pasando como alias.
	
	public List<Producto> consultaPorNombre(String nombre){
		String jpql =" SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
		//String jpql =" SELECT P FROM Producto AS P WHERE P.nombre=:nombre AND P.descripcion=:desc";
		//String jpql =" SELECT P FROM Producto AS P WHERE P.nombre=:1 AND P.descripcion=:2";
		//return em.createQuery(jpql,Producto.class).setParameter(1, nombre).getResultList();
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
		//                                                      posición  valor
	}
	
	public List<Producto> consultaPorNombreDeCategoria(String nombre){
		String jpql="SELECT p FROM Producto AS p WHERE p.categoria.nombre=:nombre";
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	 
	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
		//String jpql="SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
		//return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
		return em.createNamedQuery("Producto.consultaDePrecio", BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}

	// Consultas por parámetro a través de condiciones para realizar consultas de múltiples parámetros. Alguno de esos parámetros puede o no ser obligatorio.
	// Más de un parámetro de filtrado
	// Cuando queremos realizar consultas con múltiples parámetros nos encontramos con el problemas que todos ellos deben ser obligatorios, de lo contrario consultaria elementos nulos en tabla. Para evitar este error tenemos que usar parámetros dinámicos que nos permiten realizar consultas con múltiples parámetros y en caso de que alguno de estos sea nulo la consulta simplemente ignorará este parámetro y realizará la consulta con los parámetros existentes. Y en caso de no existir ningún parámetro, realizará la consulta de todos los elementos en la tabla.
	public List<Producto> consultarPorParametros(String nombre, BigDecimal precio, LocalDate fecha) {
		/*String jpql="SELECT P FROM Producto P WHERE 1=1 " // 1=1 es true y continúa con la consulta
			//+ "P.nombre=:nombre "
			//+ "AND P.precio=:precio "
			+ "AND P.fechaDeRegistro=:fecha";*/ // Nombre igual que parámetro.
		StringBuilder jpql = new StringBuilder("SELECT p FROM Producto p WHERE 1=1 ");
		// El String es inmutable, con el Builder es mutable, lo podemos modificar.
			
			if (nombre != null && !nombre.trim().isEmpty()) {
				jpql.append("AND p.nombre=:nombre ");
			}
			if (precio != null && !precio.equals(new BigDecimal(0))) {
				jpql.append("AND p.precio=:precio ");
			}
			if (fecha != null) {
				jpql.append("AND p.fechaDeRegistro=:fecha ");
			}
			TypedQuery<Producto> query = em.createQuery(jpql.toString(), Producto.class);
			if (nombre != null && !nombre.trim().isEmpty()) {
				query.setParameter("nombre", nombre);
			}
			if (precio != null && !precio.equals(new BigDecimal(0))) {
				query.setParameter("precio", precio);
			}
			if (fecha != null) {
				query.setParameter("fechaDeRegistro", fecha);
			}

			return query.getResultList();
		}

	// Adicionalmente podemos realizar la misma consulta dinámica utilizando la API de Criteria que es un poco más compleja y recomendamos documentarse sobre ella pero simplifica la cantidad de condiciones en nuestra aplicación.
	// API de criterio: nos permite construir nuestra consulta a través del método
	// ¿Cuál de las siguientes es una desventaja de Criteria API? Código más complejo de entender y mantener.
	// APICrieria no utiliza lenguaje de jpql ya que jpa se encarga de realizar las consultas por nosotros de una forma orientada a objetos.
	public List<Producto> consultarPorParametrosConAPICriteria(String nombre, BigDecimal precio, LocalDate fecha) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Producto> query = builder.createQuery(Producto.class);
		Root<Producto> from = query.from(Producto.class);

		Predicate filtro = builder.and();
		if (nombre != null && !nombre.trim().isEmpty()) {
			filtro = builder.and(filtro, builder.equal(from.get("nombre"), nombre));
		}
		if (precio != null && !precio.equals(new BigDecimal(0))) {
			filtro = builder.and(filtro, builder.equal(from.get("precio"), precio));
		}
		if (fecha!= null) {
			filtro = builder.and(filtro, builder.equal(from.get("fechaDeRegistro"), fecha));
		}
		
		query = query.where(filtro);
		return em.createQuery(query).getResultList();
	}
}