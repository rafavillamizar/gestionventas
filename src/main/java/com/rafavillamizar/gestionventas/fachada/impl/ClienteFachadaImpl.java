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

import com.rafavillamizar.gestionventas.entidad.Ciudad;
import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.entidad.Pagina;
import com.rafavillamizar.gestionventas.json.FiltroJsonCiudad;
import com.rafavillamizar.gestionventas.json.FiltroJsonCliente;
import com.rafavillamizar.gestionventas.json.FiltroJsonPagina;
import com.rafavillamizar.gestionventas.servicio.ClienteServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class ClienteFachadaImpl {

	@Resource
    private ClienteServicio clienteServicio;

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerClientes(@RequestParam(value = "nif", required = false, defaultValue = "") String nif, 
			@RequestParam(value = "numeroPagina", required = false, defaultValue = "0") Integer numeroPagina,  
			HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		Pagina<Cliente> paginaCliente = null;
		
		if(numeroPagina != null && numeroPagina.compareTo(1) >= 0) {
			if(nif != null && !nif.isEmpty())
				paginaCliente = clienteServicio.obtenerClientesPorPropiedadPaginado(nif, numeroPagina);
			else
				paginaCliente = clienteServicio.obtenerClientesPaginado(numeroPagina);
		} else
			paginaCliente = clienteServicio.obtenerClientes();
		
		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonPagina(),
				paginaCliente, response);
	}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public @ResponseBody
    void guardarCliente(@RequestBody LinkedHashMap<String, Object> data, HttpServletResponse response) 
    				 throws JsonGenerationException, JsonMappingException, IOException 
    {
    	Cliente cliente = new Cliente();
    	cliente.setClienteId(((Integer)data.get("clienteId") != null) ? (Integer)data.get("clienteId") : null);
    	cliente.setNif((String)data.get("nif"));
    	cliente.setEmail((String)data.get("email"));
    	cliente.setNombre((String)data.get("nombre"));
    	cliente.setApellido1((String)data.get("apellido1"));
    	cliente.setApellido2((String)data.get("apellido2"));
    	cliente.setDireccion((String)data.get("direccion"));
    	
    	Ciudad ciudad = new Ciudad();
    	@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> ciudadObj = (LinkedHashMap<String, Object>)data.get("ciudad");
    	ciudad.setCiudadId((Integer)ciudadObj.get("ciudadId"));
    	
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
	
	private SimpleFilterProvider obtenerFiltrosJsonPagina()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonPagina", new FiltroJsonPagina());
		filters.addFilter("filtroJsonCliente", new FiltroJsonCliente());
		filters.addFilter("filtroJsonCiudad", new FiltroJsonCiudad());
		
		return filters;
	}

}
