package com.rafavillamizar.gestionventas.servicio;

import java.util.List;

import com.rafavillamizar.gestionventas.entidad.Producto;

public interface ProductoServicio {
	
	List<Producto> obtenerProductos();
	void guardarProducto(Producto producto);
    void actualizarProducto(Producto producto);
	void eliminarProducto(Integer productoId);
}
