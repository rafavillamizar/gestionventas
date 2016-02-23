package com.rafavillamizar.gestionventas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafavillamizar.gestionventas.dao.VentaDao;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Venta;
import com.rafavillamizar.gestionventas.servicio.VentaServicio;

@Service("ventaServicio")
public class VentaServicioImpl implements VentaServicio {
	
	@Autowired(required = true)
    private VentaDao ventaDao;
	
	@Transactional(readOnly=true)
	@Override
	public Pagina<Venta> obtenerVentasPaginado(Integer numeroPagina) {
		return ventaDao.obtenerVentasPaginado(numeroPagina);
	}

	@Transactional(readOnly=true)
	@Override
	public Pagina<Venta> obtenerVentas() {
		return ventaDao.obtenerVentas();
	}

	@Transactional
	@Override
	public void guardarVenta(Venta venta) {
		ventaDao.guardarVenta(venta);
	}

	@Transactional
	@Override
	public void eliminarVenta(Integer ventaId) {
		ventaDao.eliminarVenta(ventaId);
	}

}
