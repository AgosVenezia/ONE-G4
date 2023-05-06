package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha=LocalDate.now();
	//@Column(name="valor_total")
	private BigDecimal valorTotal=new BigDecimal(0); // De esta forma, no es necesario agregar un DAO
	
	// Elementos ToOne - Eager - Estrategia de carga anticipada - Hacen JOIN con todos los atributos que tienen esas anotaciones
	// Elemetos ToMany - Lazy - Generalmente listas - Llama a los elementos solo cuando son solicitados
	// ¿Por qué es interesante utilizar el recurso JOIN FETCH en una consulta JPQL? Para evitar cargar relaciones en todas las consultas de aplicaciones. JOIN FETCH permite elegir qué relaciones se cargarán en una consulta determinada, en lugar de cargarlas siempre.
	@ManyToOne(fetch=FetchType.LAZY)
	private Cliente cliente;

	/*@ManyToMany // Un pedido puede tener muchos productos y ese producto puede estar en muchos pedidos.
	@JoinTable(name="items_pedido")
	private List<Producto> productos;*/
	
	// ManyToOne...OneToMany = ManyToToMany
	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL) 
	// Mappeada por el elemento pedido existente en la entidad pedido
	// ¿Por qué se debe usar el parámetro mappedBy en la anotación @OneToMany? Para indicar que se trata de una relación bidireccional. Sin este parámetro, JPA considera que es otra relación, asumiendo que hay otra tabla de unión.
	// ¿Cuál es el uso del parámetro cascade? Propagar las operaciones realizadas en una entidad en su relación. Cascade crea un efecto dominó en las operaciones realizadas en una entidad. Utilizado para entidades relacionadas, cada vez que altera “pedidos” altera “items”.
	private List<ItemsPedido> items=new ArrayList<>(); // Inicializa en una lista vacía
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido() {}
	
	public void agregarItems(ItemsPedido item) { // Agrega nuevos items a la lista
		item.setPedido(this);
		this.items.add(item);
		this.valorTotal= this.valorTotal.add(item.getValor());
	}

	/*public List<ItemsPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemsPedido> items) {
		this.items = items;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
