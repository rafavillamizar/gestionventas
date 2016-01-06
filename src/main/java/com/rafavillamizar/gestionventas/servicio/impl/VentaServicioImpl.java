package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafavillamizar.gestionventas.dao.VentaDao;
import com.rafavillamizar.gestionventas.entidad.Venta;
import com.rafavillamizar.gestionventas.servicio.VentaServicio;

@Service("ventaServicio")
public class VentaServicioImpl implements VentaServicio {
	
	@Autowired(required = true)
    private VentaDao ventaDao;

	@Override
	public List<Venta> obtenerVentas() {
		return ventaDao.obtenerVentas();
	}

}
