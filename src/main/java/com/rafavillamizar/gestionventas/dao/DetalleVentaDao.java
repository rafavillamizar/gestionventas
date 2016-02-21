package com.rafavillamizar.gestionventas.dao;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.DetalleVenta;

public interface DetalleVentaDao {
	
    List<DetalleVenta> obtenerDetallesVenta(Integer ventaId);
    void guardarDetalleVenta(DetalleVenta detalleVenta);
	void eliminarDetalleVenta(Integer detalleVentaId);
}
