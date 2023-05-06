package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.vo.RelatorioDeVenta;

// CREAR UN DAO PARA CADA ELEMENTO DE LA BASE DE DATOS
public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	
	public void actualizar(Pedido pedido) {
		this.em.merge(pedido);
	}
	
	public void remover(Pedido pedido) {
		pedido=this.em.merge(pedido);
		this.em.remove(pedido);
	}
	
	public Pedido consultaPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos(){
		String jqpl= "SELECT P FROM Pedido AS P";
		return em.createQuery(jqpl,Pedido.class).getResultList();
	}

	/*public List<Pedido> consultaPorNombre(String nombre){
		String jpql =" SELECT P FROM Pedido AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,Pedido.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Pedido> consultaPorNombreDeCategoria(String nombre){
		String jpql="SELECT p FROM Pedido AS p WHERE p.categoria.nombre=:nombre";
		return em.createQuery(jpql,Pedido.class).setParameter("nombre", nombre).getResultList();
	}
	 
	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
		String jpql="SELECT P.precio FROM Pedido AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}*/

	/*
	Funciones de Agregación SQL:
	AVG promedio
	COUNT número de registros
	SUM suma de todos los valores
	MAX valor más alto de un campo
	MIN valor más bajo de un campo
	*/

	public BigDecimal valorTotalVendido() {
		String jpql= "SELECT SUM(p.valorTotal) FROM Pedido p";
		// Nombre de tabla = nombre de la clase
		// Nombre de campo = nombre del atributo
		return em.createQuery(jpql,BigDecimal.class).getSingleResult();
	}

	/*public BigDecimal valorTotalVendido() {
		String jpql= "SELECT MAX(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql,BigDecimal.class).getSingleResult();
	}*/
	
	public Double valorPromedioVendido() {
		String jpql= "SELECT AVG(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql,Double.class).getSingleResult();
	}
	
	// OPCIÓN OBJECT
	public List<Object[]> relatorioDeVentas(){
		String jpql="SELECT producto.nombre, "
				+ "SUM(item.cantidad), " // cantidad y fecha son atributos
				+ "MAX(pedido.fecha) "   // producto es auxiliar/token
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item " // JOIN concatena pedido con items
				+ "JOIN item.producto producto " // concatena con el token
				+ "GROUP BY producto.nombre " // agrupa consulta por nombre
				+ "ORDER BY item.cantidad DESC"; // ordena por cantidad descendente
		return em.createQuery(jpql,Object[].class).getResultList();
	}
	
	// OPCIÓN VO
	public List<RelatorioDeVenta> relatorioDeVentasVO(){
		// new permite utilizar lenguaje Java en consultas SQL
		String jpql="SELECT new com.latam.alura.tienda.vo.RelatorioDeVenta(producto.nombre, "
				+ "SUM(item.cantidad), "
				+ "MAX(pedido.fecha)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.nombre "
				+ "ORDER BY item.cantidad DESC";
		return em.createQuery(jpql,RelatorioDeVenta.class).getResultList();
	}
	
	public Pedido consultarPedidoConCliente(Long id) {
		String jpql="SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id=:id";
		return em.createQuery(jpql,Pedido.class).setParameter("id", id).getSingleResult();
	}

}