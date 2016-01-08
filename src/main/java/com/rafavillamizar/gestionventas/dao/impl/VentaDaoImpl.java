package com.rafavillamizar.gestionventas.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.VentaDao;
import com.rafavillamizar.gestionventas.entidad.Venta;

@Repository
public class VentaDaoImpl extends DaoGenericoImpl<Venta> implements VentaDao {

	@Override
	public List<Venta> obtenerVentas() {
		return obtenerTodos("Venta");
	}

	@Override
	public void guardarVenta(Venta venta) {
		guardar("Venta", venta);
	}

	@Override
	public void eliminarVenta(Venta venta) {
		eliminar("Venta", venta);
	}
	

}
