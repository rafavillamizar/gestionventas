package com.rafavillamizar.gestionventas.fachada.impl;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.entidad.Producto;
import com.rafavillamizar.gestionventas.json.FiltroJsonPagina;
import com.rafavillamizar.gestionventas.json.FiltroJsonProducto;
import com.rafavillamizar.gestionventas.servicio.ProductoServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class ProductoFachadaImpl {

	@Resource
	private ProductoServicio productoServicio;

	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerProductos(@RequestParam(value = "referencia", required = false, defaultValue = "") String referencia,
			@RequestParam(value = "numeroPagina", required = true, defaultValue = "1") Integer numeroPagina, 
			HttpServletResponse response)
					throws JsonGenerationException, JsonMappingException, IOException {
		Pagina<Producto> paginaProducto = null;
		
		if(numeroPagina != null && numeroPagina.compareTo(1) >= 0) {
			if(referencia != null && !referencia.isEmpty())
				paginaProducto = productoServicio.obtenerProductosPorPropiedadPaginado(referencia, numeroPagina);
			else
				paginaProducto = productoServicio.obtenerProductosPaginado(numeroPagina);
		}
		
		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonPagina(),
				paginaProducto, response);
	}
	
	@RequestMapping(value = "/productos", method = RequestMethod.POST)
    public @ResponseBody
    void guardarProducto(@RequestBody LinkedHashMap<String, Object> data, HttpServletResponse response) 
    				 throws JsonGenerationException, JsonMappingException, IOException 
    {
		Producto producto = new Producto();
		producto.setProductoId(((Integer)data.get("productoId") != null) ? (Integer)data.get("productoId") : null);
		producto.setNombre((String)data.get("nombre"));
		producto.setPrecio((Integer)data.get("precio"));
		producto.setReferencia((String)data.get("referencia"));
		producto.setCaracteristicas((String)data.get("caracteristicas"));
		producto.setImagen((String)data.get("imagen"));

		productoServicio.guardarProducto(producto);
		
    	response.setStatus(HttpServletResponse.SC_CREATED);
    }
	
	@RequestMapping(value = "/productos/{productoId}", method = RequestMethod.DELETE)
	public @ResponseBody
	void eliminarProducto(HttpServletResponse response, @PathVariable Integer productoId)
			throws JsonGenerationException, JsonMappingException, IOException {
		productoServicio.eliminarProducto(productoId);
	}

	private SimpleFilterProvider obtenerFiltrosJsonPagina()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonPagina", new FiltroJsonPagina());
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());
		
		return filters;
	}

}
