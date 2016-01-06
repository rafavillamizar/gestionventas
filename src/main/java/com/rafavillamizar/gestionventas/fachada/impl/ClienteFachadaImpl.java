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

import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.json.FiltroJsonProducto;
import com.rafavillamizar.gestionventas.servicio.ClienteServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class ClienteFachadaImpl {

	@Resource
    private ClienteServicio clienteServicio;

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerProductos(HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<Cliente> clientes = clienteServicio.obtenerClientes();

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonProductos(),
				clientes, response);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonProductos()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());

		return filters;
	}

}
