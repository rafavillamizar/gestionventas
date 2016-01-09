package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafavillamizar.gestionventas.dao.CiudadDao;
import com.rafavillamizar.gestionventas.entidad.Ciudad;
import com.rafavillamizar.gestionventas.servicio.CiudadServicio;

@Service("ciudadServicio")
public class CiudadServicioImpl implements CiudadServicio {
	
	@Autowired(required = true)
    private CiudadDao ciudadDao;

	@Transactional(readOnly=true)
	@Override
	public List<Ciudad> obtenerCiudadesPorNombre(String nombre) {
		return ciudadDao.obtenerCiudadesPorNombre(nombre);
	}

}
