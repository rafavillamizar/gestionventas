package com.rafavillamizar.gestionventas.dao;

import java.util.List;

public interface DaoGenerico<E> {

	List<E> obtenerTodos(String entityName);

}
