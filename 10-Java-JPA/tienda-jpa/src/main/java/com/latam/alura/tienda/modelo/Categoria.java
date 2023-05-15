package com.latam.alura.tienda.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

/*
// Cuando se tienen elementos limitados conocidos es recomendable utilizar el numerador. Usando el numerador, a la hora de guardar en la base de datos, el nombre va a ser un elemento de tipo varchar, la descripción va a ser varchar, el precio del tipo decimal y el id va a ser un elemento de tipo entero.
public enum Categoria {

	SOFTWARES,
	LIBROS,
	CELULARES

}
Esto presenta el problema de que si el cliente quisiera agregar nuevas categorías o eliminar alguna de esas categorías existentes, no podría. Entonces, para darle más flexibilidad al proyecto, se elimina el numerador y se crea una nueva entidad categoría, lo que permite guardar este elemento de la categoría en la base de datos y permitir que el cliente almacene diversos elementos dentro de la categoría.
*/

@Entity
@Table(name="categorias")
public class Categoria {
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;*/

	@EmbeddedId
	private CategoriaId categoriaId;
	
	public Categoria() {
		
	}

	public Categoria(String nombre) {
		//this.nombre = nombre;
		this.categoriaId = new CategoriaId(nombre, "456");
	}
	
	/*public Long getId() {
		return id;
	}*/

	/*public void setId(Long id) {
		this.id = id;
	}*/

	public String getNombre() {
		//return nombre;
		return categoriaId.getNombre();
	}

	public void setNombre(String nombre) {
		//this.nombre = nombre;
		this.categoriaId.setNombre(nombre);
	}
	
}