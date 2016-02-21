package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafavillamizar.gestionventas.dao.DetalleVentaDao;
import com.rafavillamizar.gestionventas.entidad.DetalleVenta;
import com.rafavillamizar.gestionventas.servicio.DetalleVentaServicio;

@Service("detalleVentaServicio")
public class DetalleVentaServicioImpl implements DetalleVentaServicio {
	
	@Autowired(required = true)
    private DetalleVentaDao detalleVentaDao;

	@Transactional(readOnly=true)
	@Override
	public List<DetalleVenta> obtenerDetallesVenta(Integer ventaId) {
		return detalleVentaDao.obtenerDetallesVenta(ventaId);
	}

	@Transactional
	@Override
	public void guardarDetalleVenta(DetalleVenta detalleVenta) {
		detalleVentaDao.guardarDetalleVenta(detalleVenta);
	}

	@Transactional
	@Override
	public void eliminarDetalleVenta(Integer detalleVentaId) {
		detalleVentaDao.eliminarDetalleVenta(detalleVentaId);
	}

}
