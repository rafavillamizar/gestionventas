package com.rafavillamizar.gestionventas.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.DetalleVentaDao;
import com.rafavillamizar.gestionventas.entidad.DetalleVenta;

@Repository
public class DetalleVentaDaoImpl extends DaoGenericoImpl<DetalleVenta> implements DetalleVentaDao {

	@Override
	public List<DetalleVenta> obtenerDetallesVenta(Integer ventaId) {
		//return obtenerTodosPorPropiedad("DetalleVenta", "ventaId", ventaId);
		return null;
	}

	@Override
	public void guardarDetalleVenta(DetalleVenta detalleVenta) {
		guardar("DetalleVenta", detalleVenta);
	}

	@Override
	public void eliminarDetalleVenta(Integer detalleVentaId) {
		String detalleVentaEntityName = "DetalleVenta";
		DetalleVenta detalleVenta = obtenerById(detalleVentaEntityName, detalleVentaId);
		
		if(detalleVenta != null)
			eliminar(detalleVentaEntityName, detalleVenta);
	}

}
