package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
//import java.time.LocalDate;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
La anotación @Entity se puede importar de Java-persistence o de hibernate-annotation. Como nosotros queremos permanecer ágiles y dinámicos, tenemos que mantenernos con la especificación y no con la implementación. Si nosotros nos mantenemos con la implementación que sería Hibernate a la hora de cambiar Hibernate por alguna otra implementación, por algún otro framework, sería muy difícil, ya que tendríamos que cambiar varios elementos dentro de nuestro proyecto. Entonces nosotros, vamos a seleccionar java-persistence.
*/
@Entity
@Table(name="productos")
/*
Hibernate y JPA realizan un mapeamento de los elementos existentes en nuestra clase para compararlos con el modelo en la base de datos, entonces por default se entiende que el nombre de la clase es el mismo nombre que existe para la tabla. En nuestro caso no lo es: el nombre de esta clase es la clase producto y la clase en la base de datos es productos en plural. Entonces, para indicar esa diferencia, vamos a usar otra anotación que va a ser @Table. Y esa anotación, va a pedir un parámetro a ser @Table(name=”productos”).
*/
public class Producto{

	/*
	El id es un elemento existente en las tablas que representa la unicidad de cada una de esas filas. Para indicarle a nuestro proyecto cuál va a ser el id o el identificador de cada una de esas filas, tenemos la anotación @Id también de JPA. Importamos la clase de JPA, y la responsabilidad de generar ese identificador va a ser siempre de la base de datos. Entonces, para nosotros indicarle que la responsabilidad no pertenece al usuario, sino a la base de datos, tenemos otra anotación que sería la anotación @GeneratedValue y tenemos que pasarle un parámetro, el parámetro de la estrategia de generación Strategy=GenerationType. Entonces el tipo de generación para esta base de datos h2 sería la identity.
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/*
	Si tenemos un atributo que sea diferente tenemos que utilizar la anotación @Column pasando el parámetro name, igual y pasaríamos el nombre correcto de la tabla. Digamos que sean nombres, pasaríamos nombres. Siempre tienen que ser el mismo valor para poder realizar el mapeamento. Si no, generaría un error. En este caso podrían dejar con el mismo nombre, pero sería redundante.
	*/
	//@Column(name="nombre")
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	//private LocalDate fechaDeRegistro= LocalDate.now();
	
	/*@ManyToOne
	private Categoria categoria;*/

	
	/*public Producto() {
		
	}
	public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}
