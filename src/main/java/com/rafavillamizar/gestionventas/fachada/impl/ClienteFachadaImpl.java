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

import com.rafavillamizar.gestionventas.entidad.Ciudad;
import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.json.FiltroJsonCiudad;
import com.rafavillamizar.gestionventas.json.FiltroJsonCliente;
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

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonCliente(),
				clientes, response);
	}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public @ResponseBody
    void guardarCliente(@RequestBody LinkedHashMap<String, Object> data, HttpServletResponse response) 
    				 throws JsonGenerationException, JsonMappingException, IOException 
    {
    	Cliente cliente = new Cliente();
    	cliente.setNif((String)data.get("nif"));
    	cliente.setEmail((String)data.get("email"));
    	cliente.setNombre((String)data.get("nombre"));
    	cliente.setApellido1((String)data.get("apellido1"));
    	cliente.setApellido2((String)data.get("apellido2"));
    	
    	Ciudad ciudad = new Ciudad();
    	ciudad.setCiudadId(Integer.parseInt((String)data.get("ciudadId")));
    	
    	cliente.setCiudad(ciudad);
    	
    	clienteServicio.guardarCliente(cliente);
    	
    	response.setStatus(HttpServletResponse.SC_CREATED);
    }
	
	@RequestMapping(value = "/clientes/{clienteId}", method = RequestMethod.DELETE)
	public @ResponseBody
	void eliminarCliente(HttpServletResponse response, @PathVariable Integer clienteId)
			throws JsonGenerationException, JsonMappingException, IOException {
		clienteServicio.eliminarCliente(clienteId);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonCliente()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonCliente", new FiltroJsonCliente());
		filters.addFilter("filtroJsonCiudad", new FiltroJsonCiudad());

		return filters;
	}

}
