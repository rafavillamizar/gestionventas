package com.rafavillamizar.gestionventas.servicio;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.Venta;

public interface VentaServicio {
	
	List<Venta> obtenerVentas();
	void guardarVenta(Venta venta);
    void actualizarVenta(Venta venta);
	void eliminarVenta(Integer ventaId);
}
