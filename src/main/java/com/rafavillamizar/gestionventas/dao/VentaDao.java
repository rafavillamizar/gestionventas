package com.rafavillamizar.gestionventas.dao;

import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Venta;

public interface VentaDao {
	
	Pagina<Venta> obtenerVentasPaginado(Integer numeroPagina);
    Pagina<Venta> obtenerVentas();
    void guardarVenta(Venta venta);
	void eliminarVenta(Integer ventaId);
}
