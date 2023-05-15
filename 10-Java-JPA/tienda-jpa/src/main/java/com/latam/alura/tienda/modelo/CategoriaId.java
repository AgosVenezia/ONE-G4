package com.latam.alura.tienda.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable // Llave primaria
// Todos los elementos del tipo Embeddable tienen que implementar la interfaz Serializable
public class CategoriaId implements Serializable {
// Elementos serializados en bits para transitar en nuestra app.

	private static final long serialVersionUID = 4198020985304539350L;
	
	// Llave compuesta de míltiples parámetros (nombre, password)
	private String nombre;
	private String password;
	
	public CategoriaId() {

	}

	public CategoriaId(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() { // Elementos únicos hashCode
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaId other = (CategoriaId) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
}

/*
El primero es la anotación @Embeddable y @Embedded que nos permiten agrupar un conjunto de atributos o propiedades dentro de otra clase que no va a ser indicada como una nueva entidad, sino como una clase que va a ser inyectada dentro de nuestra clase entidad. Con esto podemos agrupar atributos como dirección, datos personales, datos familiares, entre otros, sin tener que colocar millones de atributos en una única clase. Solo hay que notar que al reemplazar los atributos por una clase embutida tenemos que cuidar que los getter y setter así como, otros métodos continúen funcionando correctamente. De lo contrario podemos delegar la función de retornar esa propiedad para la nueva clase construyendo así un método delegate.

El segundo recurso es el mapeamiento de herencia, puede que querramos crear nuevas entidades que compartan propiedades o más especificamente que deriven de una clase madre. Para lograr esto no tenemos que colocar todas la propiedades en la nueva entidad, sino que solo debemos marcar la clase madre con la anotación @Inheritance y construir nuestras nuevas entidades, normalmente, colocando solo las nuevas propiedades y usando la palabra reservada extends para indicar herencia de clase.

Y ya por último, existe un recurso que nos permite identificar elementos en nuestras entidades utilizando más de un único parámetro, generalmente utilizamos un parámetro que puede ser numérico o alfanumérico para identificar las filas. A esto se llama llave primaria única, pero podemos utilizar llaves primarias con parámetros compuestos, para eso JPA nos provee como recurso la anotación @EmbeddedId que nos permite indicarle a nuestra entidad que está siendo inyectada una clase que no es una entidad, sino una clase que compone el ID de esa entidad formado por multiples parametros. En la clase que va a componer la llave primaria la anotamos con @Embeddable como lo habíamos hecho anteriormente, pero la anotación @EmbeddedId va a indicarle a la entidad que debe tomar esa clase como ID, adicional todas las clases embutidas sean llaves primarias o no deben implantar la interfaz Serializable ya que sirve para indicarle a la API que van a haber datos transitando dentro de ella.
*/