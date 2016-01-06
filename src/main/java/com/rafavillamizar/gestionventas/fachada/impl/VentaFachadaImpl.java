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

import com.rafavillamizar.gestionventas.entidad.Venta;
import com.rafavillamizar.gestionventas.json.FiltroJsonProducto;
import com.rafavillamizar.gestionventas.servicio.VentaServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class VentaFachadaImpl {

	@Resource
    private VentaServicio ventaServicio;

	@RequestMapping(value = "/ventas", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerProductos(HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<Venta> ventas = ventaServicio.obtenerVentas();

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonProductos(),
				ventas, response);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonProductos()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());

		return filters;
	}

}
