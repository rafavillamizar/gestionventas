package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafavillamizar.gestionventas.dao.ProductoDao;
import com.rafavillamizar.gestionventas.entidad.Producto;
import com.rafavillamizar.gestionventas.servicio.ProductoServicio;

@Service("productoServicio")
public class ProductoServicioImpl implements ProductoServicio {
	
	@Autowired(required = true)
    private ProductoDao productoDao;

	@Override
	public List<Producto> obtenerProductos() {
		return productoDao.obtenerProductos();
	}

	@Override
	public void guardarProducto(Producto producto) {
		productoDao.guardarProducto(producto);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		productoDao.actualizarProducto(producto);
	}

	@Override
	public void eliminarProducto(Integer productoId) {
		// TODO Auto-generated method stub
	}

}
