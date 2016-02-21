package com.rafavillamizar.gestionventas.dao;

import java.util.List;

public interface DaoGenerico<E> {

	List<E> obtenerTodos(String entityName);
	List<E> obtenerTodosPaginado(String entityName, String propiedad, Integer numeroPagina);
	List<E> obtenerTodosPorPropiedadPaginado(String entityName, String nombrePropiedad, Object valor, String propiedad, Integer numeroPagina);
	Integer obtenerNumeroElementosPaginado(String entityName);
	Integer obtenerNumeroElementosPorPropiedadPaginado(String entityName, String nombrePropiedad, Object valor);
	E obtenerById(String entityName, Integer id);
	void guardar(String entityName, E instancia);
	void eliminar(String entityName, E instancia);

}
