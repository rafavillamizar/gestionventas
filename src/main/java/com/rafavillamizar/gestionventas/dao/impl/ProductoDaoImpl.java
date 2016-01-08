package com.rafavillamizar.gestionventas.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.ProductoDao;
import com.rafavillamizar.gestionventas.entidad.Producto;

@Repository
public class ProductoDaoImpl extends DaoGenericoImpl<Producto> implements ProductoDao {
	
	@Override
	public List<Producto> obtenerProductos() {
		return obtenerTodos("Producto");
	}

	@Override
	public void guardarProducto(Producto producto) {
		guardar("Producto", producto);
	}

	@Override
	public void eliminarProducto(Integer productoId) {
		String productoEntityName = "Producto";
		Producto producto = obtenerById(productoEntityName, productoId);
		
		if(producto != null)
			eliminar(productoEntityName, producto);
	}

}
