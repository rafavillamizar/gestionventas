package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafavillamizar.gestionventas.dao.DetalleVentaDao;
import com.rafavillamizar.gestionventas.entidad.DetalleVenta;
import com.rafavillamizar.gestionventas.servicio.DetalleVentaServicio;

@Service("detalleVentaServicio")
public class DetalleVentaServicioImpl implements DetalleVentaServicio {
	
	@Autowired(required = true)
    private DetalleVentaDao detalleVentaDao;

	@Override
	public List<DetalleVenta> obtenerDetallesVenta(Integer ventaId) {
		return detalleVentaDao.obtenerDetallesVenta(ventaId);
	}

	@Override
	public void guardarDetalleVenta(DetalleVenta detalleVenta) {
		detalleVentaDao.guardarDetalleVenta(detalleVenta);
	}

	@Override
	public void actualizarDetalleVenta(DetalleVenta detalleVenta) {
		detalleVentaDao.actualizarDetalleVenta(detalleVenta);
	}

	@Override
	public void eliminarDetalleVenta(Integer detalleVentaId) {
		// TODO Auto-generated method stub
	}

}
