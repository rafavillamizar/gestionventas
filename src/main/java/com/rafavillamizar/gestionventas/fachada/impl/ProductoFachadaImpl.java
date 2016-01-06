package com.rafavillamizar.gestionventas.fachada.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.springframework.stereotype.Controller;
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

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonProductos(),
				productos, response);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonProductos()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());

		return filters;
	}

}
