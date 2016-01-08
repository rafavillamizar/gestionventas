package com.rafavillamizar.gestionventas.dao;

import java.util.List;

public interface DaoGenerico<E> {

	List<E> obtenerTodos(String entityName);
	List<E> obtenerTodosPorPropiedad(String entityName, String nombrePropiedad, Object valor);
	E obtenerById(String entityName, Integer id);
	void guardar(String entityName, E instancia);
	void eliminar(String entityName, E instancia);

}
