package com.rafavillamizar.gestionventas.dao;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.Venta;

public interface VentaDao {
	
    List<Venta> obtenerVentas();
    void guardarVenta(Venta venta);
	void eliminarVenta(Venta venta);
}
