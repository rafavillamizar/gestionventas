package com.rafavillamizar.gestionventas.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.CiudadDao;
import com.rafavillamizar.gestionventas.entidad.Ciudad;

@Repository
public class CiudadDaoImpl extends DaoGenericoImpl<Ciudad> implements CiudadDao {
	
	@Override
	public List<Ciudad> obtenerCiudadesPorNombre(String nombre) {
		return obtenerTodosPorPropiedad("Ciudad", "nombre", nombre);
	}

	

}
