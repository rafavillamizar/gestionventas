package com.rafavillamizar.gestionventas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafavillamizar.gestionventas.dao.ProductoDao;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Producto;
import com.rafavillamizar.gestionventas.servicio.ProductoServicio;

@Service("productoServicio")
public class ProductoServicioImpl implements ProductoServicio {
	
	@Value("${imagen.url}")
	private String imagenUrl;
	
	@Autowired(required = true)
    private ProductoDao productoDao;

	@Transactional(readOnly=true)
	@Override
	public Pagina<Producto> obtenerProductosPorPropiedadPaginado(String referencia, Integer numeroPagina) {
		Pagina<Producto> paginaProducto = productoDao.obtenerProductosPorPropiedadPaginado(referencia, numeroPagina);
		
		if (paginaProducto != null && paginaProducto.getResultado() != null
				&& !paginaProducto.getResultado().isEmpty()) {
			for (Producto producto : paginaProducto.getResultado()) {
				if (producto.getImagen() != null
						&& !producto.getImagen().isEmpty())
					producto.setImagenUrl(imagenUrl + producto.getImagen());
			}
		}
		
		return paginaProducto;
	}
	
	@Transactional(readOnly=true)
	@Override
	public Pagina<Producto> obtenerProductosPaginado(Integer numeroPagina) {
		Pagina<Producto> paginaProducto = productoDao
				.obtenerProductosPaginado(numeroPagina);

		if (paginaProducto != null && paginaProducto.getResultado() != null
				&& !paginaProducto.getResultado().isEmpty()) {
			for (Producto producto : paginaProducto.getResultado()) {
				if (producto.getImagen() != null
						&& !producto.getImagen().isEmpty())
					producto.setImagenUrl(imagenUrl + producto.getImagen());
			}
		}

		return paginaProducto;

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
