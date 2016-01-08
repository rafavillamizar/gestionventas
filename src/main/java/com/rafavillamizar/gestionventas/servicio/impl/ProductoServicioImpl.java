package com.rafavillamizar.gestionventas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafavillamizar.gestionventas.dao.ProductoDao;
import com.rafavillamizar.gestionventas.entidad.Producto;
import com.rafavillamizar.gestionventas.servicio.ProductoServicio;

@Service("productoServicio")
public class ProductoServicioImpl implements ProductoServicio {
	
	@Autowired(required = true)
    private ProductoDao productoDao;

	@Transactional(readOnly=true)
	@Override
	public List<Producto> obtenerProductos() {
		return productoDao.obtenerProductos();
	}

	@Transactional
	@Override
	public void guardarProducto(Producto producto) {
		productoDao.guardarProducto(producto);
	}

	@Transactional
	@Override
	public void eliminarProducto(Integer productoId) {
		productoDao.eliminarProducto(productoId);
	}

}
