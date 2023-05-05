package com.latam.alura.tienda.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String dni;
	
	/*@Embedded
	private DatosPersonales datosPersonales;*/
	
	public Cliente() {}
	
	public Cliente(String nombre, String dni) {
		//this.datosPersonales=new DatosPersonales(nombre,dni);
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		//return datosPersonales.getNombre();
		return nombre;
	}

	public void setNombre(String nombre) {
		//this.datosPersonales.setNombre(nombre);
		this.nombre = nombre;
	}

	public String getDni() {
		//return datosPersonales.getDni();
		return dni;
	}

	public void setDni(String dni) {
		//this.datosPersonales.setDni(dni);
		this.dni = dni;
	}

}