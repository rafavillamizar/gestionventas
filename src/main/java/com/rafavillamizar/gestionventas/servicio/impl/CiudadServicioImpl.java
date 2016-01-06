package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafavillamizar.gestionventas.dao.CiudadDao;
import com.rafavillamizar.gestionventas.entidad.Ciudad;
import com.rafavillamizar.gestionventas.servicio.CiudadServicio;

@Service("ciudadServicio")
public class CiudadServicioImpl implements CiudadServicio {
	
	@Autowired(required = true)
    private CiudadDao ciudadDao;

	@Override
	public List<Ciudad> obtenerCiudades() {
		return ciudadDao.obtenerCiudades();
	}

}
