package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

	public List<Producto> consultarPorParametros(String nombre, BigDecimal precio, LocalDate fecha) {
		/*String jpql="SELECT P FROM Producto P WHERE 1=1 "
			//+ "P.nombre=:nombre "
			//+ "AND P.precio=:precio "
			+ "AND P.fechaDeRegistro=:fecha";*/
		StringBuilder jpql = new StringBuilder("SELECT p FROM Producto p WHERE 1=1 ");
			
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