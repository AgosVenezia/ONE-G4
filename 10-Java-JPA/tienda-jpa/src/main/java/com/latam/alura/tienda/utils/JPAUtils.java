package com.latam.alura.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
Clase utilitaria para asignar la responsabilidad de creación del EntityManager, que tiene los métodos de consulta, así como de guardar o actualizar un registro. Para eso tiene que utilizar el EntityManager, por lo que se lo vamos a pasar como atributo.
*/
public class JPAUtils {
	
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("tienda");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}