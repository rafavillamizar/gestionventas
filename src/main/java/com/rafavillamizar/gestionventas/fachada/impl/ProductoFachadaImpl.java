package com.rafavillamizar.gestionventas.fachada.impl;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.rafavillamizar.gestionventas.entidad.Producto;
import com.rafavillamizar.gestionventas.json.FiltroJsonProducto;
import com.rafavillamizar.gestionventas.servicio.ProductoServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class ProductoFachadaImpl {

	@Resource
	private ProductoServicio productoServicio;

	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerProductos(HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<Producto> productos = productoServicio.obtenerProductos();

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonProducto(),
				productos, response);
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

		productoServicio.guardarProducto(producto);
		
    	response.setStatus(HttpServletResponse.SC_CREATED);
    }
	
	@RequestMapping(value = "/productos/{productoId}", method = RequestMethod.DELETE)
	public @ResponseBody
	void eliminarProducto(HttpServletResponse response, @PathVariable Integer productoId)
			throws JsonGenerationException, JsonMappingException, IOException {
		productoServicio.eliminarProducto(productoId);
	}

	private SimpleFilterProvider obtenerFiltrosJsonProducto()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());

		return filters;
	}

}
