package com.rafavillamizar.gestionventas.dao;

import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Producto;

public interface ProductoDao {
	
    Pagina<Producto> obtenerProductosPorPropiedadPaginado(String referencia, Integer numeroPagina);
    Pagina<Producto> obtenerProductosPaginado(Integer numeroPagina);
    void guardarProducto(Producto producto);
	void eliminarProducto(Integer productoId);
}
