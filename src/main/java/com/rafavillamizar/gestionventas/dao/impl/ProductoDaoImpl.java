package com.rafavillamizar.gestionventas.dao.impl;

import org.springframework.stereotype.Repository;

import com.rafavillamizar.gestionventas.dao.ProductoDao;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Producto;

@Repository
public class ProductoDaoImpl extends DaoGenericoImpl<Producto> implements
		ProductoDao {

	@Override
	public Pagina<Producto> obtenerProductosPorPropiedadPaginado(
			String referencia, Integer numeroPagina) {
		Pagina<Producto> paginaProducto = new Pagina<Producto>();
		paginaProducto.setNumeroPagina(numeroPagina);
		paginaProducto.setTotalElementos(obtenerNumeroElementosPorPropiedadPaginado("Producto", "referencia", referencia));
		paginaProducto.setResultado(obtenerTodosPorPropiedadPaginado(
				"Producto", "referencia", referencia, "productoId",
				numeroPagina));

		return paginaProducto;
	}

	@Override
	public Pagina<Producto> obtenerProductosPaginado(Integer numeroPagina) {
		Pagina<Producto> paginaProducto = new Pagina<Producto>();
		paginaProducto.setNumeroPagina(numeroPagina);
		paginaProducto.setTotalElementos(obtenerNumeroElementosPaginado("Producto"));
		paginaProducto.setResultado(obtenerTodosPaginado("Producto",
				"productoId", numeroPagina));

		return paginaProducto;
	}
	
	@Override
	public Pagina<Producto> obtenerProductos() {
		Pagina<Producto> paginaProducto = new Pagina<Producto>();
		paginaProducto.setNumeroPagina(0);
		paginaProducto.setTotalElementos(0);
		paginaProducto.setResultado(obtenerTodos("Producto"));

		return paginaProducto;
	}

	@Override
	public void guardarProducto(Producto producto) {
		guardar("Producto", producto);
	}

	@Override
	public void eliminarProducto(Integer productoId) {
		String productoEntityName = "Producto";
		Producto producto = obtenerById(productoEntityName, productoId);

		if (producto != null)
			eliminar(productoEntityName, producto);
	}

}
