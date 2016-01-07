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

import com.rafavillamizar.gestionventas.entidad.DetalleVenta;
import com.rafavillamizar.gestionventas.entidad.Producto;
import com.rafavillamizar.gestionventas.json.FiltroJsonDetalleVenta;
import com.rafavillamizar.gestionventas.json.FiltroJsonProducto;
import com.rafavillamizar.gestionventas.servicio.DetalleVentaServicio;
import com.rafavillamizar.gestionventas.util.JsonUtils;

@Controller
public class DetalleVentaFachadaImpl {

	@Resource
    private DetalleVentaServicio detalleVentaServicio;

	@RequestMapping(value = "/ventas/{ventaId}/detalles", method = RequestMethod.GET)
	public @ResponseBody
	void obtenerProductos(HttpServletResponse response, @PathVariable Integer ventaId)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<DetalleVenta> detallesVenta = detalleVentaServicio.obtenerDetallesVenta(ventaId);

		JsonUtils.putJsonDataInResponse(obtenerFiltrosJsonDetalleVenta(),
				detallesVenta, response);
	}
	
	@RequestMapping(value = "/ventas/{ventaId}/detalles", method = RequestMethod.POST)
	public @ResponseBody
	void guardarDetalle(@RequestBody LinkedHashMap<String, Object> data,
			HttpServletResponse response, @PathVariable Integer ventaId)
			throws JsonGenerationException, JsonMappingException, IOException {
		DetalleVenta detalleVenta = new DetalleVenta();
		detalleVenta.setVentaId(ventaId);
		
		Producto producto = new Producto();
		producto.setProductoId(Integer.parseInt((String)data.get("productoId")));
		detalleVenta.setProducto(producto);

		detalleVenta.setCantidad(Integer.parseInt((String)data.get("cantidad")));
    	
		detalleVentaServicio.guardarDetalleVenta(detalleVenta);
		
    	response.setStatus(HttpServletResponse.SC_CREATED);
    }
	
	@RequestMapping(value = "/ventas/{ventaId}/detalles/{detalleId}", method = RequestMethod.DELETE)
	public @ResponseBody
	void eliminarDetalle(HttpServletResponse response, @PathVariable Integer detalleId)
			throws JsonGenerationException, JsonMappingException, IOException {
		detalleVentaServicio.eliminarDetalleVenta(detalleId);
	}
	
	private SimpleFilterProvider obtenerFiltrosJsonDetalleVenta()
			throws JsonGenerationException, JsonMappingException, IOException {
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("filtroJsonDetalleVenta", new FiltroJsonDetalleVenta());
		filters.addFilter("filtroJsonProducto", new FiltroJsonProducto());

		return filters;
	}

}
