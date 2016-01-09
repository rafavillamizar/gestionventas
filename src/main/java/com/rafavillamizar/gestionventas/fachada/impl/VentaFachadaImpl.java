package com.rafavillamizar.gestionventas.fachada.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

import com.rafavillamizar.gestionventas.entidad.Cliente;
import com.rafavillamizar.gestionventas.entidad.Venta;
import com.rafavillamizar.gestionventas.json.FiltroJsonCiudad;
import com.rafavillamizar.gestionventas.json.FiltroJsonCliente;
import com.rafavillamizar.gestionventas.json.FiltroJsonDetalleVenta;
import com.rafavillamizar.gestionventas.json.FiltroJsonProducto;
import com.rafavillamizar.gestionventas.json.FiltroJsonVenta;
import com.rafavillamizar.gestionventas.servicio.DetalleVentaServicio;
import com.rafavillamizar.gestionventas.servicio.VentaServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class VentaFachadaImpl {

	@Resource
    private VentaServicio ventaServicio;

	@Resource
	private DetalleVentaServicio detalleVentaServicio;

	@RequestMapping(value = "/ventas", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerProductos(HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<Venta> ventas = ventaServicio.obtenerVentas();
		
		if(ventas != null && ventas.size() > 0) {
			for (Venta venta : ventas) {
				venta.setDetalles(detalleVentaServicio.obtenerDetallesVenta(venta.getVentaId()));
			}
		}

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonVenta(),
				ventas, response);
	}
	
	@RequestMapping(value = "/ventas", method = RequestMethod.POST)
    public @ResponseBody
    void guardarVenta(@RequestBody LinkedHashMap<String, Object> data, HttpServletResponse response) 
    				 throws JsonGenerationException, JsonMappingException, IOException 
    {
		Venta venta = new Venta();
		venta.setVentaId(((Integer)data.get("ventaId") != null) ? (Integer)data.get("ventaId") : null);
		
		Cliente cliente = new Cliente();
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> clienteObj = (LinkedHashMap<String, Object>)data.get("cliente");
		cliente.setClienteId((Integer)clienteObj.get("clienteId"));
		
		venta.setCliente(cliente);
		
		Calendar date = GregorianCalendar.getInstance();
		date.setTimeInMillis((Long)data.get("fechaVenta"));
		venta.setFechaVenta(date.getTime());
    	
		ventaServicio.guardarVenta(venta);
		
    	response.setStatus(HttpServletResponse.SC_CREATED);
    }
	
	@RequestMapping(value = "/ventas/{ventaId}", method = RequestMethod.DELETE)
	public @ResponseBody
	void eliminarVenta(HttpServletResponse response, @PathVariable Integer ventaId)
			throws JsonGenerationException, JsonMappingException, IOException {
		ventaServicio.eliminarVenta(ventaId);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonVenta()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonVenta", new FiltroJsonVenta());
		filters.addFilter("filtroJsonCliente", new FiltroJsonCliente());
		filters.addFilter("filtroJsonCiudad", new FiltroJsonCiudad());
		filters.addFilter("filtroJsonDetalleVenta", new FiltroJsonDetalleVenta());
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());

		return filters;
	}

}
