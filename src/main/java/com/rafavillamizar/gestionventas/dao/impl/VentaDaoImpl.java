package com.rafavillamizar.gestionventas.dao.impl;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.VentaDao;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Venta;

@Repository
public class VentaDaoImpl extends DaoGenericoImpl<Venta> implements VentaDao {

	@Override
	public Pagina<Venta> obtenerVentasPaginado(Integer numeroPagina) {
		Pagina<Venta> paginaVenta = new Pagina<Venta>();
		paginaVenta.setNumeroPagina(numeroPagina);
		paginaVenta.setTotalElementos(obtenerNumeroElementosPaginado("Venta"));
		paginaVenta.setResultado(obtenerTodosPaginado("Venta",
				"ventaId", numeroPagina));

		return paginaVenta;
	}

	@Override
	public Pagina<Venta> obtenerVentas() {
		Pagina<Venta> paginaVenta = new Pagina<Venta>();
		paginaVenta.setNumeroPagina(0);
		paginaVenta.setTotalElementos(0);
		paginaVenta.setResultado(obtenerTodos("Venta"));

		return paginaVenta;
	}

	@Override
	public void guardarVenta(Venta venta) {
		guardar("Venta", venta);
	}

	@Override
	public void eliminarVenta(Integer ventaId) {
		String ventaEntityName = "Venta";
		Venta venta = obtenerById(ventaEntityName, ventaId);
		
		if(venta != null)
			eliminar(ventaEntityName, venta);
	}

}
