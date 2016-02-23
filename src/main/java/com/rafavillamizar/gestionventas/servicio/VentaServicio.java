package com.rafavillamizar.gestionventas.servicio;

import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Venta;

public interface VentaServicio {
	
	Pagina<Venta> obtenerVentasPaginado(Integer numeroPagina);
	Pagina<Venta> obtenerVentas();
	void guardarVenta(Venta venta);
	void eliminarVenta(Integer ventaId);
}
