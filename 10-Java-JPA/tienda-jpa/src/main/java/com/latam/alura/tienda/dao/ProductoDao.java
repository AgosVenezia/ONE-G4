package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

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
		String jpql="SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}

}