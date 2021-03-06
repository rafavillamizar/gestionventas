package com.rafavillamizar.gestionventas.servicio;

import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Producto;

public interface ProductoServicio {
	
	Pagina<Producto> obtenerProductosPorPropiedadPaginado(String referencia, Integer numeroPagina);
	Pagina<Producto> obtenerProductosPaginado(Integer numeroPagina);
	Pagina<Producto> obtenerProductos();
	void guardarProducto(Producto producto);
	void eliminarProducto(Integer productoId);
}
