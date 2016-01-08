package com.rafavillamizar.gestionventas.servicio;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.DetalleVenta;

public interface DetalleVentaServicio {
	
	List<DetalleVenta> obtenerDetallesVenta(Integer ventaId);
	void guardarDetalleVenta(DetalleVenta detalleVenta);
	void eliminarDetalleVenta(Integer detalleVentaId);
}
