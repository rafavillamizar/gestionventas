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

import com.rafavillamizar.gestionventas.entidad.Ciudad;
import com.rafavillamizar.gestionventas.json.FiltroJsonProducto;
import com.rafavillamizar.gestionventas.servicio.CiudadServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class CiudadFachadaImpl {

	@Resource
    private CiudadServicio ciudadServicio;

	@RequestMapping(value = "/ciudades", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerCiudades(HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<Ciudad> ciudades = ciudadServicio.obtenerCiudades();

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonProductos(),
				ciudades, response);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonProductos()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());

		return filters;
	}

}
