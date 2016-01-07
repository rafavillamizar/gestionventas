package com.rafavillamizar.gestionventas.dao;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.Producto;

public interface ProductoDao {
	
    List<Producto> obtenerProductos();
    void guardarProducto(Producto producto);
    void actualizarProducto(Producto producto);
	void eliminarProducto(Producto producto);
}
